package com.dani.doctorappointment.core.mapper;

import com.dani.doctorappointment.core.entity.Patient;
import com.dani.doctorappointment.core.model.PatientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientDtoMapper {

    PatientDto toDto(Patient patient);
}
