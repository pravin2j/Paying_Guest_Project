package com.pj.paying_guest_project.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
	private String name;
	private String street;
	private String city;
	private String state;
	private String pinCode;
}
