package io.gonzo.middleware.web.dto;

import lombok.*;

import java.util.List;

import static io.gonzo.middleware.utils.DtoUtils.changeToByPicker;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static io.gonzo.middleware.utils.DtoUtils.changeByPicker12;

@Getter
@Setter
@NoArgsConstructor
public class TransactionStoreDTO {

    private Integer pageNum;

    private String pickDate;

    private String localCode;

    private String courtBuilding;

    private String apartment;

    private String regionName;

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

    @Builder
    public TransactionStoreDTO(Integer pageNum, String pickDate, String localCode, String courtBuilding, String apartment, String regionName) {
        this.pageNum = pageNum;
        this.pickDate = pickDate;
        this.localCode = localCode;
        this.courtBuilding = courtBuilding;
        this.apartment = apartment;
        this.regionName = regionName;
    }
}
