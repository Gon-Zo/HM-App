package io.gonzo.middleware.web.dto;

import com.sun.istack.NotNull;
import lombok.*;


import java.math.BigDecimal;

public class ApartmentRentDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Default {

        private String dealYear;
        private String dong;
        private String deposit;
        private String apartmentName;
        private String dealMonth;
        private String areaExclusive;
        private String jibun;
        private String floor;
        private String monthlyRent;

        public Integer getDealYear() {
            return Integer.valueOf(dealYear);
        }

        public BigDecimal getDeposit() {
            return BigDecimal.valueOf(Integer.valueOf(deposit.replaceAll(",", "")).longValue());
        }

        public Integer getDealMonth() {
            return Integer.valueOf(dealMonth);
        }

        public Double getAreaExclusive() {
            return Double.valueOf(areaExclusive);
        }

        public Integer getFloor() {
            return Integer.valueOf(floor.trim());
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Store {

        @NotNull
        private String region;

        @NotNull
        private String date;

    }

}
