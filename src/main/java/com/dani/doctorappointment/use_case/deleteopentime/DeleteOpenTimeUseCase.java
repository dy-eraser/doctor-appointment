package com.dani.doctorappointment.use_case.deleteopentime;

import com.dani.doctorappointment.core.entity.AppointmentStatus;
import com.dani.doctorappointment.core.exception.delete.CanNotDeleteConcurrentAppointmentException;
import com.dani.doctorappointment.core.exception.etc.AppointmentIsTakenException;
import com.dani.doctorappointment.core.exception.etc.InvalidInputException;
import com.dani.doctorappointment.core.use_case.DeleteAppointmentByIdUseCase;
import com.dani.doctorappointment.core.use_case.FindAppointmentByIdUSeCase;
import jakarta.persistence.OptimisticLockException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOpenTimeUseCase {

    private final FindAppointmentByIdUSeCase findAppointmentByIdUSeCase;
    private final DeleteAppointmentByIdUseCase deleteAppointmentByIdUseCase;

    public void delete(String id) {
        if (NumberUtils.isCreatable(id)) {
            if (findAppointmentByIdUSeCase.findOne(NumberUtils.createLong(id))
                    .getAppointmentStatus().equals(AppointmentStatus.TAKEN)) {
                throw new AppointmentIsTakenException();
            }
            try {
                deleteAppointmentByIdUseCase.delete(NumberUtils.createLong(id));
            } catch (OptimisticLockException exception) {
                throw new CanNotDeleteConcurrentAppointmentException(exception);
            }
        } else {
            throw new InvalidInputException();
        }
    }
}
