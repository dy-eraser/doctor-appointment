package com.dani.doctorappointment.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApplicationBaseException extends RuntimeException {

    private String code;
    private String message;
    private HttpStatus httpStatus;

    public ApplicationBaseException() {
        super();
    }

    public ApplicationBaseException(Throwable cause) {
        super(cause);
    }

    public ApplicationBaseException(String message) {
        super(message);
    }

    public ApplicationBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationBaseException(String message, String code, HttpStatus status, Throwable cause) {
        super(message, cause);
        throw new ApplicationBaseException(code, message, status);
    }
}
