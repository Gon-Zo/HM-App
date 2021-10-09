package io.gonzo.middleware.web.dto.base;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BaseStatisticsDTO {

    private String regionCd;

    private String regionNm;

    private String rsRow;

    @Builder
    public BaseStatisticsDTO(String regionCd, String regionNm, String rsRow) {
        this.regionCd = regionCd;
        this.regionNm = regionNm;
        this.rsRow = rsRow;
    }

}
