package io.gonzo.middleware.web.dto;

import lombok.*;

public class TransactionsDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Default {

        private String regionName;

        private String date;

        private Integer count;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Base {
        private String regionCd;

        private String regionNm;

        private String rsRow;
    }

}
