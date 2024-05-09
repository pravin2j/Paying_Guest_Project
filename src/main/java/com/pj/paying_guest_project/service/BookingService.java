package com.pj.paying_guest_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pj.paying_guest_project.dao.BookingDao;
import com.pj.paying_guest_project.dao.PropertyDao;
import com.pj.paying_guest_project.dao.TenantDao;
import com.pj.paying_guest_project.dto.Booking;
import com.pj.paying_guest_project.dto.Property;
import com.pj.paying_guest_project.dto.Status;
import com.pj.paying_guest_project.dto.Tenant;
import com.pj.paying_guest_project.exception.IdNotFoundException;
import com.pj.paying_guest_project.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private TenantDao tenantDao;
	ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();
	
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking, int tenantId, int porpertyId) {
		Property property = propertyDao.getPropertyById(porpertyId);
		property.setAvailableRooms(property.getAvailableRooms()-1);
		if(property.getAvailableRooms()<=0) {
			property.setAvailability("N");
		}
		if(property!=null) {
			Property property2 = propertyDao.updateProperty(property);
			Tenant tenant = tenantDao.getTenantById(tenantId);
			booking.setProperty(property2);
			booking.setTenant(tenant);
			LocalDateTime bookingDate = LocalDateTime.now();
			booking.setBookingDate(bookingDate);
			responseStructure.setMessage("Booking Successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(bookingDao.saveBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.CREATED);
		}
		else return null;
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking, int bookingId) {
		Booking dBooking=bookingDao.getBookingById(bookingId);
		if(dBooking!=null) {
			booking.setBookingId(bookingId);
			booking.setTenant(dBooking.getTenant());
			booking.setProperty(dBooking.getProperty());
			booking.setBookingDate(dBooking.getBookingDate());
			responseStructure.setMessage("Booking Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(bookingDao.updateBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bookingId){
		Booking booking=bookingDao.getBookingById(bookingId);
		if(booking!=null) {
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(bookingDao.deleteBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(int bookingId){
		Booking booking=bookingDao.getBookingById(bookingId);
		if(booking!=null) {
			responseStructure.setMessage("Booking Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(bookingDao.getBookingById(bookingId));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.FOUND);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBooking(){
		ResponseStructure<List<Booking>> responseStructure=new ResponseStructure<List<Booking>>();
		if(bookingDao.getAllBooking()!=null) {
			responseStructure.setMessage("Booking Found Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(bookingDao.getAllBooking());
			return new ResponseEntity<ResponseStructure<List<Booking>>>(responseStructure,HttpStatus.OK);
		}
		else return null;
	}
	
	public ResponseEntity<ResponseStructure<Booking>> cancelBooking(int bookingId) {
		Booking booking=bookingDao.getBookingById(bookingId);
		if(booking!=null) {
			Property property = booking.getProperty();
			property.setAvailableRooms(property.getAvailableRooms()+1);
			if(property.getAvailableRooms()>0) 
				property.setAvailability("Y");
			booking.setProperty(property);
			booking.setBookingStatus(Status.CANCELLED);
			responseStructure.setMessage("Booking Cancelled Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(bookingDao.updateBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
}
