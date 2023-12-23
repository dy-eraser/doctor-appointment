package com.dani.doctorappointment.core.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "patient")
@EntityListeners(AuditingEntityListener.class)
public class Patient {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "full_name", nullable = false)
        private String fullName;
        @Column(name = "phone_number", nullable = false, unique = true)
        private String phoneNumber;

        @CreatedDate
        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt;
        @LastModifiedDate
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;
}

