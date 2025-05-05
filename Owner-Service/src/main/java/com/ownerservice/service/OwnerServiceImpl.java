package com.ownerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ownerservice.exception.OwnerNotFoundException;
import com.ownerservice.models.Owner;
import com.ownerservice.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public Owner addOwner(Owner owner) {
		// TODO Auto-generated method stub
		
		return ownerRepository.save(owner);
	}

	@Override
	public List<Owner> getAllOwners() {
		// TODO Auto-generated method stub
		
		return ownerRepository.findAll();
	}

//	@Override
//	public Owner getByUserName(String name) {
//		// TODO Auto-generated method stub
//		Owner owner=ownerRepository.findByUserName(name);
//		if(owner==null)
//		{
//			throw new OwnerNotFoundException("Owner Not found with userName "+name);
//		}
//		return owner;
//	}
	
	

}
