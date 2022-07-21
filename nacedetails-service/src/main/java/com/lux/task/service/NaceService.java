package com.lux.task.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lux.task.dao.NaceRepo;
import com.lux.task.models.NaceItem;

@Service
public class NaceService {
	
	@Autowired
	NaceRepo repo;
	
	public Optional<NaceItem> getNaceDetails(int orderId){
		//repo.save(new NaceItem(orderId,"B","Crop and animal production, hunting and related service activities"));
		//return Collections.singletonList(new NaceItem(orderId,"B","AGRICULTURE, FORESTRY AND FISHING"));
		return repo.findById(orderId);
	}
	
	public List<NaceItem> getAllNaceDetails(){
		return repo.findAll();
	}
	
	public void addNaceItem(NaceItem naceItem){
		repo.save(naceItem);
    }
	
	public String deleteNaceItem(int orderId) {
		NaceItem naceItem = repo.getReferenceById(orderId);
		repo.delete(naceItem);
		return "Item deleted";
		
	}
}
