package com.housing.stay.service;

import java.util.List;

import com.housing.stay.dto.TourPackageDTO;
import com.housing.stay.exception.DuplicateRecordException;



public interface TourPackageServiceInt {

	public long add(TourPackageDTO dto) throws DuplicateRecordException;

	public void delete(TourPackageDTO dto);

	public TourPackageDTO findBypk(long pk);

	public TourPackageDTO findByTourPackageId(String TourPackageId);

	public void update(TourPackageDTO dto) throws DuplicateRecordException;

	public List<TourPackageDTO> list();

	public List<TourPackageDTO> list(int pageNo, int pageSize);

	public List<TourPackageDTO> search(TourPackageDTO dto);

	public List<TourPackageDTO> search(TourPackageDTO dto, int pageNo, int pageSize);

	

}
