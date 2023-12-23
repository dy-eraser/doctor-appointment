package com.dani.doctorappointment.core.exception.delete;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.CAN_NOT_DELETE_CONCURRENT_APPOINTMENT_EXCEPTION;

public class CanNotDeleteConcurrentAppointmentException extends ApplicationBaseException {

    public CanNotDeleteConcurrentAppointmentException(Throwable cause) {
        super(
                CAN_NOT_DELETE_CONCURRENT_APPOINTMENT_EXCEPTION.getMessage(),
                CAN_NOT_DELETE_CONCURRENT_APPOINTMENT_EXCEPTION.getErrorCode(),
                CAN_NOT_DELETE_CONCURRENT_APPOINTMENT_EXCEPTION.getHttpStatus(),
                cause
        );
    }
}
