package com.dani.doctorappointment.use_case.bookopentime;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.entity.AppointmentStatus;
import com.dani.doctorappointment.core.entity.Patient;
import com.dani.doctorappointment.core.exception.delete.CanNotDeleteConcurrentAppointmentException;
import com.dani.doctorappointment.core.exception.etc.AppointmentIsTakenException;
import com.dani.doctorappointment.core.exception.etc.InvalidInputException;
import com.dani.doctorappointment.core.mapper.AppointmentDtoMapper;
import com.dani.doctorappointment.core.model.AppointmentDto;
import com.dani.doctorappointment.core.model.BookAvailableTimeRequest;
import com.dani.doctorappointment.core.use_case.FindAppointmentByIdUSeCase;
import com.dani.doctorappointment.core.use_case.FindPatientByPhoneNumberUseCase;
import com.dani.doctorappointment.core.use_case.SaveAppointmentUseCase;
import jakarta.persistence.OptimisticLockException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookAvailableOpenTimeUseCase {

    private final AppointmentDtoMapper appointmentDtoMapper;
    private final SaveAppointmentUseCase saveAppointmentUseCase;
    private final FindAppointmentByIdUSeCase findAppointmentByIdUSeCase;
    private final FindPatientByPhoneNumberUseCase findPatientByPhoneNumberUseCase;

    public AppointmentDto book(BookAvailableTimeRequest request) {
        Appointment appointment;
        if (NumberUtils.isCreatable(request.getAppointmentId())) {
            appointment = findAppointmentByIdUSeCase.findOne(NumberUtils.createLong(request.getAppointmentId()));
            if (appointment.getAppointmentStatus().equals(AppointmentStatus.TAKEN)) {
                throw new AppointmentIsTakenException();
            }

            Patient patient = findPatientByPhoneNumberUseCase.find(request.getPhoneNumber());
            appointment.setPatient(patient);
            appointment.setAppointmentStatus(AppointmentStatus.TAKEN);
            try {
                saveAppointmentUseCase.save(appointment);
            } catch (OptimisticLockException exception) {
                throw new CanNotDeleteConcurrentAppointmentException(exception);
            }
        } else {
            throw new InvalidInputException();
        }

        return appointmentDtoMapper.toDto(appointment);
    }
}
