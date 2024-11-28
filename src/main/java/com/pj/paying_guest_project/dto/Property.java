package com.pj.paying_guest_project.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	@NotEmpty(message = "Property Name cannot be empty")
	private String propertyName;
	@NotEmpty(message = "Description cannot be empty")
	private String description;
	@NotNull(message = "Rent amount cannot be null")
	private double rent;
	private String availability;
	private int availableRooms;
	private int totalRooms;
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	@Min(value = 1)
	@Max(value = 5)
	private float propertyRating;
	@Column(updatable = false)
	private LocalDateTime createdDate;
	@Embedded
	private Address address;
	@ManyToOne
	private Owner owner;

}
