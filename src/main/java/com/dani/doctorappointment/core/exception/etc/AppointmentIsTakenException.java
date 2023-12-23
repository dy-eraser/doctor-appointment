package com.dani.doctorappointment.core.exception.etc;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.APPOINTMENT_IS_TAKEN_EXCEPTION;

public class AppointmentIsTakenException extends ApplicationBaseException {

    public AppointmentIsTakenException() {
        super(
                APPOINTMENT_IS_TAKEN_EXCEPTION.getMessage(),
                APPOINTMENT_IS_TAKEN_EXCEPTION.getErrorCode(),
                APPOINTMENT_IS_TAKEN_EXCEPTION.getHttpStatus()
        );
    }
}
