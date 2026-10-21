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

import com.housing.stay.dao.HelpDAOInt;
import com.housing.stay.dto.HelpDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.util.EmailBuilder;





@Service
public class HelpServiceImpl implements HelpServiceInt {

	private static Logger log = Logger.getLogger(HelpServiceImpl.class.getName());

	@Autowired
	private HelpDAOInt dao;

	

	@Override
	@Transactional
	public long add(HelpDTO dto) throws DuplicateRecordException {
		log.info("HelpServiceImpl Add method start");
		long pk = dao.add(dto);
		log.info("HelpServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(HelpDTO dto) {
		log.info("HelpServiceImpl Delete method start");
		dao.delete(dto);
		log.info("HelpServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public HelpDTO findBypk(long pk) {
		log.info("HelpServiceImpl findBypk method start");
		HelpDTO dto = dao.findBypk(pk);
		log.info("HelpServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public HelpDTO findByIssue(String issue) {
		log.info("HelpServiceImpl findByHelpName method start");
		HelpDTO dto = dao.findByIssue(issue);
		log.info("HelpServiceImpl findByHelpName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(HelpDTO dto) throws DuplicateRecordException {
		log.info("HelpServiceImpl update method start");
		dao.update(dto);
		log.info("HelpServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<HelpDTO> list() {
		log.info("HelpServiceImpl list method start");
		List<HelpDTO> list = dao.list();
		log.info("HelpServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<HelpDTO> list(int pageNo, int pageSize) {
		log.info("HelpServiceImpl list method start");
		List<HelpDTO> list = dao.list(pageNo, pageSize);
		log.info("HelpServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<HelpDTO> search(HelpDTO dto) {
		log.info("HelpServiceImpl search method start");
		List<HelpDTO> list = dao.search(dto);
		log.info("HelpServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<HelpDTO> search(HelpDTO dto, int pageNo, int pageSize) {
		log.info("HelpServiceImpl search method start");
		List<HelpDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("HelpServiceImpl search method end");
		return list;
	}

	
}
