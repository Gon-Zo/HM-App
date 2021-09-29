package io.gonzo.middleware.enums;

public enum NationalStatisticTypes {

    //부동산 거래 건수 조회
    RealEstateTradingCount("getRealEstateTradingCount"),
    //부동산 거래 면적 조회
    RealEstateTradingArea("getRealEstateTradingArea"),
    // 연도별 부동산 거래건수 조회
    RealEstateTradingCountYear("getRealEstateTradingCountYear"),
    // 연도별 부동산 거래 면적 조회
    RealEstateTradingAreaYear("getRealEstateTradingAreaYear"),
    //용도지역별 부동산 거래 건수 조회
    RealEstateTradingCountUseDistrict("getRealEstateTradingCountUseDistrict"),
    //용도지역별 부동산 거래 면적 조회
    RealEstateTradingAreaUseDistrict("getRealEstateTradingAreaUseDistrict"),
    //지목별 부동산 거래 건수 조회
    RealEstateTradingCountJiMok("getRealEstateTradingCountJiMok"),
    //지목별 부동산 거래 면적 조회
    RealEstateTradingAreaJiMok("getRealEstateTradingAreaJiMok"),
    //매입자거주지별 부동산 거래 건수 조회
    RealEstateTradingCountResidence("getRealEstateTradingCountResidence"),
    //매입자거주지별 부동산 거래 면적 조회
    RealEstateTradingAreaResidence("getRealEstateTradingAreaResidence"),
    //거래주체별 부동산 거래 건수 조회
    RealEstateTradingCountDealer("getRealEstateTradingCountDealer"),
    //거래주체별 부동산 거래 면적 조회
    RealEstateTradingAreaDealer("getRealEstateTradingAreaDealer"),
    //규모별 부동산 거래 건수 조회
    RealEstateTradingCountSize("getRealEstateTradingCountSize"),
    //규모별 부동산 거래 면적 조회
    RealEstateTradingAreaSize("getRealEstateTradingAreaSize"),
    //거래원인별 부동산 거래 건수 조회
    RealEstateTradingCountReason("getRealEstateTradingCountReason"),
    //거래원인별 부동산 거래 면적 조회
    RealEstateTradingAreaReason("getRealEstateTradingAreaReason"),
    //건물유형별 부동산 거래 건수 조회
    RealEstateTradingCountBuildType("getRealEstateTradingCountBuildType"),
    //건물유형별 부동산 거래 면적 조회
    RealEstateTradingAreaBuildType("getRealEstateTradingAreaBuildType"),
    //토지거래허가처리별 부동산 거래 면적 조회
    RealEstateTradingAreaPermission("getRealEstateTradingAreaPermission"),
    //외국인거래 건수 조회
    RealEstateTradingCountForeigner("getRealEstateTradingCountForeigner"),
    //외국인 거래 면적 조회
    RealEstateTradingAreaForeigner("getRealEstateTradingAreaForeigner"),
    //신탁/신탁해지별 부동산 거래 건수 조회
    RealEstateTradingCountTrust("getRealEstateTradingCountTrust"),
    //신탁/신탁해지별 부동산 거래 면적 조회
    RealEstateTradingAreaTrust("getRealEstateTradingAreaTrust"),
    //연도별 용도지역별 부동산 거래건수 조회
    RealEstateTradingCountTypeUseDistrictYear("getRealEstateTradingCountTypeUseDistrictYear"),
    //연도별 지목별 부동산 거래 건수 조회
    RealEstateTradingCountTypeJiMokYear("getRealEstateTradingCountTypeJiMokYear"),
    //연도별 매입자거주지별 부동산 거래 건수 조회
    RealEstateTradingCountTypeResidenceYear("getRealEstateTradingCountTypeResidenceYear"),
    //연도별 용도지역별 부동산 거래 면적 조회
    RealEstateTradingAreaTypeUseDistrictYear("getRealEstateTradingAreaTypeUseDistrictYear"),
    //연도별 지목별 부동산 거래 면적 조회
    RealEstateTradingAreaTypeJiMokYear("getRealEstateTradingAreaTypeJiMokYear"),
    //연도별 매입자거주지별 거래 면적 조회
    RealEstateTradingAreaTypeResidenceYear("getRealEstateTradingAreaTypeResidenceYear"),
    //연도별 거래주체별 거래 건수 조회
    RealEstateTradingCountTypeDealerYear("getRealEstateTradingCountTypeDealerYear"),
    //연도별 거래주체별 거래 면적 조회
    RealEstateTradingAreaTypeDealerYear("getRealEstateTradingAreaTypeDealerYear"),
    //연도별 거래규모별 거래 건수 조회
    RealEstateTradingCountTypeSizeYear("getRealEstateTradingCountTypeSizeYear"),
    //연도별 거래규모별 거래 면적 조회
    RealEstateTradingAreaTypeSizeYear("getRealEstateTradingAreaTypeSizeYear"),
    //연도별 거래원인별 거래 건수 조회
    RealEstateTradingCountTypeReasonYear("getRealEstateTradingCountTypeReasonYear"),
    //연도별 거래원인별 거래 면적 조회
    RealEstateTradingAreaTypeReasonYear("getRealEstateTradingAreaTypeReasonYear"),
    //연도별 건물유형별 거래 건수 조회
    RealEstateTradingCountTypeBuildTypeYear("getRealEstateTradingCountTypeBuildTypeYear"),
    //연도별 건물 유형별 거래 면적 조회
    RealEstateTradingAreaTypeBuildTypeYear("getRealEstateTradingAreaTypeBuildTypeYear"),
    //연도별 토지거래허가 처리별 거래 건수 조회
    RealEstateTradingCountTypePermissionYear("getRealEstateTradingCountTypePermissionYear"),
    //연도별 토지거래허가 처리별 거래 면적 조회
    RealEstateTradingAreaTypePermissionYear("getRealEstateTradingAreaTypePermissionYear"),
    //연도별 외국인거래 거래 건수 조회
    RealEstateTradingCountTypeForeignerYear("getRealEstateTradingCountTypeForeignerYear"),
    //연도별 외국인거래 거래 면적 조회
    RealEstateTradingAreaTypeForeignerYear("getRealEstateTradingAreaTypeForeignerYear"),
    //연도별 신탁/신탁해지 거래 건수 조회
    RealEstateTradingCountTypeTrustYear("getRealEstateTradingCountTypeTrustYear"),
    //연도별 신탁/신탁해지 거래 면적 조회
    RealEstateTradingAreaTypeTrustYear("getRealEstateTradingAreaTypeTrustYear");

    private String value;

    NationalStatisticTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
