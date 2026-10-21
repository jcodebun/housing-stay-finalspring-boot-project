package com.housing.stay.form;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.apache.taglibs.standard.lang.jstl.test.Bean2Editor;
import org.springframework.util.unit.DataUnit;

import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.HelpDTO;
import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.dto.RoomDTO;
import com.housing.stay.dto.TourPackageDTO;
import com.housing.stay.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelpForm extends BaseForm {

	private String requestId;
	
	@NotEmpty(message = "Issue is required")
	private String issue;
	
	@NotEmpty(message = "Description is required")
	private String description;
	
	private String comment;
	
	private Date date;
	
	

	@Override
	public BaseDTO getDTO() {
		HelpDTO bean=new HelpDTO();
		bean.setId(id);
		bean.setIssue(issue);
		bean.setRequestId(DataUtility.getLong(requestId));
		bean.setComment(comment);
		bean.setDate(date);
		bean.setDescription(description);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		HelpDTO bean=(HelpDTO)bDto;
		id=bean.getId();
		issue=bean.getIssue();
		description=bean.getDescription();
		requestId=String.valueOf(bean.getRequestId());
		comment=bean.getComment();
		date=bean.getDate();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
