package io.gonzo.middleware.service;

import io.gonzo.middleware.web.dto.JeonseMonthlyRentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.gonzo.middleware.utils.ApiUtils.getByPublicApiItems;
import static io.gonzo.middleware.utils.ApiUtils.getTagValue;

@Service
public class JeonseMonthlyRentService {

    @Value("${app.key}")
    private String key;

    public List<JeonseMonthlyRentDTO.Default> getByJenoseMounthlyRent(JeonseMonthlyRentDTO.Store dto) {

        String uri = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent?";

        StringBuffer sb = new StringBuffer();

        sb.append(uri)
                .append("serviceKey=")
                .append(key)
                .append("&LAWD_CD=")
                .append(dto.getRegion())
                .append("&DEAL_YMD=")
                .append(dto.getDate());

        NodeList nodeList = getByPublicApiItems(sb.toString());

        int nodeSize = nodeList.getLength();

        return IntStream.range(0, nodeSize)
                .mapToObj(num -> {

                    Node node = nodeList.item(num);

                    Element element = (Element) node;

                    String dealYear = getTagValue("년", element);
                    String dong = getTagValue("법정동", element);
                    String deposit = getTagValue("보증금액", element);
                    String apartmentName = getTagValue("아파트", element);
                    String dealMonth = getTagValue("월", element);
                    String areaExclusive = getTagValue("전용면적", element);
                    String jibun = getTagValue("지번", element);
                    String floor = getTagValue("층", element);
                    String monthlyRent = getTagValue("월세금액", element);

                    return JeonseMonthlyRentDTO.Default.builder()
                            .dealYear(dealYear)
                            .dong(dong)
                            .deposit(deposit)
                            .apartmentName(apartmentName)
                            .dealMonth(dealMonth)
                            .areaExclusive(areaExclusive)
                            .jibun(jibun)
                            .floor(floor)
                            .monthlyRent(monthlyRent)
                            .build();
                })
                .collect(Collectors.toList());

    }


}
