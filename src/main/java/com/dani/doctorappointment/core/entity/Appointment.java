package com.dani.doctorappointment.core.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointment")
@EntityListeners(AuditingEntityListener.class)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;
    @Column(length = 10, columnDefinition = "varchar(10) default 'FREE'")
    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus appointmentStatus = AppointmentStatus.FREE;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Version
    private int version; // handles concurrency in an optimistic manner
}
