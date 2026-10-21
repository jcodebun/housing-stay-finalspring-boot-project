package com.housing.stay.dao;

import java.util.List;

import com.housing.stay.dto.TourPackageDTO;



public interface TourPackageDAOInt {

	public long add(TourPackageDTO dto);
	
	public void delete(TourPackageDTO dto);
	
	public TourPackageDTO findBypk(long pk);
	
	public TourPackageDTO findByName(String name);
	
	public void update(TourPackageDTO dto);
	
	public List<TourPackageDTO> list();
	
	public List<TourPackageDTO>list(int pageNo,int pageSize);
	
	public List<TourPackageDTO> search(TourPackageDTO dto);
	
	public List<TourPackageDTO> search(TourPackageDTO dto,int pageNo,int pageSize);
	
	
}
