package com.dani.doctorappointment.core.exception.save;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.SAVE_PATIENT_EXCEPTION;

public class SavePatientException extends ApplicationBaseException {

    public SavePatientException(Throwable cause) {
        super(
                SAVE_PATIENT_EXCEPTION.getMessage(),
                SAVE_PATIENT_EXCEPTION.getErrorCode(),
                SAVE_PATIENT_EXCEPTION.getHttpStatus(),
                cause
        );
    }
}
