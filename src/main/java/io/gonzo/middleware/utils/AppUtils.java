package io.gonzo.middleware.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppUtils {

    private static String convertByLocalDateToString(LocalDate date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMM");
        String formattedString = date.format(pattern);
        return formattedString;
    }

    public static boolean setYearYn(String codeName) {
        return codeName.contains("Year");
    }

}
