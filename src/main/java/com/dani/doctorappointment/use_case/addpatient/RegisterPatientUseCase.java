package com.dani.doctorappointment.use_case.addpatient;

import com.dani.doctorappointment.core.factory.PatientFactory;
import com.dani.doctorappointment.core.model.RegisterPatientRequest;
import com.dani.doctorappointment.core.use_case.SavePatientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterPatientUseCase {

    private final PatientFactory patientFactory;
    private final SavePatientUseCase savePatientUseCase;

    public void register(RegisterPatientRequest request) {
        savePatientUseCase.save(
                patientFactory.getInstanceFromRegistrationRequest(request.getFullName(), request.getPhoneNumber())
        );
    }
}
