package com.dani.doctorappointment.core.repository;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.entity.AppointmentStatus;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByAppointmentStatus(@NotNull AppointmentStatus appointmentStatus);

    List<Appointment> getAllByPatientPhoneNumber(@NotNull String phoneNumber);
}
