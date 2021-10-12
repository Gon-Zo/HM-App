package io.gonzo.middleware.web.dto.base;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import io.gonzo.middleware.enums.TransactionTypeCodes;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BaseTransactionsDTO {

    private String startDate;

    private String endDate;

    @NonNull
    private NationalStatisticTypes apiCode;

    @NonNull
    private TransactionTypeCodes typeCode;

}
