package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseDTO {

    private String startDate;

    private String endDate;

    private boolean isYear;

    private String type;
}
