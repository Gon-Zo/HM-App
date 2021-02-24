package io.gonzo.middleware.web.dto;

import lombok.*;

import static io.gonzo.middleware.utils.DtoUtils.changeToByPicker;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllianceAmountStoreDTO {

    private String localCode;

    private String pickDate;

    public String getPickDate() {
        return changeToByPicker(pickDate);
    }

}
