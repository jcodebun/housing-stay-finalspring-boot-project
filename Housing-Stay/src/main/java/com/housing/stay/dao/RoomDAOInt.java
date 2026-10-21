package com.housing.stay.dao;

import java.util.List;

import com.housing.stay.dto.RoomDTO;



public interface RoomDAOInt {

	public long add(RoomDTO dto);
	
	public void delete(RoomDTO dto);
	
	public RoomDTO findBypk(long pk);
	
	public RoomDTO findByRoomNo(String roomNo);
	
	public void update(RoomDTO dto);
	
	public List<RoomDTO> list();
	
	public List<RoomDTO>list(int pageNo,int pageSize);
	
	public List<RoomDTO> search(RoomDTO dto);
	
	public List<RoomDTO> search(RoomDTO dto,int pageNo,int pageSize);
	
	
}
