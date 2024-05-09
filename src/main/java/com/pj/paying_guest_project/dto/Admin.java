package com.pj.paying_guest_project.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotEmpty(message = "Admin Name cannot be empty")
	private String adminName;
	@Column(updatable = false)
	@NotEmpty(message = "Admin Email Cannot be Null Or Empty")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String aEmail;
	@NotEmpty(message = "Password Cannot be Null Or Empty")
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{6,}$", message = "Minimum 6 characters mandatory(1 uppercase, 1 lowercase, 1 digit and 1 special character)")
	private String password;
	@Column(updatable = false)
	private LocalDateTime registrationDate;
}
