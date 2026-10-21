package com.housing.stay.service;

import java.util.List;

import com.housing.stay.dto.BookTourDTO;
import com.housing.stay.exception.DuplicateRecordException;



public interface BookTourServiceInt {

	public long add(BookTourDTO dto) throws DuplicateRecordException;

	public void delete(BookTourDTO dto);

	public BookTourDTO findBypk(long pk);

	public BookTourDTO findByBookingNo(String bookingNo);

	public void update(BookTourDTO dto) throws DuplicateRecordException;

	public List<BookTourDTO> list();

	public List<BookTourDTO> list(int pageNo, int pageSize);

	public List<BookTourDTO> search(BookTourDTO dto);

	public List<BookTourDTO> search(BookTourDTO dto, int pageNo, int pageSize);

	

}
