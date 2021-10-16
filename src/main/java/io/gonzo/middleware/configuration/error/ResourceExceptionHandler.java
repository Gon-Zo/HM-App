package io.gonzo.middleware.configuration.error;

import io.gonzo.middleware.enums.ErrorCode;
import io.gonzo.middleware.configuration.error.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;

import static io.gonzo.middleware.enums.ErrorCode.*;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        ex.printStackTrace();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<Object> handleConflict(NullPointerException ex, WebRequest request) {

        ErrorCode error = NULL_POINT_ERROR;

        ex.printStackTrace();

        ErrorDTO dto = ErrorDTO.builder()
                .code(error.getCode())
                .message(error.getMessage())
                .detailMessage(getStackTracePasserToString(ex))
                .createDate(Instant.now())
                .build();

        return handleExceptionInternal(ex, dto, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private String getStackTracePasserToString(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

}
