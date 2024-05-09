package com.pj.paying_guest_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pj.paying_guest_project.dao.TenantDao;
import com.pj.paying_guest_project.dto.Tenant;
import com.pj.paying_guest_project.exception.EmailNotFoundException;
import com.pj.paying_guest_project.exception.IdNotFoundException;
import com.pj.paying_guest_project.util.ResponseStructure;

@Service
public class TenantService {

	@Autowired
	private TenantDao tenantDao;
	
	ResponseStructure<Tenant> responseStructure = new ResponseStructure<Tenant>();
	
	public ResponseEntity<ResponseStructure<Tenant>> saveTenant(Tenant tenant) {
		if(tenant!=null) {
			LocalDateTime registrationDate = LocalDateTime.now();
			tenant.setRegistrationDate(registrationDate);
			responseStructure.setMessage("Tenant Saved Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(tenantDao.saveTenant(tenant));
			return new ResponseEntity<ResponseStructure<Tenant>>(responseStructure,HttpStatus.CREATED);
		}
		else return null;
	}
	
	public ResponseEntity<ResponseStructure<Tenant>> updateTenant(int tenantId, Tenant tenant) {
		Tenant dbTenant = tenantDao.getTenantById(tenantId);
		if(dbTenant!=null) {
			tenant.setTenantId(tenantId);
			responseStructure.setMessage("Tenant Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(tenantDao.updaTenant(tenant));
			return new ResponseEntity<ResponseStructure<Tenant>>(responseStructure,HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Tenant>> deleteTenant(int tenantId) {
		Tenant dbTenant = tenantDao.getTenantById(tenantId);
		if(dbTenant!=null) {
			responseStructure.setMessage("Tenant Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(tenantDao.deleteTenant(dbTenant));
			return new ResponseEntity<ResponseStructure<Tenant>>(responseStructure,HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Tenant>> getTenantById(int tenantId) {
		Tenant tenant = tenantDao.getTenantById(tenantId);
		if(tenant!=null) {
			responseStructure.setMessage("Tenant found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(tenant);
			return new ResponseEntity<ResponseStructure<Tenant>>(responseStructure,HttpStatus.FOUND);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Tenant>> getTenantByEmail(String tEmail) {
		Tenant tenant = tenantDao.getTenantByEmail(tEmail);
		if(tenant!=null) {
			responseStructure.setMessage("Tenant Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(tenant);
			return new ResponseEntity<ResponseStructure<Tenant>>(responseStructure,HttpStatus.FOUND);
		}
		else throw new EmailNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Tenant>> tenantLogin(String tEmail, String password) {
		Tenant tenant = tenantDao.getTenantByEmail(tEmail);
		if(tenant.getPassword().equals(password)) {
			responseStructure.setMessage("Tenant Logged in Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(tenant);
			return new ResponseEntity<ResponseStructure<Tenant>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("Invalid Email or Password");
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Tenant>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Tenant>>> getAllTenant() {
		ResponseStructure<List<Tenant>> responseStructure=new ResponseStructure<List<Tenant>>();
		if(tenantDao.getAllTenant()!=null) {
			responseStructure.setMessage("Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(tenantDao.getAllTenant());
			return new ResponseEntity<ResponseStructure<List<Tenant>>>(responseStructure,HttpStatus.FOUND);
		}
		else return null;
	}
}

