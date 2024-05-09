package com.pj.paying_guest_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pj.paying_guest_project.dto.Admin;
import com.pj.paying_guest_project.service.AdminService;
import com.pj.paying_guest_project.util.ResponseStructure;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestParam int adminId, @RequestBody Admin admin) {
		return adminService.updateAdmin(adminId, admin);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int adminId) {
		return adminService.deleteAdmin(adminId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@RequestParam int adminId) {
		return adminService.getAdminById(adminId);
	}
	
	@GetMapping("/getadminbyemail")
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(@RequestParam String aEmail){
		return adminService.getAdminByEmail(aEmail);
	}
	
	@GetMapping("/adminlogin")
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(@RequestParam String aEmail,@RequestParam String password){
		return adminService.adminLogin(aEmail, password);
	}
	
	@GetMapping("/getalladmin")
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
		return adminService.getAllAdmin();
	}
}
