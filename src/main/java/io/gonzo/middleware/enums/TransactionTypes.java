package io.gonzo.middleware.enums;

import lombok.Getter;

public enum TransactionTypes {

    NORMAL("N");

    @Getter
    private final String value;

    TransactionTypes(String value) {
        this.value = value;
    }

}
