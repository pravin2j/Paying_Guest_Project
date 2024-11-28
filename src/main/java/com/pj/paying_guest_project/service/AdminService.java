package com.pj.paying_guest_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pj.paying_guest_project.dao.AdminDao;
import com.pj.paying_guest_project.dto.Admin;
import com.pj.paying_guest_project.exception.EmailNotFoundException;
import com.pj.paying_guest_project.exception.IdNotFoundException;
import com.pj.paying_guest_project.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		if(admin!=null) {
			LocalDateTime registrationDate = LocalDateTime.now();
			admin.setRegistrationDate(registrationDate);
			responseStructure.setMessage("Admin Saved Successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(adminDao.savAdmin(admin));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);
		}
		else return null;
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int adminId, Admin admin) {
		Admin dbAdmin = adminDao.getAdminById(adminId);
		admin.setRegistrationDate(dbAdmin.getRegistrationDate());
		if(dbAdmin!=null) {
			admin.setAdminId(adminId);
			responseStructure.setMessage("Admin Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(adminDao.updateAdmin(admin));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int adminId) {
		Admin dbAdmin = adminDao.getAdminById(adminId);
		if(dbAdmin!=null) {
			responseStructure.setMessage("Admin Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(adminDao.deleteAdmin(dbAdmin));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	//
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int adminId) {
		Admin admin = adminDao.getAdminById(adminId);
		if(admin!=null) {
			responseStructure.setMessage("Admin found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String aEmail) {
		Admin admin = adminDao.getAdminByEmail(aEmail);
		if(admin!=null) {
			responseStructure.setMessage("Admin Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);
		}
		else throw new EmailNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(String aEmail, String password) {
		Admin admin = adminDao.getAdminByEmail(aEmail);
		if(admin.getPassword().equals(password)) {
			responseStructure.setMessage("Admin Logged in Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("Invalid Email or Password");
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
		ResponseStructure<List<Admin>> responseStructure=new ResponseStructure<List<Admin>>();
		if(adminDao.getAllAdmin()!=null) {
			responseStructure.setMessage("Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(adminDao.getAllAdmin());
			return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure,HttpStatus.FOUND);
		}
		else return null;
	}
}
