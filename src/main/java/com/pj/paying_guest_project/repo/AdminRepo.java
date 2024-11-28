package com.pj.paying_guest_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pj.paying_guest_project.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	@Query("Select a from Admin a where a.aEmail=?1")
	public Admin getAdminByEmail(String aEmail);
}
