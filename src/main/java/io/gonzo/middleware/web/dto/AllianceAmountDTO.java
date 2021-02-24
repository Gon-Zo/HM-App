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
public class AllianceAmountDTO {

    private String amount;

    private String alliance;

    private String pickDate;

    private String courtBuilding;

    public BigDecimal getAmount() {
        return BigDecimal.valueOf(Long.valueOf(this.amount.trim().replace(",", "")));
    }

    public String getCourtBuilding() {
        return courtBuilding.trim();
    }

}
