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

import com.pj.paying_guest_project.dto.Tenant;
import com.pj.paying_guest_project.service.TenantService;
import com.pj.paying_guest_project.util.ResponseStructure;

@RestController
@RequestMapping("/tenant")
public class TenantController {
	@Autowired
	private TenantService tenantService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Tenant>> saveTenant(@RequestBody Tenant tenant) {
		return tenantService.saveTenant(tenant);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Tenant>> updateTenant(@RequestParam int tenantId,@RequestBody Tenant tenant) {
		return tenantService.updateTenant(tenantId, tenant);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Tenant>> deleteTenant(@RequestParam int tenantId) {
		return tenantService.deleteTenant(tenantId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Tenant>> getTenantById(@RequestParam int tenantId) {
		return tenantService.getTenantById(tenantId);
	}
	
	@GetMapping("/gettenantbyemail")
	public ResponseEntity<ResponseStructure<Tenant>> getTenantByEmail(@RequestParam String tEmail){
		return tenantService.getTenantByEmail(tEmail);
	}
	
	@GetMapping("/tenantlogin")
	public ResponseEntity<ResponseStructure<Tenant>> tenantLogin(@RequestParam String tEmail, @RequestParam String password) {
		return tenantService.tenantLogin(tEmail, password);
	}
	
	@GetMapping("/getalltenant")
	public ResponseEntity<ResponseStructure<List<Tenant>>> getAllTenant() {
		return tenantService.getAllTenant();
	}
}
