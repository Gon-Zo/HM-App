package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import io.gonzo.middleware.enums.TransactionTypeCodes;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class TransactionsDTO {

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
    @SuperBuilder
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
    public static class Store extends BaseStore {
        private String region;
    }

    @Getter
    @Setter
    @SuperBuilder
    public static class NationwideStore extends BaseStore {
    }

}
