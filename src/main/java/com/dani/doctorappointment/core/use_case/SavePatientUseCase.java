package com.dani.doctorappointment.core.use_case;

import com.dani.doctorappointment.core.entity.Patient;
import com.dani.doctorappointment.core.exception.save.SavePatientException;
import com.dani.doctorappointment.core.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePatientUseCase {

    private final PatientRepository patientRepository;

    public Patient save(Patient patient) {
        try {
            return patientRepository.save(patient);
        } catch (Exception exception) {
            throw new SavePatientException(exception);
        }
    }
}
