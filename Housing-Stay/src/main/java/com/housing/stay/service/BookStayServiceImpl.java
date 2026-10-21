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

import com.housing.stay.dao.BookStayDAOInt;
import com.housing.stay.dto.BookStayDTO;
import com.housing.stay.dto.RoomDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.util.EmailBuilder;





@Service
public class BookStayServiceImpl implements BookStayServiceInt {

	private static Logger log = Logger.getLogger(BookStayServiceImpl.class.getName());

	@Autowired
	private BookStayDAOInt dao;

	

	@Override
	@Transactional
	public long add(BookStayDTO dto) throws DuplicateRecordException {
		log.info("BookStayServiceImpl Add method start");
		
		long pk = dao.add(dto);
		log.info("BookStayServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(BookStayDTO dto) {
		log.info("BookStayServiceImpl Delete method start");
		dao.delete(dto);
		log.info("BookStayServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public BookStayDTO findBypk(long pk) {
		log.info("BookStayServiceImpl findBypk method start");
		BookStayDTO dto = dao.findBypk(pk);
		log.info("BookStayServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public BookStayDTO findByBookingNo(String bookingNo) {
		log.info("BookStayServiceImpl findByBookStayName method start");
		BookStayDTO dto = dao.findByBookingNo(bookingNo);
		log.info("BookStayServiceImpl findByBookStayName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(BookStayDTO dto) throws DuplicateRecordException {
		log.info("BookStayServiceImpl update method start");
		dao.update(dto);
		log.info("BookStayServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<BookStayDTO> list() {
		log.info("BookStayServiceImpl list method start");
		List<BookStayDTO> list = dao.list();
		log.info("BookStayServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookStayDTO> list(int pageNo, int pageSize) {
		log.info("BookStayServiceImpl list method start");
		List<BookStayDTO> list = dao.list(pageNo, pageSize);
		log.info("BookStayServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookStayDTO> search(BookStayDTO dto) {
		log.info("BookStayServiceImpl search method start");
		List<BookStayDTO> list = dao.search(dto);
		log.info("BookStayServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookStayDTO> search(BookStayDTO dto, int pageNo, int pageSize) {
		log.info("BookStayServiceImpl search method start");
		List<BookStayDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("BookStayServiceImpl search method end");
		return list;
	}

	
}
