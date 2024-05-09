package com.pj.paying_guest_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class PayingGuestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayingGuestProjectApplication.class, args);
	}

}
