package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.TransactionDTO;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    public List<TransactionDTO> getByTransaction() {

        List<TransactionDTO> result = new ArrayList<>();

        int page = 1;

        try {

            while (true) {

                String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?ServiceKey=0pAYHFBPkd%2BFYQMVlBZnPxCWsbgGCspccauAOqAHVZhVpLec3iEGOFMTNTLWE%2F%2BXny%2B1dEzLcZhAwqvLxJEYFA%3D%3D&pageNo=" + page + "&numOfRows=10&LAWD_CD=11110&DEAL_YMD=201512";

                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();

                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();

                Document doc = dBuilder.parse(url);

                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                NodeList nList = doc.getElementsByTagName("item");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        result.add(
                                TransactionDTO.builder()
                                        .amount(getTagValue("거래금액", eElement).trim())
                                        .apartment(getTagValue("아파트", eElement))
                                        .build()
                        );

                    }

                }

                page += 1;

                System.out.println("page number : " + page);

                if (page > 12) {
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

}
