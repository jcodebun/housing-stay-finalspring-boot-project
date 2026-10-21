package com.housing.stay.form;

import javax.validation.constraints.NotEmpty;

import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.BookTourDTO;
import com.housing.stay.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTourForm extends BaseForm {
	
	private String bookingNo;
	
	@NotEmpty(message = "Check In Date is required")
	private String checkIn;	
	@NotEmpty(message = "Check Out Date is required")
	private String checkOut;
	
	
	private String date;
	private String fromDate;
	
	@Override
	public BaseDTO getDTO() {
		BookTourDTO bean=new BookTourDTO();
		bean.setId(id);
		bean.setCheckIn(DataUtility.getDate(checkIn));
		bean.setCheckOut(DataUtility.getDate(checkOut));
		bean.setBookingNo(DataUtility.getLong(bookingNo));
		bean.setBookingDate(DataUtility.getDate(date));
		bean.setBookingNo(DataUtility.getLong(bookingNo));
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		BookTourDTO bean=(BookTourDTO)bDto;
		id=bean.getId();
		checkIn=DataUtility.getDateString(bean.getCheckIn());
		checkOut=DataUtility.getDateString(bean.getCheckOut());
		bookingNo=String.valueOf(bean.getBookingNo());
		fromDate=DataUtility.getDateString(bean.getFromDate());
		date=DataUtility.getDateString(bean.getBookingDate());
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
