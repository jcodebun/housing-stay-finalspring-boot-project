package com.housing.stay.dao;

import java.util.List;

import com.housing.stay.dto.BookStayDTO;



public interface BookStayDAOInt {

	public long add(BookStayDTO dto);
	
	public void delete(BookStayDTO dto);
	
	public BookStayDTO findBypk(long pk);
	
	public BookStayDTO findByBookingNo(String bookingNo);
	
	public void update(BookStayDTO dto);
	
	public List<BookStayDTO> list();
	
	public List<BookStayDTO>list(int pageNo,int pageSize);
	
	public List<BookStayDTO> search(BookStayDTO dto);
	
	public List<BookStayDTO> search(BookStayDTO dto,int pageNo,int pageSize);
	
	
	public List<BookStayDTO> search1(BookStayDTO dto);
	
}
