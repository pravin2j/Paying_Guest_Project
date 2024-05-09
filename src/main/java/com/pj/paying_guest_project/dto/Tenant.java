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
import lombok.Data;

@Entity
@Data
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tenantId;
	@NotEmpty(message = "First name cannot be empty")
	private String firstName;
	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;
	@Column(updatable = false)
	@NotEmpty(message = "Email Cannot be Null Or Empty")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String tEmail;
	private String password;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long tPhoneNo;
	@Column(updatable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(updatable = false)
	private String dateOfBirth;
	private String profileUrl;
	@NotEmpty(message = "Institute name cannot be empty")
	private String instituteName;
	@Column(updatable = false)
	private LocalDateTime registrationDate;
	@Embedded
	private Address address;
}
