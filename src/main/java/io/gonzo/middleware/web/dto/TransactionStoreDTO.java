package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionStoreDTO {

    private Integer pageNum;

    private String pickDate;

    private String localCode;

    public String getPickDate() {
        return pickDate.replace("-", "");
    }

}
