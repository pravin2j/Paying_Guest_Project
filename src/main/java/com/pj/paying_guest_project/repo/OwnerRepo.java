package com.pj.paying_guest_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pj.paying_guest_project.dto.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer>{

	@Query("Select o from Owner o where o.oEmail=?1")
	public Owner getOwnerByEmail(String oEmail);
}
