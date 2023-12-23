package com.dani.doctorappointment.use_case.controller;

import com.dani.doctorappointment.core.model.RegisterPatientRequest;
import com.dani.doctorappointment.use_case.addpatient.RegisterPatientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final RegisterPatientUseCase registerPatientUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody RegisterPatientRequest request) {
        registerPatientUseCase.register(request);
    }
}
