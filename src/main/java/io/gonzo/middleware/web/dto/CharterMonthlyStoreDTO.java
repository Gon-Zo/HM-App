package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static io.gonzo.middleware.utils.DtoUtils.changeToByPicker;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharterMonthlyStoreDTO {

    private String pickDate;

    private String localCode;

    private String courtBuilding;

    private String regionName;

    public String getPickDate() {
        return changeToByPicker(this.pickDate);
    }

}
