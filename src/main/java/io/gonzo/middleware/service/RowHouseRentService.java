package io.gonzo.middleware.service;

import io.gonzo.middleware.utils.ApiUtils;
import io.gonzo.middleware.web.dto.RowHouseRentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class RowHouseRentService {

    @Value("${app.key}")
    private String key;

    public List<RowHouseRentDTO.Default> getByRowHouseRent() {

        String uri = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHRent?";

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

                    String buildYear = ApiUtils.getTagValue("거래금액", element);
                    String dealYear = ApiUtils.getTagValue("년", element);
                    String dong = ApiUtils.getTagValue("법정동", element);
                    String deposit = ApiUtils.getTagValue("보증금액", element);
                    String apartmentName = ApiUtils.getTagValue("연립다세대", element);
                    String dealMonth = ApiUtils.getTagValue("월", element);
                    String monthlyRent = ApiUtils.getTagValue("월세금액", element);
                    String dealDay = ApiUtils.getTagValue("일", element);
                    String areaExclusive = ApiUtils.getTagValue("전용면적", element);
                    String jibun = ApiUtils.getTagValue("지번", element);
                    String floor = ApiUtils.getTagValue("층", element);

                    return RowHouseRentDTO.Default.builder()
                            .buildYear(buildYear)
                            .dealYear(dealYear)
                            .dong(dong)
                            .deposit(deposit)
                            .apartmentName(apartmentName)
                            .dealMonth(dealMonth)
                            .monthlyRent(monthlyRent)
                            .dealDay(dealDay)
                            .areaExclusive(areaExclusive)
                            .jibun(jibun)
                            .floor(floor)
                            .build();
                })
                .collect(Collectors.toList());
    }

}
