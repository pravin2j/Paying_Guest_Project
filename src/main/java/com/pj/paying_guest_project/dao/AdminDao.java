package com.pj.paying_guest_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pj.paying_guest_project.dto.Admin;
import com.pj.paying_guest_project.repo.AdminRepo;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepo adminRepo;
	
	public Admin savAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public Admin updateAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public Admin deleteAdmin(Admin admin) {
		adminRepo.delete(admin);
		return admin;
	}
	
	public Admin getAdminById(int aId) {
		if(adminRepo.findById(aId).isPresent()) {
			return adminRepo.findById(aId).get();
		}
		else {
			return null;
		}
	}
	
	public List<Admin> getAllAdmin(){
		return adminRepo.findAll();
	}
	
	public Admin getAdminByEmail(String aEmail) {
		if(adminRepo.getAdminByEmail(aEmail)!=null) {
			return adminRepo.getAdminByEmail(aEmail);
		}
		else return null;
	}
}
