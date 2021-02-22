package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.TransactionDTO;
import io.gonzo.middleware.web.dto.TransactionStoreDTO;
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

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static io.gonzo.middleware.utils.XmlUtils.getTagValue;

@Service
public class TransactionService {

    @Value("${app.key}")
    private String key;

    public List<TransactionDTO> getByTransactionTrend(TransactionStoreDTO dto) {
        List<TransactionDTO> result = new ArrayList<>();
        dto.getPickDateBy12().forEach(date -> {
            dto.setPickDate(date);
            List<TransactionDTO> tempList = fetchByPublicApiToTransaction(dto);
            result.addAll(tempList);
        });
        return getByResultList(dto, result);
    }

    public List<TransactionDTO> getByTransaction(TransactionStoreDTO dto) {
        List<TransactionDTO> result = fetchByPublicApiToTransaction(dto);
        return getByResultList(dto , result);
    }

    private List<TransactionDTO> fetchByPublicApiToTransaction(TransactionStoreDTO dto){

        List<TransactionDTO> result = new ArrayList<>();

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
                                        .pickDate(dto.getPickDate())
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

    private List<TransactionDTO> getByResultList(TransactionStoreDTO dto, List<TransactionDTO> result) {
        List<TransactionDTO> temp = new ArrayList<>(result);
        if (isNotEmpty(dto.getCourtBuilding()) || isNotEmpty(dto.getApartment())) {
            temp = result.stream().filter(data -> data.isUsed(dto.getCourtBuilding(), dto.getApartment()))
                    .collect(Collectors.toList());
        }
        return temp;
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
