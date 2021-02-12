package com.booking.hotel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;

	@Column
	private String name;

	 
	 
	@Column
    private int star;
	 
	@Column
    private String address;
	 
	@Column
    private String overAllReview;
	
	
	@Column
    private long totalReviews;
	
	@Column
    private String imgPath;

	
	@Column
    private int totalRooms;
	
	

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
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

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOverAllReview() {
		return overAllReview;
	}

	public void setOverAllReview(String overAllReview) {
		this.overAllReview = overAllReview;
	}

	public long getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(long totalReviews) {
		this.totalReviews = totalReviews;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	
	
}
