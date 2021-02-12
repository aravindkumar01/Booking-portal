package com.booking.hotel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.booking.hotel.model.BookingDetails;
import com.booking.hotel.service.impl.BookingDetailsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hotel/booking")
public class BookingController {

	
	@Autowired
	BookingDetailsService service;
	
	
	@PostMapping
	 public  @ResponseBody ResponseEntity<?> saveHotel(@RequestBody BookingDetails details){
	    
		try {
			
			return new ResponseEntity<String>(service.saveHotelBookingDetails(details), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	

	@GetMapping("/{id}")
	public  @ResponseBody ResponseEntity<?> getBookingDetails(@PathVariable("id") long id){
	    
		try {
			
			return new ResponseEntity<BookingDetails>(service.getBookingById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/all")
	public  @ResponseBody ResponseEntity<?> getBookingDetails(){
	    
		try {
			
			return new ResponseEntity<List<BookingDetails>>(service.getBookingAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/user/{username}")
	public  @ResponseBody ResponseEntity<?> getBookingDetailsByUser(@PathVariable("username") String username){
	    
		try {
			
			return new ResponseEntity<List<BookingDetails>>(service.getBookingByUser(username), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/checkout-user/{id}")
	 public  @ResponseBody ResponseEntity<?> checkoutHotel(@PathVariable("id") long bookingId){
	    
		try {
			
			return new ResponseEntity<Boolean>(service.checkoutHotel(bookingId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/count")
	public  @ResponseBody ResponseEntity<?> getHotelAvailableRoomsCount(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("hotelId") long id){
	    
		try {
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");  
			    String strDate= formatter.format(date);  
			return new ResponseEntity<Integer>(service.getHotelAvailableRoomsCount(date,id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		
	}
}
