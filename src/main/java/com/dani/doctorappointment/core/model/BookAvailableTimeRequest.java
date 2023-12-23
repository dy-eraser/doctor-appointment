package com.dani.doctorappointment.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookAvailableTimeRequest {

    @NotNull(message = "appointment ID cannot be empty")
    private String appointmentId;
    @NotNull(message = "phone number cannot be empty")
    private String phoneNumber;
}
