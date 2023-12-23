package com.dani.doctorappointment.core.exception.delete;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.DELETE_APPOINTMENT_EXCEPTION;

public class DeleteAppointmentException extends ApplicationBaseException {

    public DeleteAppointmentException(Throwable cause) {
        super(
                DELETE_APPOINTMENT_EXCEPTION.getMessage(),
                DELETE_APPOINTMENT_EXCEPTION.getErrorCode(),
                DELETE_APPOINTMENT_EXCEPTION.getHttpStatus(),
                cause

        );
    }
}
