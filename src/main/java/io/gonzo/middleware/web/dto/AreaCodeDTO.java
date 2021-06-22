package io.gonzo.middleware.web.dto;


import io.gonzo.middleware.enums.AreaCodeTypes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class AreaCodeDTO {

    private Integer index;

    private String code;

    private String title;

    private AreaCodeTypes type;

    private Integer parentsIndex;

    public AreaCodeDTO(Integer index, String code, String title, AreaCodeTypes type, Integer parentsIndex) {
        this.index = index;
        this.code = code;
        this.title = title;
        this.type = type;
        this.parentsIndex = parentsIndex;
    }

}
