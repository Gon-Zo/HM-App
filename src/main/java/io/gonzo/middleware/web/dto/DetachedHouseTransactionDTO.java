package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.utils.ApiUtils;
import lombok.*;

import java.math.BigDecimal;

public class DetachedHouseTransactionDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Default {

        private String dealAmount;
        private String buildYear;
        private String dealYear;
        private String plottage;
        private String dong;
        private String totalFloorArea;
        private String dealMonth;
        private String dealDay;
        private String houseType;
        private String cancelDealType;
        private String cancelDealDay;

        public Integer getDealAmount() {
            return ApiUtils.integerOf(dealAmount);
        }

        public BigDecimal getPlottage() {
            return ApiUtils.valueOf(plottage);
        }

        public BigDecimal getTotalFloorArea() {
            return ApiUtils.valueOf(totalFloorArea);
        }

    }

}
