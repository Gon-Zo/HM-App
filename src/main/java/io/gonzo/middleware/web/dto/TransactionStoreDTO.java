package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static io.gonzo.middleware.utils.DtoUtils.changeToByPicker;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static io.gonzo.middleware.utils.DtoUtils.changeByPicker12;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionStoreDTO {

    private Integer pageNum;

    private String pickDate;

    private String localCode;

    private String courtBuilding;

    private String apartment;

    public String getPickDate() {
        return changeToByPicker(this.pickDate);
    }

    public List<String> getPickDateBy12() {
        return changeByPicker12(this.pickDate);
    }

    public Integer getPageNum() {
        if (isEmpty(this.pageNum)) {
            return 100;
        }
        return pageNum;
    }

}
