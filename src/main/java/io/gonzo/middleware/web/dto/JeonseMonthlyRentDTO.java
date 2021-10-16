package io.gonzo.middleware.web.dto;

import lombok.*;

import java.math.BigDecimal;

public class JeonseMonthlyRentDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Default {
        private String year;
        private String courtBuilding;
        private String aguaranteeAmount;
        private String apartment;
        private String monthly;
        private String dedicatedArea;
        private String number;
        private String layer;

        public Integer getYear() {
            return Integer.valueOf(year.trim());
        }

        public String getCourtBuilding() {
            return courtBuilding.trim();
        }

        public BigDecimal getAguaranteeAmount() {
            return BigDecimal.valueOf(Integer.valueOf(aguaranteeAmount.trim().replaceAll("," , "")).longValue());
        }

        public String getApartment() {
            return apartment.trim();
        }

        public Integer getMonthly() {
            return Integer.valueOf(monthly.trim());
        }

        public Double getDedicatedArea() {
            return Double.valueOf(dedicatedArea.trim());
        }

        public String getNumber() {
            return number.trim();
        }

        public Integer getLayer() {
            return Integer.valueOf(layer.trim());
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Store {
        private String region;

        private String date;
    }

}
