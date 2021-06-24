package io.gonzo.middleware.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsStoreDTO {

    private String startMonth;

    private String endMonth;

    private String region;

}
