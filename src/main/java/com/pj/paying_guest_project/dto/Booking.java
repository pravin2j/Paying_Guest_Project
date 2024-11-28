package com.pj.paying_guest_project.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @ManyToOne
    private Tenant tenant;
    @ManyToOne
    private Property property;
    @Column(nullable = false, updatable = false)
    private LocalDateTime bookingDate;
    @Enumerated(EnumType.STRING)
    private Status bookingStatus;
}
