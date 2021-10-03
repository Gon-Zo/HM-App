package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import io.gonzo.middleware.enums.TransactionTypeCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.NonNullApi;

@Getter
@Setter
@AllArgsConstructor
public class NationwideTransactionStoreDTO {

    private String startDate;

    private String endDate;

    @NonNull
    private NationalStatisticTypes apiCode;

    @NonNull
    private TransactionTypeCodes typeCode;
}
