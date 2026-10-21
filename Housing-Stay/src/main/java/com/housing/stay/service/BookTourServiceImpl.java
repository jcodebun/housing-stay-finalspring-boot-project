package com.housing.stay.service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.housing.stay.dao.BookTourDAOInt;
import com.housing.stay.dto.BookStayDTO;
import com.housing.stay.dto.BookTourDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.util.EmailBuilder;





@Service
public class BookTourServiceImpl implements BookTourServiceInt {

	private static Logger log = Logger.getLogger(BookTourServiceImpl.class.getName());

	@Autowired
	private BookTourDAOInt dao;

	

	@Override
	@Transactional
	public long add(BookTourDTO dto) throws DuplicateRecordException {
		log.info("BookTourServiceImpl Add method start");
		long pk = dao.add(dto);
		log.info("BookTourServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(BookTourDTO dto) {
		log.info("BookTourServiceImpl Delete method start");
		dao.delete(dto);
		log.info("BookTourServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public BookTourDTO findBypk(long pk) {
		log.info("BookTourServiceImpl findBypk method start");
		BookTourDTO dto = dao.findBypk(pk);
		log.info("BookTourServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public BookTourDTO findByBookingNo(String bookingNo) {
		log.info("BookTourServiceImpl findByBookTourName method start");
		BookTourDTO dto = dao.findByBookingNo(bookingNo);
		log.info("BookTourServiceImpl findByBookTourName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(BookTourDTO dto) throws DuplicateRecordException {
		log.info("BookTourServiceImpl update method start");
		dao.update(dto);
		log.info("BookTourServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<BookTourDTO> list() {
		log.info("BookTourServiceImpl list method start");
		List<BookTourDTO> list = dao.list();
		log.info("BookTourServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookTourDTO> list(int pageNo, int pageSize) {
		log.info("BookTourServiceImpl list method start");
		List<BookTourDTO> list = dao.list(pageNo, pageSize);
		log.info("BookTourServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookTourDTO> search(BookTourDTO dto) {
		log.info("BookTourServiceImpl search method start");
		List<BookTourDTO> list = dao.search(dto);
		log.info("BookTourServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookTourDTO> search(BookTourDTO dto, int pageNo, int pageSize) {
		log.info("BookTourServiceImpl search method start");
		List<BookTourDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("BookTourServiceImpl search method end");
		return list;
	}

	
}
