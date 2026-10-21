package com.housing.stay.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.housing.stay.dto.BookTourDTO;

@Repository
public class BookTourDAOImpl implements BookTourDAOInt {

	private static Logger log = Logger.getLogger(BookTourDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(BookTourDTO dto) {
		log.info("BookTourDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("BookTourDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(BookTourDTO dto) {
		log.info("BookTourDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("BookTourDAOImpl Delete method End");

	}

	@Override
	public BookTourDTO findBypk(long pk) {
		log.info("BookTourDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		BookTourDTO dto = (BookTourDTO) session.get(BookTourDTO.class, pk);
		log.info("BookTourDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public BookTourDTO findByBookingNo(String BookingNo) {
		log.info("BookTourDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BookTourDTO.class);
		criteria.add(Restrictions.eq("bookingNo",BookingNo));
		BookTourDTO dto = (BookTourDTO) criteria.uniqueResult();
		log.info("BookTourDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(BookTourDTO dto) {
		log.info("BookTourDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("BookTourDAOImpl update method End");
	}

	@Override
	public List<BookTourDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<BookTourDTO> list(int pageNo, int pageSize) {
		log.info("BookTourDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<BookTourDTO> query = session.createQuery("from BookTourDTO", BookTourDTO.class);
		List<BookTourDTO> list = query.getResultList();
		log.info("BookTourDAOImpl List method End");
		return list;
	}

	@Override
	public List<BookTourDTO> search(BookTourDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<BookTourDTO> search(BookTourDTO dto, int pageNo, int pageSize) {
		log.info("BookTourDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from BookTourDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			
			if (dto.getBookingNo() > 0) {
				hql.append("and u.bookingNo = " + dto.getBookingNo());
			}
			
			if (dto.getOwnerId() > 0) {
				hql.append("and u.ownerId = " + dto.getOwnerId());
			}
			
			if (dto.getUserId() > 0) {
				hql.append("and u.userId = " + dto.getUserId());
			}

			if (dto.getBookingDate() != null && dto.getBookingDate().getTime() > 0 && dto.getFromDate() != null
					&& dto.getFromDate().getTime() > 0) {
				hql.append("and u.bookingDate BETWEEN  '" + new java.sql.Date(dto.getBookingDate().getTime())
						+ "' AND '" + new java.sql.Date(dto.getFromDate().getTime()) + "'");
			} else if (dto.getBookingDate() != null && dto.getBookingDate().getTime() > 0) {
				hql.append("and u.bookingDate like '" + new java.sql.Date(dto.getBookingDate().getTime()) + "%'");
			}
		}
		Query<BookTourDTO> query = session.createQuery(hql.toString(), BookTourDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<BookTourDTO> list = query.getResultList();
		log.info("BookTourDAOImpl Search method End");
		return list;
	}
	
	
	@Override
	public List<BookTourDTO> search1(BookTourDTO dto) {
		log.info("BookTourDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from BookTourDTO as u where 1=1 ");
		if (dto != null) {
			
			

			if (dto.getBookingDate() != null && dto.getBookingDate().getTime() > 0 && dto.getFromDate() != null
					&& dto.getFromDate().getTime() > 0) {
				hql.append("and u.bookingDate BETWEEN  '" + new java.sql.Date(dto.getBookingDate().getTime())
						+ "' AND '" + new java.sql.Date(dto.getFromDate().getTime()) + "'");
			} else if (dto.getBookingDate() != null && dto.getBookingDate().getTime() > 0) {
				hql.append("and u.bookingDate like '" + new java.sql.Date(dto.getBookingDate().getTime()) + "%'");
			}
		}
		Query<BookTourDTO> query = session.createQuery(hql.toString(), BookTourDTO.class);
		
		List<BookTourDTO> list = query.getResultList();
		log.info("BookTourDAOImpl Search method End");
		return list;
	}

	
}
