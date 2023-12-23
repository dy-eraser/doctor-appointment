package com.dani.doctorappointment.core.use_case;

import com.dani.doctorappointment.core.exception.delete.DeleteAppointmentException;
import com.dani.doctorappointment.core.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAppointmentByIdUseCase {

    private final AppointmentRepository appointmentRepository;

    public void delete(Long id) {
        try {
            appointmentRepository.deleteById(id);
        } catch (Exception exception) {
            throw new DeleteAppointmentException(exception);
        }
    }
}
