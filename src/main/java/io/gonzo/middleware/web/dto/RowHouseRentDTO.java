package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.utils.ApiUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public class RowHouseRentDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Default {
        private String buildYear;
        private String dealYear;
        private String dong;
        private String deposit;
        private String apartmentName;
        private String dealMonth;
        private String monthlyRent;
        private String dealDay;
        private String areaExclusive;
        private String jibun;
        private String floor;

        public Integer getDeposit() {
            return ApiUtils.integerOf(deposit);
        }

        public BigDecimal getAreaExclusive() {
            return ApiUtils.valueOf(areaExclusive);
        }
    }

}
