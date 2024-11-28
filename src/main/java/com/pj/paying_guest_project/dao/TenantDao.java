package com.pj.paying_guest_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pj.paying_guest_project.dto.Tenant;
import com.pj.paying_guest_project.repo.TenantRepo;

@Repository
public class TenantDao {
	@Autowired
	private TenantRepo tenantRepo;
	
	public Tenant saveTenant(Tenant tenant) {
		return tenantRepo.save(tenant);
	}
	
	public Tenant updaTenant(Tenant tenant) {
		return tenantRepo.save(tenant);
	}
	
	public Tenant deleteTenant(Tenant tenant) {
		tenantRepo.delete(tenant);
		return tenant;
	}
	
	public Tenant getTenantById(int tenantId) {
		if(tenantRepo.findById(tenantId).isPresent()) {
			return tenantRepo.findById(tenantId).get();
		}
		else {
			 return null;
		}
	}
	
	public Tenant getTenantByEmail(String tEmail) {
		if(tenantRepo.getTenantByEmail(tEmail)!=null) {
			return tenantRepo.getTenantByEmail(tEmail);
		}
		else {
			return null;
		}
	}
	
	public List<Tenant> getAllTenant(){
		return tenantRepo.findAll();
	}
}
