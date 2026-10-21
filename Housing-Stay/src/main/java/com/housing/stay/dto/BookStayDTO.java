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
@Table(name="BOOK_STAY")
public class BookStayDTO extends BaseDTO {
	
	@Column(name="BOOKING_NO")
	private long bookingNo;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="HOME_STAY_ID")
	private long homeStayId;
	
	@ManyToOne
	@JoinColumn(name="USER",nullable = false)
	private UserDTO user;
	
	@ManyToOne
	@JoinColumn(name="HOME_STAY",nullable = false)
	private HomeStayDTO homeStay;
	
	@Column(name="CHECK_IN")
	@Temporal(TemporalType.DATE)
	private Date checkIn;
	
	@Column(name="CHECK_OUT")
	@Temporal(TemporalType.DATE)
	private Date checkOut;

	
	@Column(name="ROOM_ID")
	private long roomId;
	
	@Column(name="ROOM_NO",length = 225)
	private String RoomNo;
	
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
