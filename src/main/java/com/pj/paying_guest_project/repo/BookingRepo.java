package com.pj.paying_guest_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pj.paying_guest_project.dto.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
