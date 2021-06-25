package io.gonzo.middleware.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TransactionsDTO {

    private String regionName;

    private String date;

    private Integer count;

    @Builder
    public TransactionsDTO(String regionName, String date, String count) {
        this.regionName = regionName;
        this.date = date;
        this.count = Integer.valueOf(count);
    }

}
