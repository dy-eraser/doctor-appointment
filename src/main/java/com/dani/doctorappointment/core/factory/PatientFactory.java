package com.dani.doctorappointment.core.factory;

import com.dani.doctorappointment.core.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientFactory {

    public Patient getInstanceFromRegistrationRequest(String fullName, String phoneNumber) {
        Patient patient = new Patient();
        patient.setFullName(fullName);
        patient.setPhoneNumber(phoneNumber);
        return patient;
    }
}
