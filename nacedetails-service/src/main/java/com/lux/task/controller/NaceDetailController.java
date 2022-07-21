package com.lux.task.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lux.task.models.NaceItem;
import com.lux.task.service.NaceService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/nace")

public class NaceDetailController {
	
	@Autowired
	NaceService naceService;
	
	@GetMapping("/naceitem/{orderId}")
	public Optional<NaceItem> getNaceDetail(@PathVariable("orderId") int orderId){
		return naceService.getNaceDetails(orderId);
		//return Collections.singletonList(new NaceItem(Integer.parseInt(orderId),"B","AGRICULTURE, FORESTRY AND FISHING"));
	}
	
	@GetMapping("/allnaceitems")
	public List<NaceItem> getAllNaceDetails(){
		return naceService.getAllNaceDetails();
	}
	
	@PostMapping("/addnaceitem")
	@ApiOperation(value="Add a Nace Item",
	notes="Add a Nace Item to the Nace Item Details", 
	response=NaceItem.class)
    public NaceItem addNaceItem(@RequestBody NaceItem naceItem){
		naceService.addNaceItem(naceItem);
		return naceItem;
    }
	
	@DeleteMapping("/naceitem/{orderId}")
	public String deleteNaceItem(@PathVariable("orderId") int orderId) {
		String status=naceService.deleteNaceItem(orderId);
		return status;
	}
	
	@PutMapping("/addnaceitem")
    public NaceItem saveOrupdateNaceItem(@RequestBody NaceItem naceItem){
		naceService.addNaceItem(naceItem);
		return naceItem;
    }
}
