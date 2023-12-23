package com.dani.doctorappointment.core.mapper;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.model.AppointmentDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentDtoMapper {

    AppointmentDto toDto(Appointment appointment);
    Appointment toEntity(AppointmentDto appointmentDto);

    List<AppointmentDto> toDtoList(List<Appointment> appointmentList);
    default Page<AppointmentDto> toPage(Page<Appointment> appointmentPage) {
        return appointmentPage.map(this::toDto);
    }
}
