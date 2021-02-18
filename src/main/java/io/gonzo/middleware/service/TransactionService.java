package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.TransactionDTO;
import io.gonzo.middleware.web.dto.TransactionStoreDTO;
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

    public List<TransactionDTO> getByTransaction(TransactionStoreDTO dto) {

        List<TransactionDTO> result = new ArrayList<>();

        String key = "0pAYHFBPkd%2BFYQMVlBZnPxCWsbgGCspccauAOqAHVZhVpLec3iEGOFMTNTLWE%2F%2BXny%2B1dEzLcZhAwqvLxJEYFA%3D%3D";

        int page = 1;

        int totalCount = 0;

        try {

            while (true) {

                StringBuffer stringBuffer = new StringBuffer();

                stringBuffer.append("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev")
                        .append("?ServiceKey=")
                        .append(key)
                        .append("&pageNo=")
                        .append(page)
                        .append("&numOfRows=")
                        .append(dto.getPageNum())
                        .append("&LAWD_CD=")
                        .append(dto.getLocalCode())
                        .append("&DEAL_YMD=")
                        .append(dto.getPickDate());

                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();

                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();

                Document doc = dBuilder.parse(stringBuffer.toString());

                doc.getDocumentElement().normalize();

                if (page == 1) {
                    totalCount = getBreakCount(doc, dto.getPageNum());
                }

                NodeList nList = doc.getElementsByTagName("item");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        result.add(
                                TransactionDTO.builder()
                                        .amount(getTagValue("거래금액", eElement))
                                        .apartment(getTagValue("아파트", eElement))
                                        .courtBuilding(getTagValue("법정동", eElement))
                                        .build()
                        );

                    }

                }

                page += 1;

                if (page > totalCount) {
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

    private Integer getTotalCount(Document doc) {
        Node node = doc.getElementsByTagName("totalCount").item(0).getFirstChild();
        String nodeValue = node.getNodeValue();
        return Integer.valueOf(nodeValue);
    }

    private int getBreakCount(Document doc , int pageNum) {
        Integer num1 = getTotalCount(doc);
        int num2 = pageNum;
        return (int) Math.ceil((double) num1 / num2);
    }

}
