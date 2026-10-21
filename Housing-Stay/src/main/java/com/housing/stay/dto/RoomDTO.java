package com.housing.stay.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ROOM")
@Getter
@Setter
public class RoomDTO extends BaseDTO {
	
	@Column(name="ROOM_NO",length = 225)
	private String roomNo;
	@Column(name="FACILITIES",length = 1500)
	private String facilities;
	@Column(name="DESCRIPTION",length = 225)
	private String description;
	
	@Column(name="HOME_STAY_ID",length = 225)
	private long homeStayId;
	
	@ManyToOne
	@JoinColumn(name="HOME_STAY",nullable = false)
	private HomeStayDTO homeStay;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return roomNo;
	}

}
