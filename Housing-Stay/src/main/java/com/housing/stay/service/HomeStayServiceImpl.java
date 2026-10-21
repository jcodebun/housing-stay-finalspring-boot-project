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

import com.housing.stay.dao.HomeStayDAOInt;
import com.housing.stay.dto.HomeStayDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.util.EmailBuilder;





@Service
public class HomeStayServiceImpl implements HomeStayServiceInt {

	private static Logger log = Logger.getLogger(HomeStayServiceImpl.class.getName());

	@Autowired
	private HomeStayDAOInt dao;

	

	@Override
	@Transactional
	public long add(HomeStayDTO dto) throws DuplicateRecordException {
		log.info("HomeStayServiceImpl Add method start");
		HomeStayDTO existDTO = dao.findByName(dto.getName());
		if (existDTO != null)
			throw new DuplicateRecordException("Name is Already Exist");
		long pk = dao.add(dto);
		log.info("HomeStayServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(HomeStayDTO dto) {
		log.info("HomeStayServiceImpl Delete method start");
		dao.delete(dto);
		log.info("HomeStayServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public HomeStayDTO findBypk(long pk) {
		log.info("HomeStayServiceImpl findBypk method start");
		HomeStayDTO dto = dao.findBypk(pk);
		log.info("HomeStayServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public HomeStayDTO findByHomeStayId(String name) {
		log.info("HomeStayServiceImpl findByHomeStayName method start");
		HomeStayDTO dto = dao.findByName(name);
		log.info("HomeStayServiceImpl findByHomeStayName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(HomeStayDTO dto) throws DuplicateRecordException {
		log.info("HomeStayServiceImpl update method start");
		HomeStayDTO existDTO = dao.findByName(dto.getName());
		if (existDTO != null && dto.getId() != existDTO.getId())
			throw new DuplicateRecordException("Name is Already Exist");
		dao.update(dto);
		log.info("HomeStayServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<HomeStayDTO> list() {
		log.info("HomeStayServiceImpl list method start");
		List<HomeStayDTO> list = dao.list();
		log.info("HomeStayServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<HomeStayDTO> list(int pageNo, int pageSize) {
		log.info("HomeStayServiceImpl list method start");
		List<HomeStayDTO> list = dao.list(pageNo, pageSize);
		log.info("HomeStayServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<HomeStayDTO> search(HomeStayDTO dto) {
		log.info("HomeStayServiceImpl search method start");
		List<HomeStayDTO> list = dao.search(dto);
		log.info("HomeStayServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<HomeStayDTO> search(HomeStayDTO dto, int pageNo, int pageSize) {
		log.info("HomeStayServiceImpl search method start");
		List<HomeStayDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("HomeStayServiceImpl search method end");
		return list;
	}

	
}
