package io.gonzo.middleware.enums;

import lombok.Getter;

public enum ErrorCode {

    SERVER_ERROR("S001", "SERVER_ERROR"),
    NULL_POINT_ERROR("S002", "NULL_POINT_ERROR")
    ;

    @Getter
    private final String code;

    @Getter
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
