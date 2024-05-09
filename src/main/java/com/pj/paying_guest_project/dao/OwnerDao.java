package com.pj.paying_guest_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pj.paying_guest_project.dto.Owner;
import com.pj.paying_guest_project.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	private OwnerRepo ownerRepo;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner updateOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner deleteOwner(Owner owner) {
		ownerRepo.delete(owner);
		return owner;
	}
	
	public Owner getOwnerById(int ownerId) {
		if(ownerRepo.findById(ownerId).isPresent()) {
			return ownerRepo.findById(ownerId).get();
		}
		else {
			return null;
		}
	}
	
	public Owner getOwnerByEmail(String oEmail) {
		if(ownerRepo.getOwnerByEmail(oEmail)!=null) {
			return ownerRepo.getOwnerByEmail(oEmail);			
		}
		else 
			return null;
	}
	
	public List<Owner> getAllOwner(){
		return ownerRepo.findAll();
	}
	
}
