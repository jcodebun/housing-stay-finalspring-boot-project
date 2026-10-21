package com.housing.stay.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.housing.stay.dto.HomeStayDTO;




@Repository
public class HomeStayDAOImpl implements HomeStayDAOInt {

	private static Logger log = Logger.getLogger(HomeStayDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(HomeStayDTO dto) {
		log.info("HomeStayDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("HomeStayDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(HomeStayDTO dto) {
		log.info("HomeStayDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("HomeStayDAOImpl Delete method End");

	}

	@Override
	public HomeStayDTO findBypk(long pk) {
		log.info("HomeStayDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		HomeStayDTO dto = (HomeStayDTO) session.get(HomeStayDTO.class, pk);
		log.info("HomeStayDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public HomeStayDTO findByName(String name) {
		log.info("HomeStayDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(HomeStayDTO.class);
		criteria.add(Restrictions.eq("name",name));
		HomeStayDTO dto = (HomeStayDTO) criteria.uniqueResult();
		log.info("HomeStayDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(HomeStayDTO dto) {
		log.info("HomeStayDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("HomeStayDAOImpl update method End");
	}

	@Override
	public List<HomeStayDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<HomeStayDTO> list(int pageNo, int pageSize) {
		log.info("HomeStayDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<HomeStayDTO> query = session.createQuery("from HomeStayDTO", HomeStayDTO.class);
		List<HomeStayDTO> list = query.getResultList();
		log.info("HomeStayDAOImpl List method End");
		return list;
	}

	@Override
	public List<HomeStayDTO> search(HomeStayDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<HomeStayDTO> search(HomeStayDTO dto, int pageNo, int pageSize) {
		log.info("HomeStayDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from HomeStayDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getName() != null && dto.getName().length() >0) {
				hql.append("and u.name like '" + dto.getName()+"%'");
			}
			if (dto.getDate() != null && dto.getDate().getTime() > 0) {
				hql.append("and u.date like '"+dto.getDate()+"%'");
			}
			
			if (dto.getLocation() != null && dto.getLocation().length() >0) {
				hql.append("and u.location like '" + dto.getLocation()+"%'");
			}
			
			if (dto.getUserId() > 0) {
				hql.append("and u.userId = " + dto.getUserId());
			}
		
		}
		Query<HomeStayDTO> query = session.createQuery(hql.toString(), HomeStayDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<HomeStayDTO> list = query.getResultList();
		log.info("HomeStayDAOImpl Search method End");
		return list;
	}

	
}
