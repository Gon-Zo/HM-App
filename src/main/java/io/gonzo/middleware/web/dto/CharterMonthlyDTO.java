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
public class CharterMonthlyDTO {

    // 보증금
    private String amount;

    // 아파트
    private String apartment;

    // 월세금액
    private String monthlyRent;

    // 법정동
    private String courtBuilding;

    private String pickDate;

    public String getCourtBuilding() {
        return courtBuilding.trim();
    }

    public BigDecimal getAmount() {
        return BigDecimal.valueOf(Long.valueOf(this.amount.trim().replace(",", "")));
    }

    public BigDecimal getMonthlyRent() {
        return BigDecimal.valueOf(Long.valueOf(this.monthlyRent.trim().replace(",", "")));
    }

}
