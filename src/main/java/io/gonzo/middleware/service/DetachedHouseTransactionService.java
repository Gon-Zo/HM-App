package io.gonzo.middleware.service;

import io.gonzo.middleware.utils.ApiUtils;
import io.gonzo.middleware.web.dto.DetachedHouseTransactionDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class DetachedHouseTransactionService {

    @Value("${app.key}")
    private String key;

    public List<DetachedHouseTransactionDTO.Default> getByDetachedHouseTransaction() {

        String uri = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcSHTrade?";

        StringBuffer sb = new StringBuffer();

        sb.append(uri)
                .append("serviceKey=")
                .append(key)
                .append("&LAWD_CD=")
                .append("11110")
                .append("&DEAL_YMD=")
                .append("201512");

        NodeList nodeList = ApiUtils.getByPublicApiItems(sb.toString());

        return IntStream.range(0, nodeList.getLength())
                .mapToObj(num -> {

                    Node node = nodeList.item(num);

                    Element element = (Element) node;

                    String dealAmount = ApiUtils.getTagValue("거래금액", element);
                    String buildYear = ApiUtils.getTagValue("건축년도", element);
                    String dealYear = ApiUtils.getTagValue("년", element);
                    String plottage = ApiUtils.getTagValue("대지면적", element);
                    String dong = ApiUtils.getTagValue("법정동", element);
                    String totalFloorArea = ApiUtils.getTagValue("연면적", element);
                    String dealMonth = ApiUtils.getTagValue("월", element);
                    String dealDay = ApiUtils.getTagValue("월", element);
                    String houseType = ApiUtils.getTagValue("주택유형", element);
                    String cancelDealType = ApiUtils.getTagValue("해제여부", element);
                    String cancelDealDay = ApiUtils.getTagValue("해제사유발생일", element);

                    return DetachedHouseTransactionDTO.Default.builder()
                            .dealAmount(dealAmount)
                            .buildYear(buildYear)
                            .dealYear(dealYear)
                            .plottage(plottage)
                            .dong(dong)
                            .totalFloorArea(totalFloorArea)
                            .dealMonth(dealMonth)
                            .dealDay(dealDay)
                            .houseType(houseType)
                            .cancelDealType(cancelDealType)
                            .cancelDealDay(cancelDealDay)
                            .build();
                })
                .collect(Collectors.toList());
    }


}
