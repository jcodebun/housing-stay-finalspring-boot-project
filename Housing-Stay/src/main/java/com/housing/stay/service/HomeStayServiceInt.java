package com.housing.stay.service;

import java.util.List;

import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.exception.DuplicateRecordException;



public interface HomeStayServiceInt {

	public long add(HomeStayDTO dto) throws DuplicateRecordException;

	public void delete(HomeStayDTO dto);

	public HomeStayDTO findBypk(long pk);

	public HomeStayDTO findByHomeStayId(String HomeStayId);

	public void update(HomeStayDTO dto) throws DuplicateRecordException;

	public List<HomeStayDTO> list();

	public List<HomeStayDTO> list(int pageNo, int pageSize);

	public List<HomeStayDTO> search(HomeStayDTO dto);

	public List<HomeStayDTO> search(HomeStayDTO dto, int pageNo, int pageSize);

	

}
