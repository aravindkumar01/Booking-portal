package com.booking.hotel.Repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.hotel.model.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long>{

	

	

}
