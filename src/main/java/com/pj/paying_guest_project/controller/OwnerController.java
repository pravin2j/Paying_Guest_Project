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

import com.pj.paying_guest_project.dto.Owner;
import com.pj.paying_guest_project.service.OwnerService;
import com.pj.paying_guest_project.util.ResponseStructure;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Owner>> updateOwner(@RequestParam int ownerId, @RequestBody Owner owner) {
		return ownerService.updateOwner(ownerId, owner);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Owner>> deleteOwner(@RequestParam int ownerId) {
		return ownerService.deleteOwner(ownerId); 
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Owner>> getOwnerById(@RequestParam int ownerId) {
		return ownerService.getOwnerById(ownerId);
	}
	
	@GetMapping("/getownerbyemail")
	public ResponseEntity<ResponseStructure<Owner>> getOwnerByEmail(@RequestParam String oEmail){
		return ownerService.getOwnerByEmail(oEmail);
	}
	
	@GetMapping("/ownerlogin")
	public ResponseEntity<ResponseStructure<Owner>> ownerLogin(@RequestParam String oEmail,@RequestParam String password){
		return ownerService.ownerLogin(oEmail, password);
	}
	
	@GetMapping("/getallowner")
	public ResponseEntity<ResponseStructure<List<Owner>>> getAllOwner() {
		return ownerService.getAllOwner();
	}
}
