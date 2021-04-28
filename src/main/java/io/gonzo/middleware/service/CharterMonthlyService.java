package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.CharterMonthlyDTO;
import io.gonzo.middleware.web.dto.CharterMonthlyStoreDTO;
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
import java.util.stream.Collectors;

import static io.gonzo.middleware.utils.XmlUtils.getTagValue;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Service
public class CharterMonthlyService {

    @Value("${app.key}")
    private String key;

    public List<CharterMonthlyDTO> getByCharterAndMonthly(CharterMonthlyStoreDTO dto){
        List<CharterMonthlyDTO> result = getUriByCharterAndMonthly(dto);
        if(isNotEmpty(dto.getCourtBuilding())){
            return result.stream()
                    .filter(data -> data.getCourtBuilding().equals(dto.getCourtBuilding()))
                    .collect(Collectors.toList());
        }
        return result;
    }

    private List<CharterMonthlyDTO> getUriByCharterAndMonthly(CharterMonthlyStoreDTO dto){

        List<CharterMonthlyDTO> result = new ArrayList<>();

        try {

            StringBuffer stringBuffer = new StringBuffer();

            String url = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent";

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

            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    result.add(
                            CharterMonthlyDTO.builder()
                                    .amount(getTagValue("보증금액", eElement))
                                    .apartment(getTagValue("아파트", eElement))
                                    .monthlyRent(getTagValue("월세금액", eElement))
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
