package com.booking.hotel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.Repo.BookingDetailsRepo;
import com.booking.hotel.model.BookingDetails;
import com.booking.hotel.model.Hotel;

@Service
public class BookingDetailsService {

	@Autowired
	BookingDetailsRepo repo;
	
	@Autowired
	UserServiceImpl service;
	
	@Autowired
	HotelService hotelService;
	
	public String saveHotelBookingDetails(BookingDetails details) {
		
		try {
			
			Hotel hotel=hotelService.getHotelById(details.getHotelId());//get hotel obj to set booking obj
			details.setUser(service.findByEmail(details.getUsername()));
			details.setHotel(hotel);
			repo.save(details);//user booking saved to table
			
			//hotel.setAvailableRooms(hotel.getTotalRooms()-details.getRooms());
			//hotelService.saveHotel(hotel);//update rooms count
			return "saved";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	
	public BookingDetails getBookingById(long id) {
		try {
			
			return repo.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<BookingDetails> getBookingAll() {
		try {
			
			return repo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public List<BookingDetails> getBookingByUser(String username) {
	
		try {
			
			return repo.getBookingByUser(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public boolean checkoutHotel(long bookingId) {
		
		try {
			
			BookingDetails details=getBookingById(bookingId);
			
				details.setCheckoutDate(new Date());
				details.setCheckoutStatus(true);
			repo.save(details);
			
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public  Integer getHotelAvailableRoomsCount(Date strDate, long id) {
		try {
			
			 List<BookingDetails> listOfBooking= repo.getBookingByDate(strDate,id);
			 Hotel hotel=hotelService.getHotelById(id);
			 
			 int count=0;
			 for(BookingDetails booking:listOfBooking) {
				 
				 count=count+booking.getRooms();
			 }
			 return hotel.getTotalRooms()-count;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
