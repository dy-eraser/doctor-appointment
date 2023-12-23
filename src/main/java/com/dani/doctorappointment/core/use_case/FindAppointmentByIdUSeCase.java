package com.dani.doctorappointment.core.use_case;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.exception.find.AppointmentNotFoundException;
import com.dani.doctorappointment.core.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAppointmentByIdUSeCase {

    private final AppointmentRepository appointmentRepository;

    public Appointment findOne(Long id) {
        return appointmentRepository.findById(id).orElseThrow(AppointmentNotFoundException::new);
    }
}
