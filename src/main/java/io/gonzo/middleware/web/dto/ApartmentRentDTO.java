package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.utils.ApiUtils;
import lombok.*;


public class ApartmentRentDTO {

    @Getter
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
            return ApiUtils.integerOf(dealYear);
        }

        public Integer getDeposit() {
            return ApiUtils.integerOf(deposit);
        }

        public Integer getDealMonth() {
            return Integer.valueOf(dealMonth);
        }

        public Double getAreaExclusive() {
            return Double.valueOf(areaExclusive);
        }

        public Integer getFloor() {
            return Integer.valueOf(floor);
        }

    }

}
