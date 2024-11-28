package com.pj.paying_guest_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pj.paying_guest_project.dto.Booking;
import com.pj.paying_guest_project.service.BookingService;
import com.pj.paying_guest_project.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> aveBooking(@Valid @RequestBody Booking booking, @RequestParam int tenantId, @RequestParam int porpertyId)  {
		return bookingService.saveBooking(booking, tenantId, porpertyId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@Valid @RequestBody Booking booking, @RequestParam int bookingId) {
		return bookingService.updateBooking(booking, bookingId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@Valid @RequestParam int bookingId) {
		return bookingService.deleteBooking(bookingId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@Valid @RequestParam int bookingId) {
		return bookingService.getBookingById(bookingId);
	}
	
	@GetMapping("/getallbooking")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBooking(){
		return bookingService.getAllBooking();
	}
	
	@PutMapping("/cancelbooking")
	public ResponseEntity<ResponseStructure<Booking>> cancelBooking(@Valid @RequestParam int bookingId) {
		return bookingService.cancelBooking(bookingId);
	}

}
