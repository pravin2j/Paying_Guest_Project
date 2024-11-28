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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	@NotEmpty(message = "Owner Name cannot be empty.")
	private String firstName;
	@NotEmpty(message = "Owner Name cannot be empty.")
	private String lastName;
	@Column(updatable = false)
	@NotEmpty(message = "Owner Email Cannot be Null Or Empty")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String oEmail;
	private String password;
	@NotEmpty(message = "Phone Number cannot be Null or Empty")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits and start with 6-9")
	private String oPhoneNo;
	@Column(updatable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(updatable = false)
	private String dateOfBirth;
	private String profileUrl;
	@Column(updatable = false)
	private LocalDateTime registrationDate;
	@Embedded
	private Address address;
}
