package io.gonzo.middleware.web.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountDTO {

    private String title;

    private String count;

    public BigDecimal getCount() {
        return BigDecimal.valueOf(Long.valueOf(count));
    }

}
