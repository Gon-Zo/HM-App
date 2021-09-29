package io.gonzo.middleware.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppUtils {

    public static String changeToByPicker(String pickDate) {
        return pickDate.replace("-", "");
    }

    public static List<String> changeByPicker12(String pickDate) {

        LocalDate endDate = LocalDate.parse(pickDate + "-01", DateTimeFormatter.ISO_DATE);

        LocalDate startDate = endDate.minusMonths(12);

        long numOfDaysBetween = ChronoUnit.MONTHS.between(startDate, endDate);

        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> convertByLocalDateToString(startDate.plusMonths(i)))
                .collect(Collectors.toList());
    }

    private static String convertByLocalDateToString(LocalDate date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMM");
        String formattedString = date.format(pattern);
        return formattedString;
    }

    public static boolean setYearYn(String codeName){
        return "Year".contains(codeName);
    }

}
