package com.pj.paying_guest_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pj.paying_guest_project.dto.Booking;
import com.pj.paying_guest_project.repo.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepo bookingRepo;
	
	public Booking saveBooking(Booking booking) {
		return bookingRepo.save(booking);
	}
	
	public Booking updateBooking(Booking booking) {
		return bookingRepo.save(booking);
	}
	
	public Booking deleteBooking(Booking booking) {
		bookingRepo.delete(booking);
		return booking;
	}
	
	public Booking getBookingById(int bookingId) {
		if(bookingRepo.findById(bookingId).isPresent()) {
			return bookingRepo.findById(bookingId).get();
		}
		else return null;
	}
	
	public List<Booking> getAllBooking() {
		return bookingRepo.findAll();
	}
	
}
