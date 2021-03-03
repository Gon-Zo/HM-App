package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YearTransactionsDTO {

    private String regionNm;

    private String rsRow;

    private List<CountDTO> years;

    public List<CountDTO> getYears() {

        List<CountDTO> result = new ArrayList<>();

        String[] yearArray = this.rsRow.split("\\|");

        Arrays.stream(yearArray).forEach(year -> {

            String[] dataArray = year.split(",");

            result.add(
                    CountDTO.builder()
                            .title(dataArray[0])
                            .count(dataArray[1])
                            .build()
            );

        });

        return result;
    }

}
