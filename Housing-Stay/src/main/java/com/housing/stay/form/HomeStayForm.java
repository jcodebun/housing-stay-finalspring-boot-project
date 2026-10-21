package com.housing.stay.form;

import javax.validation.constraints.NotEmpty;


import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeStayForm extends BaseForm {
	
	
	@NotEmpty(message = "Name is required")
	private String name;
	
	@NotEmpty(message = "Contact No is required")
	private String contactNo;
	
	@NotEmpty(message = "Address is required")
	private String address;
	
	@NotEmpty(message = "No of Rooms is required")
	private String noOfRooms;
	
	@NotEmpty(message = "Facilities is required")
	private String facilities;
	
	private String date;

	@NotEmpty(message = "Location is required")
	private String location;
	

	@Override
	public BaseDTO getDTO() {
		HomeStayDTO bean=new HomeStayDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setContactNo(contactNo);
		bean.setAddress(address);
		bean.setDate(DataUtility.getDate(date));
		bean.setLocation(location);
		bean.setNoOfRooms(noOfRooms);
		bean.setFacilities(facilities);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		HomeStayDTO bean=(HomeStayDTO)bDto;
		id=bean.getId();
		name=bean.getName();
		location=bean.getLocation();
		date=DataUtility.getDateString(bean.getDate());
		contactNo=bean.getContactNo();
		address=bean.getAddress();
		noOfRooms=bean.getNoOfRooms();
		facilities=bean.getFacilities();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
