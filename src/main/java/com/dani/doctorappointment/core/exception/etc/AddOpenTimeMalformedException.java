package com.dani.doctorappointment.core.exception.etc;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.OPENING_TIME_MALFORMED_ARRANGEMENT_EXCEPTION;

public class AddOpenTimeMalformedException extends ApplicationBaseException {

    public AddOpenTimeMalformedException() {
        super(
                OPENING_TIME_MALFORMED_ARRANGEMENT_EXCEPTION.getMessage(),
                OPENING_TIME_MALFORMED_ARRANGEMENT_EXCEPTION.getErrorCode(),
                OPENING_TIME_MALFORMED_ARRANGEMENT_EXCEPTION.getHttpStatus()
        );
    }
}
