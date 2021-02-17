package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    // 거래금
    private String amount;

    // 아파트
    private String apartment;

    // 연
    private String year;

    // 월
    private String month;

    // 일
    private String day;

    // 도로명
    private String roadName;

    private String buildingFirstCode;

    private String buildingSecondCode;

    private String buildingCityCoed;

    private String buildingSerialCode;

    private String buildingUndergroundCode;

    private String buildingNameCode;

    private String legalBuilding;

    private String legalBuildingCode;

    private String legalBuildingSecondCode;

    private String legalBuildingCityCode;

    public BigDecimal getAmount() {
        return BigDecimal.valueOf(Long.valueOf(amount.replace(",", "")));
    }

}
