package com.housing.stay.service;

import java.util.List;

import com.housing.stay.dto.BookStayDTO;
import com.housing.stay.exception.DuplicateRecordException;



public interface BookStayServiceInt {

	public long add(BookStayDTO dto) throws DuplicateRecordException;

	public void delete(BookStayDTO dto);

	public BookStayDTO findBypk(long pk);

	public BookStayDTO findByBookingNo(String bookingNo);

	public void update(BookStayDTO dto) throws DuplicateRecordException;

	public List<BookStayDTO> list();

	public List<BookStayDTO> list(int pageNo, int pageSize);

	public List<BookStayDTO> search(BookStayDTO dto);

	public List<BookStayDTO> search(BookStayDTO dto, int pageNo, int pageSize);

	

}
