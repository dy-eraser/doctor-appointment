package com.dani.doctorappointment.core.exception.find;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.APPOINTMENT_NOT_FOUNT_EXCEPTION;

public class AppointmentNotFoundException extends ApplicationBaseException {

    public AppointmentNotFoundException() {
        super(
                APPOINTMENT_NOT_FOUNT_EXCEPTION.getMessage(),
                APPOINTMENT_NOT_FOUNT_EXCEPTION.getErrorCode(),
                APPOINTMENT_NOT_FOUNT_EXCEPTION.getHttpStatus()
        );
    }
}
