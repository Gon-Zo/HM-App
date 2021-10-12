package io.gonzo.middleware.web.dto;


import io.gonzo.middleware.enums.AreaCodeTypes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

public class AreaCodeDTO {

    @Setter
    @Getter
    @SuperBuilder
    @NoArgsConstructor
    public static class Default {

        private Integer index;

        private String code;

        private String title;

        private AreaCodeTypes type;

        private Integer parentsIndex;

        public Default(Integer index, String code, String title, AreaCodeTypes type, Integer parentsIndex) {
            this.index = index;
            this.code = code;
            this.title = title;
            this.type = type;
            this.parentsIndex = parentsIndex;
        }
    }

    @Getter
    @SuperBuilder
    public static class Store extends Default {
        @Setter
        private List<AreaCodeDTO> childList;
    }

    public interface IAreaCodeParents {

        Long getId();

        String getCode();

        String getName();

        String getType();

    }

}
