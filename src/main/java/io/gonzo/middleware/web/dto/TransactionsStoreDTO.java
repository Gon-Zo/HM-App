package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.web.dto.base.BaseTransactionsDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class TransactionsStoreDTO  {

    @Getter
    @Setter
    @SuperBuilder
    public static class Default extends BaseTransactionsDTO{
        private String region;
    }

    @Getter
    @Setter
    @SuperBuilder
    public static class Nationwide extends BaseTransactionsDTO {

    }

}
