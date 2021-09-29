package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.enums.NationalStatisticTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NationwideTransactionStoreDTO {

    private String startDate;

    private String endDate;

    private NationalStatisticTypes apiCode;

}
