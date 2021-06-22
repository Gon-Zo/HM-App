package io.gonzo.middleware.enums;

import lombok.Getter;

public enum AreaCodeTypes {

    P("PARENTS", 0),
    C("CHILD", 1),
    CC("CHILD_CHILD", 2);

    @Getter
    private final String value;

    @Getter
    private final Integer code;

    AreaCodeTypes(String value, Integer code) {
        this.value = value;
        this.code = code;
    }

}
