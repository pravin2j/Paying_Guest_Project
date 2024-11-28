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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
	@NotEmpty(message = "Password Cannot be Null Or Empty")
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{6,}$", message = "Minimum 6 characters mandatory(1 uppercase, 1 lowercase, 1 digit and 1 special character)")
	private String password;
	@NotEmpty(message = "Phone Number cannot be Null or Empty")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits and start with 6-9")
	private String tPhoneNo;
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
