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

}
