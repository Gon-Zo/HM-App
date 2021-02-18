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

    // 법정동
    private String courtBuilding;

    public BigDecimal getAmount() {
        return BigDecimal.valueOf(Long.valueOf(this.amount.trim().replace(",", "")));
    }

    public String getCourtBuilding() {
        return courtBuilding.trim();
    }

}
