package com.dani.doctorappointment.use_case.getopentime;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.entity.AppointmentStatus;
import com.dani.doctorappointment.core.entity.PersonType;
import com.dani.doctorappointment.core.mapper.AppointmentDtoMapper;
import com.dani.doctorappointment.core.model.AppointmentDto;
import com.dani.doctorappointment.core.use_case.FindAllAppointmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOpenTimeUseCase {

    private final AppointmentDtoMapper appointmentDtoMapper;
    private final FindAllAppointmentUseCase findAllAppointmentUseCase;

    public List<AppointmentDto> get(PersonType personType) {
        List<Appointment> appointmentList = findAllAppointmentUseCase.findAllByStatus(
                personType.equals(PersonType.DOCTOR) ? AppointmentStatus.TAKEN : AppointmentStatus.FREE
        );
        return appointmentDtoMapper.toDtoList(appointmentList);
    }
}
