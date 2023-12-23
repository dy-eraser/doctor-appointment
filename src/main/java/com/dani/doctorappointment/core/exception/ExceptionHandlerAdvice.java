package com.dani.doctorappointment.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({ApplicationBaseException.class})
    public ResponseEntity<?> handleException(ApplicationBaseException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(
                new ApplicationResponse(exception.getCode(), exception.getMessage())
        );
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class,
            IllegalArgumentException.class,
            MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<?> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @Data
    @AllArgsConstructor
    class ApplicationResponse {
        private String errorCode;
        private String errorMessage;
    }
}
