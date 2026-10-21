package com.housing.stay.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.apache.taglibs.standard.lang.jstl.test.Bean2Editor;
import org.springframework.util.unit.DataUnit;

import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.dto.RoomDTO;
import com.housing.stay.dto.TourPackageDTO;
import com.housing.stay.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomForm extends BaseForm {
	
	

	@NotEmpty(message ="Room no is required")
	private String roomNo;
	
	@Min(value = 1,message = "Home Stay Name is required")
	private long homeStayId;
	
	@NotEmpty(message = "Facilities is required")
	private String facilities;
	
	@NotEmpty(message = "Description is required")
	private String description;
	
	

	@Override
	public BaseDTO getDTO() {
		RoomDTO bean=new RoomDTO();
		bean.setId(id);
		bean.setHomeStayId(homeStayId);
		bean.setRoomNo(roomNo);
		bean.setDescription(description);
		bean.setFacilities(facilities);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		RoomDTO bean=(RoomDTO)bDto;
		id=bean.getId();
		roomNo=bean.getRoomNo();
		homeStayId=bean.getHomeStayId();
		description=bean.getDescription();
		facilities=bean.getFacilities();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
