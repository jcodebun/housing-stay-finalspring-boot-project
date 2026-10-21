package com.housing.stay.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import com.housing.stay.dto.BaseDTO;
import com.housing.stay.dto.BookStayDTO;
import com.housing.stay.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookStayForm extends BaseForm {
	
	private String bookingNo;
	
	@NotEmpty(message = "Check In Date is required")
	private String checkIn;	
	@NotEmpty(message = "Check Out Date is required")
	private String checkOut;
	@Min(value = 1,message = "Room No is required")
	private long roomId;
	
	private String date;
	
	private String fromDate;
	
	

	
	@Override
	public BaseDTO getDTO() {
		BookStayDTO bean=new BookStayDTO();
		bean.setId(id);
		bean.setCheckIn(DataUtility.getDate(checkIn));
		bean.setCheckOut(DataUtility.getDate(checkOut));
		bean.setRoomId(roomId);
		bean.setFromDate(DataUtility.getDate(fromDate));
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
		BookStayDTO bean=(BookStayDTO)bDto;
		id=bean.getId();
		checkIn=DataUtility.getDateString(bean.getCheckIn());
		checkOut=DataUtility.getDateString(bean.getCheckOut());
		roomId=bean.getRoomId();
		fromDate=DataUtility.getDateString(bean.getFromDate());
		date=DataUtility.getDateString(bean.getBookingDate());
		bookingNo=String.valueOf(bean.getBookingNo());
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();

	}

}
