package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import io.gonzo.middleware.enums.TransactionTypeCodes;
import io.gonzo.middleware.web.dto.base.BaseTransactionsStoreDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class TransactionsStoreDTO {

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    public static class Default extends BaseTransactionsStoreDTO {
        private String region;

        public Default(String startDate, String endDate, @NonNull NationalStatisticTypes apiCode, @NonNull TransactionTypeCodes typeCode, String region) {
            super(startDate, endDate, apiCode, typeCode);
            this.region = region;
        }

        public Default(String region) {
            this.region = region;
        }

        public Default(BaseTransactionsStoreDTOBuilder<?, ?> b, String region) {
            super(b);
            this.region = region;
        }
    }

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    public static class Nationwide extends BaseTransactionsStoreDTO {
    }

}
