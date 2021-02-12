package com.booking.hotel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class BookingDetails  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public BookingDetails() {
		
	}
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private int adults;

	@Column
	private int children;

	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	
	
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date checkoutDate;

	@Column
	private boolean checkoutStatus=false;
	
	
	@Column
	private int rooms;

	@Column
	private String phone;

	@Transient
	@JsonSerialize
	@JsonDeserialize
	@JsonIgnore
	private String username;
	
	@Transient
	@JsonSerialize
	@JsonDeserialize
	@JsonIgnore
	private long hotelId;
	

	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name ="user")
	 private User user;
	 
	 @ManyToOne( cascade=CascadeType.ALL, optional = false)
	 @JoinColumn(name="hotel", nullable=false)
	 private Hotel hotel;
	 
	 
	 

	public boolean isCheckoutStatus() {
		return checkoutStatus;
	}

	public void setCheckoutStatus(boolean checkoutStatus) {
		this.checkoutStatus = checkoutStatus;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}




	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
