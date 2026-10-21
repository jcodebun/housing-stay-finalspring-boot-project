package com.housing.stay.form;

import javax.validation.constraints.NotEmpty;

import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

	

@Getter
@Setter
public class LoginForm extends BaseForm {

	@NotEmpty(message = "User Id is required")
	private String userId;
	@NotEmpty(message = "Password is required")
	private String password;
	

	@Override
	public BaseDTO getDTO() {
		UserDTO bean=new UserDTO();
		bean.setUserId(userId);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bdto) {
		UserDTO entity=(UserDTO) bdto;
		userId=entity.getUserId();
		password=entity.getPassword();
	}

}
