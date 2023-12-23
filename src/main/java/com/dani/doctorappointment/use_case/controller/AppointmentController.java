package com.dani.doctorappointment.use_case.controller;

import com.dani.doctorappointment.core.entity.PersonType;
import com.dani.doctorappointment.core.model.AppointmentDto;
import com.dani.doctorappointment.core.model.BookAvailableTimeRequest;
import com.dani.doctorappointment.core.model.CreateOpenTimeRequest;
import com.dani.doctorappointment.use_case.addopentime.AddOpenTimeUseCase;
import com.dani.doctorappointment.use_case.bookopentime.BookAvailableOpenTimeUseCase;
import com.dani.doctorappointment.use_case.deleteopentime.DeleteOpenTimeUseCase;
import com.dani.doctorappointment.use_case.getopentime.GetOpenTimeUseCase;
import com.dani.doctorappointment.use_case.gettakentime.GetTakenTimeByPatientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppointmentController {

    private final AddOpenTimeUseCase addOpenTimeUseCase;
    private final GetOpenTimeUseCase getOpenTimeUseCase;
    private final DeleteOpenTimeUseCase deleteOpenTimeUseCase;
    private final GetTakenTimeByPatientUseCase getTakenTimeByPatientUseCase;
    private final BookAvailableOpenTimeUseCase bookAvailableOpenTimeUseCase;


    @PostMapping("/add-open-times")
    @ResponseStatus(HttpStatus.CREATED)
    // Probably some security features should be implemented too!
    public void addOpenTimes(@Validated @RequestBody CreateOpenTimeRequest openings) {
        addOpenTimeUseCase.add(openings);
    }

    @GetMapping("/get-open-times/{personType}")
    //TODO this could also be broken down into 2 APIs if the need arises
    public ResponseEntity<List<AppointmentDto>> getOpenTimes(@PathVariable PersonType personType) {
        return ResponseEntity.ok(getOpenTimeUseCase.get(personType));
    }

    @DeleteMapping("delete-open-times-by-id/{id}")
    public void deleteOpenTimes(@PathVariable String id) {
        deleteOpenTimeUseCase.delete(id);
    }

    @PatchMapping("/take-open-times")
    public ResponseEntity<AppointmentDto> takeOpenTime(@Validated @RequestBody BookAvailableTimeRequest request) {
        return ResponseEntity.ok(bookAvailableOpenTimeUseCase.book(request));
    }

    @GetMapping("/get-taken-times/{phoneNumber}")
    public ResponseEntity<List<AppointmentDto>> getTakenTimes(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(getTakenTimeByPatientUseCase.get(phoneNumber));
    }
}
