package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.web.dto.base.BaseTransactionsDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class TransactionsStoreDTO extends BaseTransactionsDTO {
    private String region;
}
