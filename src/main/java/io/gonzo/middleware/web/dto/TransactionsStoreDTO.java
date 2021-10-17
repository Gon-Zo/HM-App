package io.gonzo.middleware.web.dto;

import io.gonzo.middleware.utils.ApiUtils;
import io.gonzo.middleware.web.dto.base.BaseTransactionsStoreDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TransactionsStoreDTO {

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    public static class Default extends BaseTransactionsStoreDTO {

        private String region;

        private Long trending;

        @Override
        public String getStartDate() {

            if (ObjectUtils.isEmpty(this.trending)) {
                return super.getStartDate();
            }

            return ApiUtils.createByTrendingDate(super.getStartDate(), trending);
        }

    }

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    public static class Nationwide extends BaseTransactionsStoreDTO {
    }

}
