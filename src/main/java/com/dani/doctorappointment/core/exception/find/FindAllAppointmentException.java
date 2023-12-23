package com.dani.doctorappointment.core.exception.find;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.FIND_ALL_APPOINTMENT_EXCEPTION;

public class FindAllAppointmentException extends ApplicationBaseException {

    public FindAllAppointmentException(Throwable cause) {
        super(
                FIND_ALL_APPOINTMENT_EXCEPTION.getErrorCode(),
                FIND_ALL_APPOINTMENT_EXCEPTION.getMessage(),
                FIND_ALL_APPOINTMENT_EXCEPTION.getHttpStatus(),
                cause
        );
    }
}
