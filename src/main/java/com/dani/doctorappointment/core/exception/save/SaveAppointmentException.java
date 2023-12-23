package com.dani.doctorappointment.core.exception.save;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.SAVE_APPOINTMENT_EXCEPTION;

public class SaveAppointmentException extends ApplicationBaseException {

    public SaveAppointmentException(Throwable cause) {
        super(
                SAVE_APPOINTMENT_EXCEPTION.getMessage(),
                SAVE_APPOINTMENT_EXCEPTION.getErrorCode(),
                SAVE_APPOINTMENT_EXCEPTION.getHttpStatus(),
                cause
        );
    }
}
