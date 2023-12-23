package com.dani.doctorappointment.core.use_case;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.entity.AppointmentStatus;
import com.dani.doctorappointment.core.exception.find.FindAllAppointmentException;
import com.dani.doctorappointment.core.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;

    public List<Appointment> findAllByStatus(AppointmentStatus appointmentStatus) {
        try {
            return appointmentRepository.findAllByAppointmentStatus(appointmentStatus);
        } catch (Exception exception) {
            throw new FindAllAppointmentException(exception);
        }
    }
}
