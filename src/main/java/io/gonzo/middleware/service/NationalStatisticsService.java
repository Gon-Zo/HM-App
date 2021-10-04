package io.gonzo.middleware.service;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import io.gonzo.middleware.utils.AppUtils;
import io.gonzo.middleware.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static io.gonzo.middleware.utils.XmlUtils.getTagValue;
import static io.gonzo.middleware.utils.XmlUtils.resultCodeByException;

@Slf4j
@Service
@RequiredArgsConstructor
public class NationalStatisticsService {

    @Value("${app.key}")
    private String key;

    private final AreaCodeService areaCodeService;

    /**
     * [전국 조회] 부동산 거래 건수 조회
     *
     * @param dto
     * @return
     */
    public List<TransactionsDTO> getNumberOfTransactionsByNationwide(NationwideTransactionStoreDTO dto) {

        List<IAreaCodeParents> parentsList = areaCodeService.getByParentsTypeAreaList();

        String startMonth = dto.getStartDate();

        String endMonth = dto.getEndDate();

        NationalStatisticTypes apiCode = dto.getApiCode();

        return parentsList
                .stream()
                .map(parents -> getNumberOfTransactions(TransactionsStoreDTO.builder()
                                .startDate(startMonth)
                                .endDate(endMonth)
                                .apiCode(apiCode)
                                .region(parents.getCode())
                                .typeCode(dto.getTypeCode())
                                .build()
                        , AppUtils.setYearYn(dto.getApiCode().name())))
                .flatMap(Collection::parallelStream)
                .collect(Collectors.toList());
    }

    /**
     * 부동산 거래 건수 조회
     *
     * @param dto
     * @return
     */
    public List<TransactionsDTO> getNumberOfTransactions(TransactionsStoreDTO dto, boolean isYear) {

        List<TransactionsDTO> result = new ArrayList<>();

        try {

            StringBuffer stringBuffer = new StringBuffer();

            String url = "http://openapi.reb.or.kr/OpenAPI_ToolInstallPackage/service/rest/RealEstateTradingSvc/";

            url += dto.getApiCode().getValue();

            // todo : api 별로 파라미터 바꾸기
            stringBuffer.append(url)
                    .append("?ServiceKey=")
                    .append(key)
                    .append(getByDateFormat(isYear, dto.getStartDate(), Boolean.TRUE))
                    .append(getByDateFormat(isYear, dto.getEndDate(), Boolean.FALSE))
                    .append("&region=")
                    .append(dto.getRegion())
                    .append("&tradingtype=")
                    .append(dto.getTypeCode().getValue());

            log.info("URI::===> {}", stringBuffer);

            String publicUrl = stringBuffer.toString();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(publicUrl);

            doc.getDocumentElement().normalize();

            resultCodeByException(doc);

            NodeList nList = doc.getElementsByTagName("item");

            int itemSize = nList.getLength();

            for (int temp = 0; temp < itemSize; temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String rsRow = getTagValue("rsRow", eElement);

                    String regionNm = getTagValue("regionNm", eElement);

                    List<TransactionsDTO> transactionsList = Arrays.stream(rsRow.split("\\|"))
                            .map(countData -> {

                                String[] arrayOfRsRow = countData.split(",");

                                String standardDate = passerByStandardDate(arrayOfRsRow[0], isYear);

                                return TransactionsDTO.builder()
                                        .regionName(regionNm)
                                        .date(standardDate)
                                        .count(arrayOfRsRow[1])
                                        .build();
                            })
                            .collect(Collectors.toList());

                    result.addAll(transactionsList);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private String passerByStandardDate(String standardDate, boolean isYear) {

        if (isYear == Boolean.TRUE) {
            return standardDate;
        }

        int standardDateSize = standardDate.length();

        return standardDate.substring(0, 4) + "-" + standardDate.substring(4, standardDateSize);
    }

    private String getByDateFormat(boolean isYear, String dateStr, boolean isStart) {

        String format;

        if (isStart && isYear) {
            format = "&startyear=%s";
        } else if (isStart && !isYear) {
            format = "&startmonth=%s";
        } else if (!isStart && isYear) {
            format = "&endyear=%s";
        } else {
            format = "&endmonth=%s";
        }

        dateStr = isYear ? dateStr.substring(0, 4) : dateStr;

        return String.format(format, dateStr);
    }

}
