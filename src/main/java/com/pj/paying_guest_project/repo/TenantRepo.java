package com.pj.paying_guest_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pj.paying_guest_project.dto.Tenant;

public interface TenantRepo extends JpaRepository<Tenant, Integer> {

	@Query("select t from Tenant t where t.tEmail=?1")
	public Tenant getTenantByEmail(String tEmail);
	

}
