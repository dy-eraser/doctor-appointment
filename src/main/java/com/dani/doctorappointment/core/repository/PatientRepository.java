package com.dani.doctorappointment.core.repository;

import com.dani.doctorappointment.core.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.phoneNumber = :phoneNumber")
    Optional<Patient> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
