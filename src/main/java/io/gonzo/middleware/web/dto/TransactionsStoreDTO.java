package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransactionsStoreDTO {

    private String startDate;

    private String endDate;

    private String region;

    private boolean isYear;

    @NonNull
    private NationalStatisticTypes apiCode;

}
