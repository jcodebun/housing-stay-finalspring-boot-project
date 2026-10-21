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

import com.housing.stay.dao.TourPackageDAOInt;
import com.housing.stay.dto.TourPackageDTO;
import com.housing.stay.exception.DuplicateRecordException;
import com.housing.stay.util.EmailBuilder;





@Service
public class TourPackageServiceImpl implements TourPackageServiceInt {

	private static Logger log = Logger.getLogger(TourPackageServiceImpl.class.getName());

	@Autowired
	private TourPackageDAOInt dao;

	

	@Override
	@Transactional
	public long add(TourPackageDTO dto) throws DuplicateRecordException {
		log.info("TourPackageServiceImpl Add method start");
		TourPackageDTO existDTO = dao.findByName(dto.getName());
		if (existDTO != null)
			throw new DuplicateRecordException("Name is Already Exist");
		long pk = dao.add(dto);
		log.info("TourPackageServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(TourPackageDTO dto) {
		log.info("TourPackageServiceImpl Delete method start");
		dao.delete(dto);
		log.info("TourPackageServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public TourPackageDTO findBypk(long pk) {
		log.info("TourPackageServiceImpl findBypk method start");
		TourPackageDTO dto = dao.findBypk(pk);
		log.info("TourPackageServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public TourPackageDTO findByTourPackageId(String name) {
		log.info("TourPackageServiceImpl findByTourPackageName method start");
		TourPackageDTO dto = dao.findByName(name);
		log.info("TourPackageServiceImpl findByTourPackageName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(TourPackageDTO dto) throws DuplicateRecordException {
		log.info("TourPackageServiceImpl update method start");
		TourPackageDTO existDTO = dao.findByName(dto.getName());
		if (existDTO != null && dto.getId() != existDTO.getId())
			throw new DuplicateRecordException("Name is Already Exist");
		dao.update(dto);
		log.info("TourPackageServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<TourPackageDTO> list() {
		log.info("TourPackageServiceImpl list method start");
		List<TourPackageDTO> list = dao.list();
		log.info("TourPackageServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TourPackageDTO> list(int pageNo, int pageSize) {
		log.info("TourPackageServiceImpl list method start");
		List<TourPackageDTO> list = dao.list(pageNo, pageSize);
		log.info("TourPackageServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TourPackageDTO> search(TourPackageDTO dto) {
		log.info("TourPackageServiceImpl search method start");
		List<TourPackageDTO> list = dao.search(dto);
		log.info("TourPackageServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<TourPackageDTO> search(TourPackageDTO dto, int pageNo, int pageSize) {
		log.info("TourPackageServiceImpl search method start");
		List<TourPackageDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("TourPackageServiceImpl search method end");
		return list;
	}

	
}
