package io.gonzo.middleware.web.dto;

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

}
