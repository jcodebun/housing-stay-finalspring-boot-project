package com.housing.stay.form;


import javax.validation.constraints.NotEmpty;


import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.FeedBackDTO;
import com.housing.stay.dto.UserFeedBackDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFeedBackForm extends BaseForm {

	@NotEmpty(message = "FeedBack is required")
	private String feedBack;
	
	private String question;
	

	@Override
	public BaseDTO getDTO() {
		UserFeedBackDTO bean=new UserFeedBackDTO();
		bean.setId(id);
		bean.setFeedBack(feedBack);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserFeedBackDTO bean=(UserFeedBackDTO)bDto;
		id=bean.getId();
		feedBack=bean.getFeedBack();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
