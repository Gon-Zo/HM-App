package io.gonzo.middleware.configuration.error;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
public class ErrorDTO {

    private final String code;

    private final String message;

    private final String detailMessage;

    private final Instant createDate;

    @Builder
    public ErrorDTO(String code, String message, String detailMessage, Instant createDate) {
        this.code = code;
        this.message = message;
        this.detailMessage = detailMessage;
        this.createDate = createDate;
    }

}
