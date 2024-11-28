package com.pj.paying_guest_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pj.paying_guest_project.dto.Property;
import com.pj.paying_guest_project.dto.PropertyType;
import com.pj.paying_guest_project.repo.PropertyRepo;

@Repository
public class PropertyDao {

	@Autowired
	private PropertyRepo propertyRepo;
	
	public Property saveProperty(Property property) {
		return propertyRepo.save(property);
	}
	
	public Property updateProperty(Property property) {
		return propertyRepo.save(property);
	}
	
	public Property deleteProperty(Property property) {
		propertyRepo.delete(property);
		return property;
	}
	
	public Property getPropertyById(int propertyId) {
		if(propertyRepo.findById(propertyId).isPresent()) {
			return propertyRepo.findById(propertyId).get();
		}
		else return null;
	}
	
	public List<Property> getpPropertyByType(PropertyType propertyType) {
		if(propertyRepo.getPropertyByType(propertyType)!=null) {
			return propertyRepo.getPropertyByType(propertyType);
		}
		else return null;
	}
	
	public List<Property> getPropertyByAvailability(String availability) {
		if(propertyRepo.getPropertyByAvailability(availability)!=null) {
			return propertyRepo.getPropertyByAvailability(availability);
		}
		else return null;
	}
	
	public List<Property> getPropertyByName(String propertyName) {
		if(propertyRepo.getPropertiesByName(propertyName)!=null) {
			return propertyRepo.getPropertiesByName(propertyName);
		}
		else return null; 
	}
	
	public List<Property> getPropertyByRentRange(int lowerBound, int upperBound) {
		if(propertyRepo.getPropertyByRentRange(lowerBound, upperBound)!=null) {
			return propertyRepo.getPropertyByRentRange(lowerBound, upperBound);
		}
		else return null;
	}
	
	public List<Property> getPropertyByLocation(String city, String state) {
		if(propertyRepo.getPropertyByLocation(city, state)!=null) {
			return propertyRepo.getPropertyByLocation(city, state);
		}
		else return null;
	}
	
	public List<Property> getAllProperty() {
		return propertyRepo.findAll();
	}
	
}
