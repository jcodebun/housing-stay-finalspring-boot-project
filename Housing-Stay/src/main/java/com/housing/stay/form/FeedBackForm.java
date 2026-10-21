package com.housing.stay.form;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.apache.taglibs.standard.lang.jstl.test.Bean2Editor;
import org.springframework.util.unit.DataUnit;

import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.FeedBackDTO;
import com.housing.stay.dto.HelpDTO;
import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.dto.RoomDTO;
import com.housing.stay.dto.TourPackageDTO;
import com.housing.stay.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackForm extends BaseForm {

	
	
	@NotEmpty(message = "Question is required")
	private String question;
	

	

	@Override
	public BaseDTO getDTO() {
		FeedBackDTO bean=new FeedBackDTO();
		bean.setId(id);
		bean.setQuestion(question);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		FeedBackDTO bean=(FeedBackDTO)bDto;
		id=bean.getId();
		question=bean.getQuestion();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
