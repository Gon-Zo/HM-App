package io.gonzo.middleware.web.dto.base;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import io.gonzo.middleware.enums.TransactionTypeCodes;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseTransactionsStoreDTO {

    private String startDate;

    private String endDate;

    @NonNull
    private NationalStatisticTypes apiCode;

    @NonNull
    private TransactionTypeCodes typeCode;
}
