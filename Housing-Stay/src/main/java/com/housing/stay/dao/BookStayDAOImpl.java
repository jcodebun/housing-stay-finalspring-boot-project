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

import com.housing.stay.dto.BookStayDTO;

@Repository
public class BookStayDAOImpl implements BookStayDAOInt {

	private static Logger log = Logger.getLogger(BookStayDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(BookStayDTO dto) {
		log.info("BookStayDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("BookStayDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(BookStayDTO dto) {
		log.info("BookStayDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("BookStayDAOImpl Delete method End");

	}

	@Override
	public BookStayDTO findBypk(long pk) {
		log.info("BookStayDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		BookStayDTO dto = (BookStayDTO) session.get(BookStayDTO.class, pk);
		log.info("BookStayDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public BookStayDTO findByBookingNo(String BookingNo) {
		log.info("BookStayDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BookStayDTO.class);
		criteria.add(Restrictions.eq("bookingNo", BookingNo));
		BookStayDTO dto = (BookStayDTO) criteria.uniqueResult();
		log.info("BookStayDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(BookStayDTO dto) {
		log.info("BookStayDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("BookStayDAOImpl update method End");
	}

	@Override
	public List<BookStayDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<BookStayDTO> list(int pageNo, int pageSize) {
		log.info("BookStayDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<BookStayDTO> query = session.createQuery("from BookStayDTO", BookStayDTO.class);
		List<BookStayDTO> list = query.getResultList();
		log.info("BookStayDAOImpl List method End");
		return list;
	}

	@Override
	public List<BookStayDTO> search(BookStayDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<BookStayDTO> search(BookStayDTO dto, int pageNo, int pageSize) {
		log.info("BookStayDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from BookStayDTO as u where 1=1 ");
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
		System.out.println(hql.toString());
		Query<BookStayDTO> query = session.createQuery(hql.toString(), BookStayDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<BookStayDTO> list = query.getResultList();
		log.info("BookStayDAOImpl Search method End");
		System.out.println(list.size());
		return list;
	}
	
	
	@Override
	public List<BookStayDTO> search1(BookStayDTO dto) {
		log.info("BookStayDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from BookStayDTO as u where 1=1 ");
		if (dto != null) {
			

			if (dto.getBookingDate() != null && dto.getBookingDate().getTime() > 0 && dto.getFromDate() != null
					&& dto.getFromDate().getTime() > 0) {
				hql.append(" and u.bookingDate BETWEEN  '" + new java.sql.Date(dto.getBookingDate().getTime())
						+ "' AND '" + new java.sql.Date(dto.getFromDate().getTime()) + "'");
			} else if (dto.getBookingDate() != null && dto.getBookingDate().getTime() > 0) {
				hql.append(" and u.bookingDate like '" + new java.sql.Date(dto.getBookingDate().getTime()) + "%'");
			}
			
			 if (dto.getRoomNo() != null && dto.getRoomNo().length() > 0) {
					hql.append(" and u.roomNo like '" +dto.getRoomNo()+ "%'");
				}
			
			 
		}
		System.out.println(hql.toString());
		Query<BookStayDTO> query = session.createQuery(hql.toString(), BookStayDTO.class);
		
		List<BookStayDTO> list = query.getResultList();
		log.info("BookStayDAOImpl Search method End");
		System.out.println(list.size());
		return list;
	}

}
