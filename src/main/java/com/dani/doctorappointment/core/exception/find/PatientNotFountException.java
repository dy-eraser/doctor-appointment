package com.dani.doctorappointment.core.exception.find;

import com.dani.doctorappointment.core.exception.ApplicationBaseException;

import static com.dani.doctorappointment.core.exception.GenericEnumException.PATIENT_NOT_FOUNT_EXCEPTION;

public class PatientNotFountException extends ApplicationBaseException {

    public PatientNotFountException() {
        super(
                PATIENT_NOT_FOUNT_EXCEPTION.getErrorCode(),
                PATIENT_NOT_FOUNT_EXCEPTION.getMessage(),
                PATIENT_NOT_FOUNT_EXCEPTION.getHttpStatus()
        );
    }
}
