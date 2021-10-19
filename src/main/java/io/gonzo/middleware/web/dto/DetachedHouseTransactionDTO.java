package io.gonzo.middleware.web.dto;

import com.sun.istack.NotNull;
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
            return Integer.valueOf(dealAmount.replaceAll(",", ""));
        }

        public BigDecimal getPlottage() {
            return BigDecimal.valueOf(Double.valueOf(plottage));
        }

        public BigDecimal getTotalFloorArea() {
            return BigDecimal.valueOf(Double.valueOf(totalFloorArea));
        }

    }

}
