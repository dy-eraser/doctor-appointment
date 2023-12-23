package com.dani.doctorappointment.use_case.gettakentime;

import com.dani.doctorappointment.core.mapper.AppointmentDtoMapper;
import com.dani.doctorappointment.core.model.AppointmentDto;
import com.dani.doctorappointment.core.use_case.FindAllAppointmentByPhoneNumberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTakenTimeByPatientUseCase {

    private final AppointmentDtoMapper appointmentDtoMapper;
    private final FindAllAppointmentByPhoneNumberUseCase searchAppointmentBySampleUseCase;

    public List<AppointmentDto> get(String phoneNumber) {
        return appointmentDtoMapper.toDtoList(
                searchAppointmentBySampleUseCase.find(phoneNumber)
        );
    }
}
