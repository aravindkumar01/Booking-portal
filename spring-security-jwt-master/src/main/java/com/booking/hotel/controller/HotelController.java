package com.booking.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.model.Hotel;
import com.booking.hotel.service.impl.HotelService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hotel")
public class HotelController {

	@Autowired
	HotelService service;
	
	@PostMapping
	 public  @ResponseBody ResponseEntity<?> saveHotel(@RequestBody Hotel hotel){
	    
		try {
			
			//hotel.setAvailableRooms(hotel.getTotalRooms());
			return new ResponseEntity<String>(service.saveHotel(hotel), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public  @ResponseBody ResponseEntity<?> getHotel(@PathVariable("id") long id){
	    
		try {
			
			return new ResponseEntity<Hotel>(service.getHotelById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/all")
	public  @ResponseBody ResponseEntity<?> getHotel(){
	    
		try {
			
			return new ResponseEntity<List<Hotel>>(service.getHotelAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		
	}
	
	
	
	
	
}
