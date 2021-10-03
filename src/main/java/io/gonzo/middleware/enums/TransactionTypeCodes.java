package io.gonzo.middleware.enums;

import lombok.Getter;

public enum TransactionTypeCodes {

    //토지 거래
    LAND_TRANSACTION("01"),
    //순수 토지 거래
    PURE_LAND_TRANSACTION("02"),
    //건축물 거래
    BUILDING_TRADE("03"),
    //주택 거래
    HOUSING_TRANSACTION("04"),
    //아파트 거래
    APARTMENT_TRANSACTION("05"),
    //주택 매매 거래
    HOUSING_SALE_TRANSACTION("06"),
    //아파트 매매 거래
    APARTMENT_SALE_TRANSACTION("07");

    @Getter
    private String value;

    TransactionTypeCodes(String value) {
        this.value = value;
    }
}
