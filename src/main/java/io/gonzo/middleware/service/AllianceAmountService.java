package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.AllianceAmountDTO;
import io.gonzo.middleware.web.dto.AllianceAmountStoreDTO;
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
public class AllianceAmountService {

    @Value("${app.key}")
    private String key;

    public List<AllianceAmountDTO> getByAllianceAmountList(AllianceAmountStoreDTO dto) {
        return getUriByAllianceAmount(dto);
    }

    private List<AllianceAmountDTO> getUriByAllianceAmount(AllianceAmountStoreDTO dto) {

        List<AllianceAmountDTO> result = new ArrayList<>();

        try {

            StringBuffer stringBuffer = new StringBuffer();

            String url = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHRent";

            stringBuffer.append(url)
                    .append("?ServiceKey=")
                    .append(key)
                    .append("&LAWD_CD=")
                    .append(dto.getLocalCode())
                    .append("&DEAL_YMD=")
                    .append(dto.getPickDate());

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
                            AllianceAmountDTO.builder()
                                    .amount(getTagValue("보증금액", eElement))
                                    .alliance(getTagValue("연립다세대", eElement))
                                    .courtBuilding(getTagValue("법정동", eElement))
                                    .pickDate(dto.getPickDate())
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
