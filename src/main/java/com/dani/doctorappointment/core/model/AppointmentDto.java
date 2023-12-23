package com.dani.doctorappointment.core.model;

import com.dani.doctorappointment.core.entity.AppointmentStatus;

import java.time.LocalDateTime;

public record AppointmentDto(
        Long id,
        LocalDateTime endTime,
        LocalDateTime startTime,
        AppointmentStatus appointmentStatus,

        PatientDto patient,

        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}