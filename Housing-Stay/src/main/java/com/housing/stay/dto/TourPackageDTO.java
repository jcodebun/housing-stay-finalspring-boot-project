package com.housing.stay.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TOUR_PACKAGE")
@Getter
@Setter
public class TourPackageDTO extends BaseDTO {

	@Column(name="NAME",length = 225)
	private String name;
	
	@Column(name="TOUR_DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="NO_OF_DAYS",length = 225)
	private String noOfDays;
	@Column(name="PRICE",length = 225)
	private String price;
	@Column(name="DESTINATION",length = 225)
	private String destination;
	@Column(name="FACILITIES",length = 225)
	private String facilities;
	@Column(name="HOME_STAY_ID",length = 225)
	private long homeStayId;
	
	@Column(name = "CONTACT_NO",length = 225)
	private String contactNo;
	
	@ManyToOne
	@JoinColumn(name = "HOME_STAY",nullable = false)
	private HomeStayDTO homeStay;
	
	private long userId;
	
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
