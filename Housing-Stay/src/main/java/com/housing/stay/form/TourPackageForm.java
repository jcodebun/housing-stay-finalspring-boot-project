package com.housing.stay.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.apache.taglibs.standard.lang.jstl.test.Bean2Editor;
import org.springframework.util.unit.DataUnit;

import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.dto.TourPackageDTO;
import com.housing.stay.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourPackageForm extends BaseForm {
	
	

	@NotEmpty(message = "Name is required")
	private String name;
	
	@NotEmpty(message = "Contact No is required")
	private String contactNo;
	
	private String date;
	@NotEmpty(message = "No of Days is required")
	private String noOfDays;
	@NotEmpty(message = "Price is required")
	private String price;
	@NotEmpty(message = "Destination is required")
	private String destination;
	
	@Min(value = 1,message = "Home Stay Name is required")
	private long homeStayId;
	
	@NotEmpty(message = "Facilities is required")
	private String facilities;
	
	

	@Override
	public BaseDTO getDTO() {
		TourPackageDTO bean=new TourPackageDTO();
		bean.setId(id);
		bean.setHomeStayId(homeStayId);
		bean.setName(name);
		bean.setContactNo(contactNo);
		bean.setDate(DataUtility.getDate(date));
		bean.setNoOfDays(noOfDays);
		bean.setPrice(price);
		bean.setDestination(destination);
		bean.setFacilities(facilities);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		TourPackageDTO bean=(TourPackageDTO)bDto;
		id=bean.getId();
		name=bean.getName();
		contactNo=bean.getContactNo();
		homeStayId=bean.getHomeStayId();
		date=DataUtility.getDateString(bean.getDate());
		noOfDays=bean.getNoOfDays();
		price=bean.getPrice();
		destination=bean.getDestination();
		facilities=bean.getFacilities();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
