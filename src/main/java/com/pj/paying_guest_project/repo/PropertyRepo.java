package com.pj.paying_guest_project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pj.paying_guest_project.dto.Property;
import com.pj.paying_guest_project.dto.PropertyType;


public interface PropertyRepo extends JpaRepository<Property, Integer>{

	@Query("Select p from Property p where p.propertyType=?1")
	public List<Property> getPropertyByType(PropertyType propertyType);
	
	@Query("Select p from Property p where p.availability=?1")
	public List<Property> getPropertyByAvailability(String availability);
	
	@Query("SELECT property FROM Property property WHERE property.propertyName LIKE %:propertyName%")
	public List<Property> getPropertiesByName(String propertyName);
	
	@Query("Select p from Property p where p.rent between ?1 and ?2")
	public List<Property> getPropertyByRentRange(int lowerBound, int upperBound);
	
	@Query("SELECT p FROM Property p WHERE p.address.city = ?1 AND p.address.state = ?2")
	public List<Property> getPropertyByLocation(String city,String state);
}
