package com.housing.stay.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="BOOK_TOUR")
public class BookTourDTO extends BaseDTO {
	
	@Column(name="BOOKING_NO")
	private long bookingNo;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="TOUR_PACKAGE_ID")
	private long tourId;
	
	@ManyToOne
	@JoinColumn(name="USER",nullable = false)
	private UserDTO user;
	
	@ManyToOne
	@JoinColumn(name="TOUR_PACKAGE",nullable = false)
	private TourPackageDTO tourPackage;
	
	@Column(name="CHECK_IN")
	@Temporal(TemporalType.DATE)
	private Date checkIn;
	
	@Column(name="CHECK_OUT")
	@Temporal(TemporalType.DATE)
	private Date checkOut;

	
	@Column(name="BOOKING_DATE")
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
	@Transient
	private Date fromDate;
	
	private long ownerId;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
