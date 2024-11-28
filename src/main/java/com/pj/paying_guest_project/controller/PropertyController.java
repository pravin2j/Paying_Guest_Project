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

import com.pj.paying_guest_project.dto.Property;
import com.pj.paying_guest_project.dto.PropertyType;
import com.pj.paying_guest_project.service.PropertyService;
import com.pj.paying_guest_project.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {
	@Autowired
	private PropertyService propertyService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Property>> saveProperty(@Valid @RequestBody Property property, @RequestParam int ownerId) {
		return propertyService.saveProperty(property, ownerId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Property>> updateProperty(@Valid @RequestParam int propertyId, @RequestBody Property property) {
		return propertyService.updateProperty(propertyId, property);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Property>> deleteProperty(@Valid @RequestParam int propertyId) {
		return propertyService.deleteProperty(propertyId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Property>> getPropertyById(@Valid @RequestParam int propertyId) {
		return propertyService.getPropertyById(propertyId);
	}
	
	@GetMapping("/getpropertybytype")
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertyByType(@Valid @RequestParam PropertyType propertyType) {
		return propertyService.getPropertyByType(propertyType);
	}
	
	@GetMapping("/getpropertybyavailability")
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertyByAvailability(@Valid @RequestParam String availability) {
		return propertyService.getPropertyByAvailability(availability);
	}
	
	@GetMapping("/getpropertiesbyname")
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertiesByName(@Valid @RequestParam String propertyName) {
		return propertyService.getPropertiesByName(propertyName);
	}
	
	@GetMapping("/getpropertybyrentrange")
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertyByRentRange(@Valid @RequestParam int lowerBound, @RequestParam int upperBound) {
		return propertyService.getPropertyByRentRange(lowerBound, upperBound);
	}
	
	@GetMapping("/getpropertybylocation")
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertyByLocation(@Valid @RequestParam String city, @RequestParam String state) {
		return propertyService.getPropertyByLocation(city, state);
	}
	
	@GetMapping("/getallproperty")
	public ResponseEntity<ResponseStructure<List<Property>>> getAllProperty() {
		return propertyService.getAllProperty();
	}


}

