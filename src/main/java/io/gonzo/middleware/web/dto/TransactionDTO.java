package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private String amount;

    private String apartment;

    public Integer getAmount() {
        return Integer.valueOf(amount.replace("," ,""));
    }

}
