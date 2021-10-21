package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import io.gonzo.middleware.enums.TransactionTypeCodes;
import io.gonzo.middleware.utils.ApiUtils;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.ObjectUtils;

public class TransactionsDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    //RealEstateTradingCountDealer
    public static class RETCD {

        private Integer month;
        private Integer total;
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;
        private Integer e;
        private Integer f;
        private Integer g;
        private Integer h;
        private Integer i;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Default {

        private String regionName;

        private String date;

        private Integer count;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Base {
        private String regionCd;

        private String regionNm;

        private String rsRow;
    }

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BaseStore {

        private String startDate;

        private String endDate;

        @NonNull
        private NationalStatisticTypes apiCode;

        @NonNull
        private TransactionTypeCodes typeCode;

    }

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    public static class DefaultStore extends BaseStore {
        private String region;

        private Long trending;

        @Override
        public String getStartDate() {

            if (ObjectUtils.isEmpty(this.trending)) {
                return super.getStartDate();
            }

            return ApiUtils.createByTrendingDate(super.getEndDate(), trending);
        }
    }

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    public static class NationwideStore extends BaseStore {
    }

}
