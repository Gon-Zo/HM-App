package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.AreaCodeDTO;
import io.gonzo.middleware.web.dto.BaseDTO;
import io.gonzo.middleware.web.dto.TransactionsDTO;
import io.gonzo.middleware.web.dto.TransactionsStoreDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static io.gonzo.middleware.utils.XmlUtils.getTagValue;
import static io.gonzo.middleware.utils.XmlUtils.resultCodeByException;

@Service
public class NationalStatisticsService {

    @Value("${app.key}")
    private String key;

    private AreaCodeService areaCodeService;

    // [전국 조회] 부동산 거래 건수 조회
    public List<TransactionsDTO> getNumberOfTransactionsByAll(BaseDTO dto) {

        List<AreaCodeDTO> parentsList = areaCodeService.getAreaCodeToParents();

        String startMonth = dto.getStartMonth();

        String endMonth = dto.getEndMonth();

        return parentsList.stream().map(parents ->
                getNumberOfTransactions(
                        TransactionsStoreDTO.builder()
                                .startMonth(startMonth)
                                .endMonth(endMonth)
                                .region(parents.getCode())
                                .build()
                ))
                .flatMap(Collection::parallelStream)
                .collect(Collectors.toList());
    }

    // 부동산 거래 건수 조회
    public List<TransactionsDTO> getNumberOfTransactions(TransactionsStoreDTO dto) {
        List<TransactionsDTO> result = new ArrayList<>();

        try {

            StringBuffer stringBuffer = new StringBuffer();

            String url = "http://openapi.reb.or.kr/OpenAPI_ToolInstallPackage/service/rest/RealEstateTradingSvc/getRealEstateTradingCount";

            stringBuffer.append(url)
                    .append("?ServiceKey=")
                    .append(key)
                    .append("&startmonth=")
                    .append(dto.getStartMonth())
                    .append("&endmonth=")
                    .append(dto.getEndMonth())
                    .append("&region=")
                    .append(dto.getRegion())
                    .append("&tradingtype=")
                    .append("01");

            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();

            Document doc = dBuilder.parse(stringBuffer.toString());

            doc.getDocumentElement().normalize();

            resultCodeByException(doc);

            NodeList nList = doc.getElementsByTagName("item");

            int itemSize = nList.getLength();

            for (int temp = 0; temp < itemSize; temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    result.add(
                            TransactionsDTO.builder()
                                    .regionNm(getTagValue("regionNm", eElement))
                                    .rsRow(getTagValue("rsRow", eElement))
                                    .build()
                    );

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
