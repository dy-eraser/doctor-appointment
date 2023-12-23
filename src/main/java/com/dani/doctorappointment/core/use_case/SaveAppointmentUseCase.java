package com.dani.doctorappointment.core.use_case;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.exception.save.SaveAppointmentException;
import com.dani.doctorappointment.core.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;

    public Appointment save(Appointment appointment) {
        try {
            return appointmentRepository.save(appointment);
        } catch (Exception exception) {
            throw new SaveAppointmentException(exception);
        }
    }
}
