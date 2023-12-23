package com.dani.doctorappointment.core.exception.etc;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.INVALID_INPUT_EXCEPTION;

public class InvalidInputException extends ApplicationBaseException {

    public InvalidInputException() {
        super(
                INVALID_INPUT_EXCEPTION.getMessage(),
                INVALID_INPUT_EXCEPTION.getErrorCode(),
                INVALID_INPUT_EXCEPTION.getHttpStatus()
        );
    }
}
