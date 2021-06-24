package io.gonzo.middleware.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TransactionsDTO {

    private String title;

    private String yearMonth;

    private String count;

    public TransactionsDTO(String title, String yearMonth, String count) {
        this.title = title;
        this.yearMonth = yearMonth;
        this.count = count;
    }

    @Builder
    public TransactionsDTO(String regionNm, String rsRow) {
        String[] arrayOfResRow = rsRow.split(",");
        this.title = regionNm;
        this.yearMonth = arrayOfResRow[0];
        this.count = arrayOfResRow[1];
    }

}
