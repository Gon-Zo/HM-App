package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.gonzo.middleware.utils.DtoUtils.changeToByPicker;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionStoreDTO {

    private Integer pageNum;

    private String pickDate;

    private String localCode;

    private String courtBuilding;

    private String apartment;

    public String getPickDate() {
        return changeToByPicker(this.pickDate);
    }

    public List<String> getPickDateBy12() {

        LocalDate endDate = LocalDate.parse(this.pickDate + "-01", DateTimeFormatter.ISO_DATE);

        LocalDate startDate = endDate.minusMonths(12);

        long numOfDaysBetween = ChronoUnit.MONTHS.between(startDate, endDate);

        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> convertByLocalDateToString(startDate.plusMonths(i)))
                .collect(Collectors.toList());

    }

    private String convertByLocalDateToString(LocalDate date){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMM");
        String formattedString = date.format(pattern);
        return formattedString;
    }

}
