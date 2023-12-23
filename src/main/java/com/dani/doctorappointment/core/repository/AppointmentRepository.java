package com.dani.doctorappointment.core.repository;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.entity.AppointmentStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {

    List<Appointment> findAllByAppointmentStatus(@NotNull AppointmentStatus appointmentStatus);

    List<Appointment> getAllByPatientPhoneNumber(@NotNull String phoneNumber);
}
