package com.pj.paying_guest_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayingGuestController {
	@GetMapping("/")
	public String getMessage() {
		return "Hello Test";
	}
}
