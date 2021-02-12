package com.booking.hotel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.Repo.HotelRepo;
import com.booking.hotel.model.Hotel;

@Service
public class HotelService {
	
	
	@Autowired
	HotelRepo repo;
	
	
	public String saveHotel(Hotel hotel) {
		
		try {
			
			repo.save(hotel);
			return "saved";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	public Hotel getHotelById(Long id) {
		
		try {
			Hotel h= repo.findById(id).orElse(null);
			return h;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public List<Hotel> getHotelAll(){
		
		try {
			
			return repo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
