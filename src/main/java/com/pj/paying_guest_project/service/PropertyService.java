package com.pj.paying_guest_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pj.paying_guest_project.dao.OwnerDao;
import com.pj.paying_guest_project.dao.PropertyDao;
import com.pj.paying_guest_project.dto.Owner;
import com.pj.paying_guest_project.dto.Property;
import com.pj.paying_guest_project.dto.PropertyType;
import com.pj.paying_guest_project.exception.AvailabilityNotFoundException;
import com.pj.paying_guest_project.exception.IdNotFoundException;
import com.pj.paying_guest_project.exception.NoPropertyFoundException;
import com.pj.paying_guest_project.exception.TypeNotFoundException;
import com.pj.paying_guest_project.util.ResponseStructure;

@Service
public class PropertyService {
	@Autowired
	private OwnerDao ownerDao;
	@Autowired
	private PropertyDao propertyDao;
	
	ResponseStructure<Property> responseStructure = new ResponseStructure<Property>();
	ResponseStructure<List<Property>> responseStructure2 = new ResponseStructure<List<Property>>();
	
	public ResponseEntity<ResponseStructure<Property>> saveProperty(Property property, int ownerId){
		Owner owner = ownerDao.getOwnerById(ownerId);
		if(owner!=null) {
			property.setOwner(owner);
			LocalDateTime createdDate = LocalDateTime.now();
			property.setCreatedDate(createdDate);
			if(property!=null) {
				responseStructure.setMessage("Property Saved Successfully");
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setData(propertyDao.saveProperty(property));
				return new ResponseEntity<ResponseStructure<Property>>(responseStructure,HttpStatus.CREATED);
			}
			else return null;
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Property>> updateProperty(int propertyId, Property property) {
		Property dbProperty = propertyDao.getPropertyById(propertyId);
		if(dbProperty!=null) {
			property.setPropertyId(propertyId);
			property.setOwner(dbProperty.getOwner());
			responseStructure.setMessage("Property Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(propertyDao.updateProperty(property));
			return new ResponseEntity<ResponseStructure<Property>>(responseStructure, HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Property>> deleteProperty(int propertyId) {
		Property property = propertyDao.getPropertyById(propertyId);
		if(property!=null) {
			responseStructure.setMessage("Property Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(propertyDao.deleteProperty(property));
			return new ResponseEntity<ResponseStructure<Property>>(responseStructure, HttpStatus.OK);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Property>> getPropertyById(int propertyId) {
		Property property = propertyDao.getPropertyById(propertyId);
		if(property!=null) {
			responseStructure.setMessage("Property Found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(property);
			return new ResponseEntity<ResponseStructure<Property>>(responseStructure, HttpStatus.FOUND);
		}
		else throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertyByType(PropertyType propertyType) {
		List<Property> listOfProperty = propertyDao.getpPropertyByType(propertyType);
		if(listOfProperty!=null) {
			responseStructure2.setMessage("Found Successfully");
			responseStructure2.setStatus(HttpStatus.FOUND.value());
			responseStructure2.setData(listOfProperty);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure2, HttpStatus.FOUND);
		}
		else throw new TypeNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertyByAvailability(String availability) {
		List<Property> listOfProperty = propertyDao.getPropertyByAvailability(availability);
		if(listOfProperty!=null ) {
			responseStructure2.setMessage("Found Successfully");
			responseStructure2.setStatus(HttpStatus.FOUND.value());
			responseStructure2.setData(listOfProperty);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure2, HttpStatus.FOUND);
		}
		else throw new AvailabilityNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertiesByName(String propertyName) {
		List<Property> listOfProperties = propertyDao.getPropertyByName(propertyName);
		if(listOfProperties!=null) {
			responseStructure2.setMessage("Found Successfully");
			responseStructure2.setStatus(HttpStatus.FOUND.value());
			responseStructure2.setData(listOfProperties);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure2, HttpStatus.FOUND);
		}
		else throw new NoPropertyFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertyByRentRange(int lowerBound, int upperBound) {
		List<Property> listOfProperties = propertyDao.getPropertyByRentRange(lowerBound, upperBound);
		if(listOfProperties!=null) {
			responseStructure2.setMessage("Found Successfully");
			responseStructure2.setStatus(HttpStatus.FOUND.value());
			responseStructure2.setData(listOfProperties);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure2, HttpStatus.FOUND);
		}
		else return null;
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> getPropertyByLocation(String city, String state) {
		List<Property> listOfProperties = propertyDao.getPropertyByLocation(city, state);
		if(listOfProperties!=null) {
			responseStructure2.setMessage("Found Successfully");
			responseStructure2.setStatus(HttpStatus.FOUND.value());
			responseStructure2.setData(listOfProperties);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure2, HttpStatus.FOUND);
		}
		else return null;
	}
	
	public ResponseEntity<ResponseStructure<List<Property>>> getAllProperty() {
		List<Property> listOfProperties = propertyDao.getAllProperty();
		if(listOfProperties!=null) {
			responseStructure2.setMessage("Found Successfully");
			responseStructure2.setStatus(HttpStatus.FOUND.value());
			responseStructure2.setData(listOfProperties);
			return new ResponseEntity<ResponseStructure<List<Property>>>(responseStructure2, HttpStatus.FOUND);
		}
		else return null;
	}
	
	
	
}
