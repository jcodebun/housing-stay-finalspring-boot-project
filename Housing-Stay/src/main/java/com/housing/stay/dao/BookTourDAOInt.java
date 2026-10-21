package com.housing.stay.dao;

import java.util.List;

import com.housing.stay.dto.BookTourDTO;



public interface BookTourDAOInt {

	public long add(BookTourDTO dto);
	
	public void delete(BookTourDTO dto);
	
	public BookTourDTO findBypk(long pk);
	
	public BookTourDTO findByBookingNo(String bookingNo);
	
	public void update(BookTourDTO dto);
	
	public List<BookTourDTO> list();
	
	public List<BookTourDTO>list(int pageNo,int pageSize);
	
	public List<BookTourDTO> search(BookTourDTO dto);
	
	public List<BookTourDTO> search(BookTourDTO dto,int pageNo,int pageSize);
	
	public List<BookTourDTO> search1(BookTourDTO dto);
	
	
}
