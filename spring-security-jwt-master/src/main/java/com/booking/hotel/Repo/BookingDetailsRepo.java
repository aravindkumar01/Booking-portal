package com.booking.hotel.Repo;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.hotel.model.BookingDetails;

@Repository
public interface BookingDetailsRepo extends JpaRepository<BookingDetails, Long>{

	@Query("select s from BookingDetails s where s.user.username=:username")
	List<BookingDetails> getBookingByUser(String username);

	@Query(value="select s from BookingDetails s where s.arrivalDate=:date and s.hotel.id=:id")
	List<BookingDetails> getBookingByDate(Date date, long id);

	//List<BookingDetails> findAllByArrivalDateAndId(Date arrivalDate, long id);
}
