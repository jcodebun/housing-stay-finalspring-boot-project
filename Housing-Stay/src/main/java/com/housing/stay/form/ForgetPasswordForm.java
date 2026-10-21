package com.housing.stay.form;

import javax.validation.constraints.NotEmpty;

import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "User Id is required")
	private String userId;
	
	@Override
	public BaseDTO getDTO() {
		UserDTO dto = new UserDTO();
		dto.setUserId(userId);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		
	}

}
