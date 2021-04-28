package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.YearTransactionsDTO;
import io.gonzo.middleware.web.dto.YearTransactionsStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

import static io.gonzo.middleware.utils.XmlUtils.getTagValue;

@Service
@RequiredArgsConstructor
public class YearTransactionsService {

    @Value("${app.key}")
    private final String key;

    public List<YearTransactionsDTO> getByYearTransactions(YearTransactionsStoreDTO dto) {

        List<YearTransactionsDTO> result = new ArrayList<>();

        try {

            StringBuffer stringBuffer = new StringBuffer();

            String url = "http://openapi.reb.or.kr/OpenAPI_ToolInstallPackage/service/rest/RealEstateTradingSvc/getRealEstateTradingCountYear";

            stringBuffer.append(url)
                    .append("?ServiceKey=")
                    .append(key)
                    .append("&startyear=")
                    .append(dto.getStartYear())
                    .append("&endyear=")
                    .append(dto.getEndYear())
                    .append("&region=")
                    .append(dto.getRegion())
                    .append("&tradingtype=")
                    .append("01")
            ;

            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();

            Document doc = dBuilder.parse(stringBuffer.toString());

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    result.add(
                            YearTransactionsDTO.builder()
                                    .rsRow(getTagValue("rsRow", eElement))
                                    .regionNm(getTagValue("regionNm", eElement))
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
