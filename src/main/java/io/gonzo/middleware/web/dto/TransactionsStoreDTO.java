package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import io.gonzo.middleware.enums.TransactionTypeCodes;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransactionsStoreDTO {

    private String startDate;

    private String endDate;

    private String region;

    @NonNull
    private NationalStatisticTypes apiCode;

    @NonNull
    TransactionTypeCodes typeCode;

}
