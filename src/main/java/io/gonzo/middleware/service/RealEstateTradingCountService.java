package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.AllianceAmountDTO;
import io.gonzo.middleware.web.dto.RealEstateTradingCountDTO;
import io.gonzo.middleware.web.dto.RealEstateTradingCountStoreDTO;
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
import static io.gonzo.middleware.utils.XmlUtils.resultCodeByException;

@Service
public class RealEstateTradingCountService {

    @Value("${app.key}")
    private String key;

    public List<RealEstateTradingCountDTO> getByRealEstateTradingCount(RealEstateTradingCountStoreDTO dto) {

        List<RealEstateTradingCountDTO> result = new ArrayList<>();

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
                    .append("01")
            ;

            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();

            Document doc = dBuilder.parse(stringBuffer.toString());

            doc.getDocumentElement().normalize();

            resultCodeByException(doc);

            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    result.add(
                            RealEstateTradingCountDTO.builder()
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
