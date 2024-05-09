package com.pj.paying_guest_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pj.paying_guest_project.dao.OwnerDao;
import com.pj.paying_guest_project.dto.Owner;
import com.pj.paying_guest_project.exception.EmailNotFoundException;
import com.pj.paying_guest_project.exception.IdNotFoundException;
import com.pj.paying_guest_project.util.ResponseStructure;

@Service
public class OwnerService {

	@Autowired
	private OwnerDao ownerDao;
	
	ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>();
	
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		if(owner!=null) {
			LocalDateTime registrationDate = LocalDateTime.now();
			owner.setRegistrationDate(registrationDate);
  			responseStructure.setMessage("Owner Saved successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(ownerDao.saveOwner(owner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.CREATED);
		}
		else return null;
	}
	
	public ResponseEntity<ResponseStructure<Owner>> updateOwner(int ownerId, Owner owner) {
		Owner dbOwner = ownerDao.getOwnerById(ownerId);
		if(dbOwner!=null) {
			owner.setOwnerId(ownerId);
			responseStructure.setMessage("Owner Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.updateOwner(owner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Owner>> deleteOwner(int ownerId) {
		Owner owner = ownerDao.getOwnerById(ownerId);
		if(owner!=null) {
			responseStructure.setMessage("Owner Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.deleteOwner(owner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Owner>> getOwnerById(int ownerId) {
		Owner owner = ownerDao.getOwnerById(ownerId);
		if(owner!=null) {
			responseStructure.setMessage("Owner Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(owner);
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Owner>> getOwnerByEmail(String oEmail) {
		Owner owner = ownerDao.getOwnerByEmail(oEmail);
		if(owner!=null) {
			responseStructure.setMessage("Owner found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(owner);
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
		}
		else throw new EmailNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Owner>> ownerLogin(String oEmail, String password) {
		Owner owner = ownerDao.getOwnerByEmail(oEmail);
		if(owner.getPassword().equals(password)) {
			responseStructure.setMessage("Login Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(owner);
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("Invalid Email or Password");
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Owner>>> getAllOwner() {
		ResponseStructure<List<Owner>> responseStructure=new ResponseStructure<List<Owner>>();
		
		if(ownerDao.getAllOwner()!=null) {
			responseStructure.setMessage("Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(ownerDao.getAllOwner());
			return new ResponseEntity<ResponseStructure<List<Owner>>>(responseStructure,HttpStatus.FOUND);
		}
		else return null;
		
	}
}
