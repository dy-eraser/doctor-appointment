package com.dani.doctorappointment.use_case.addopentime;

import com.dani.doctorappointment.core.entity.Appointment;
import com.dani.doctorappointment.core.exception.etc.AddOpenTimeMalformedException;
import com.dani.doctorappointment.core.model.CreateOpenTimeRequest;
import com.dani.doctorappointment.core.use_case.SaveAppointmentUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddOpenTimeUseCase {

    @Value("${appointment.time.slot.in.minutes:30}")
    private long timeSlot;

    private final SaveAppointmentUseCase saveAppointmentUseCase;

    @Async
    @Transactional
    public void add(CreateOpenTimeRequest openings) {

        LocalDateTime start = LocalDateTime.of(openings.getVisitDate(), openings.getStartTime());
        LocalDateTime end = LocalDateTime.of(openings.getVisitDate(), openings.getEndTime());
        log.info("An opening start: {} and end: {} were received.", start, end);
        if (openings.isStartAfterEndTime()) {
            throw new AddOpenTimeMalformedException();
        }

        int i = 0;
        while (start.plusMinutes(timeSlot).isBefore(end)) {
            Appointment appointment = new Appointment();
            appointment.setStartTime(start);
            appointment.setEndTime(start.plusMinutes(timeSlot));
            saveAppointmentUseCase.save(appointment);

            start = start.plusMinutes(timeSlot);
            i++;
        }

        log.info("Accumulated number of {} openings added.", i);
    }
}
