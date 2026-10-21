package com.housing.stay.dao;

import java.util.List;

import com.housing.stay.dto.HomeStayDTO;



public interface HomeStayDAOInt {

	public long add(HomeStayDTO dto);
	
	public void delete(HomeStayDTO dto);
	
	public HomeStayDTO findBypk(long pk);
	
	public HomeStayDTO findByName(String name);
	
	public void update(HomeStayDTO dto);
	
	public List<HomeStayDTO> list();
	
	public List<HomeStayDTO>list(int pageNo,int pageSize);
	
	public List<HomeStayDTO> search(HomeStayDTO dto);
	
	public List<HomeStayDTO> search(HomeStayDTO dto,int pageNo,int pageSize);
	
	
}
