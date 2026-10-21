package com.housing.stay.dao;

import java.util.List;

import com.housing.stay.dto.HelpDTO;



public interface HelpDAOInt {

	public long add(HelpDTO dto);
	
	public void delete(HelpDTO dto);
	
	public HelpDTO findBypk(long pk);
	
	public HelpDTO findByIssue(String issue);
	
	public void update(HelpDTO dto);
	
	public List<HelpDTO> list();
	
	public List<HelpDTO>list(int pageNo,int pageSize);
	
	public List<HelpDTO> search(HelpDTO dto);
	
	public List<HelpDTO> search(HelpDTO dto,int pageNo,int pageSize);
	
	
}
