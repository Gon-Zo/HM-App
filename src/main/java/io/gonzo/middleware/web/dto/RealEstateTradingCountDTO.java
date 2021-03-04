package io.gonzo.middleware.web.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateTradingCountDTO {

    private String regionNm;

    private String rsRow;

    private List<CountDTO> months;

    public List<CountDTO> getMonths() {

        List<CountDTO> result = new ArrayList<>();

        String[] monthArray = this.rsRow.split("\\|");

        Arrays.stream(monthArray).forEach(month -> {
            String[] dataArray = month.split(",");
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
