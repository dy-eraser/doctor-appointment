package com.dani.doctorappointment.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterPatientRequest {

    @NotNull(message = "patient name cannot be empty")
    private String fullName;
    @NotNull(message = "phone number cannot be empty")
    private String phoneNumber;
}
