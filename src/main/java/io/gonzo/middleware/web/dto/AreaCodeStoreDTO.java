package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.enums.AreaCodeTypes;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class AreaCodeStoreDTO extends AreaCodeDTO {

    @Setter
    private List<AreaCodeDTO> childList;

    public AreaCodeStoreDTO(Integer index, String code, String title, AreaCodeTypes type, Integer parentsIndex , List<AreaCodeDTO> childList) {
        super(index, code, title, type, parentsIndex);
        this.childList = childList;
    }

}
