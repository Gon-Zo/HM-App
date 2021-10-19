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
            return Integer.valueOf(dealYear.trim());
        }

        public String getDong() {
            return dong.trim();
        }

        public BigDecimal getDeposit() {
            return BigDecimal.valueOf(Integer.valueOf(deposit.trim().replaceAll(",", "")).longValue());
        }

        public String getApartmentName() {
            return apartmentName.trim();
        }

        public Integer getDealMonth() {
            return Integer.valueOf(dealMonth.trim());
        }

        public Double getAreaExclusive() {
            return Double.valueOf(areaExclusive.trim());
        }

        public String getJibun() {
            return jibun.trim();
        }

        public Integer getFloor() {
            return Integer.valueOf(floor.trim());
        }

        public String getMonthlyRent() {
            return monthlyRent.trim();
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
