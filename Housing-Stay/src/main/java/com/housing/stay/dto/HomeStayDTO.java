package com.housing.stay.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="HOUSING_STAY")
@Getter
@Setter
public class HomeStayDTO extends BaseDTO {
	
	@Column(name="NAME",length = 225)
	private String name;
	
	@Column(name="CONTACT_NO",length = 225)
	private String contactNo;
	
	@Column(name="ADDRESS",length = 1500)
	private String address;
	
	@Column(name="NO_OF_ROOMS",length = 225)
	private String noOfRooms;
	
	@Column(name="FACILITIES",length = 1500)
	private String facilities;
	
	@Column(name="STAY_DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="LOCATION",length = 225)
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "homeStay")
	private Set<TourPackageDTO> tourPackages;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "homeStay")
	private Set<RoomDTO> rooms;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "homeStay")
	private Set<BookStayDTO> bookStays;
	
	
	private long userId;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

}
