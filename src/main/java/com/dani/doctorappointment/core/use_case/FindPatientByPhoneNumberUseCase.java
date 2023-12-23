package com.dani.doctorappointment.core.use_case;

import com.dani.doctorappointment.core.entity.Patient;
import com.dani.doctorappointment.core.exception.find.PatientNotFountException;
import com.dani.doctorappointment.core.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPatientByPhoneNumberUseCase {

    private final PatientRepository patientRepository;

    public Patient find(String phoneNumber) {
        return patientRepository.findByPhoneNumber(phoneNumber).orElseThrow(PatientNotFountException::new);
    }
}
