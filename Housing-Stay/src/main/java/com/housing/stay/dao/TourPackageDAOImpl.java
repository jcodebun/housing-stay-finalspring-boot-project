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

import com.housing.stay.dto.TourPackageDTO;




@Repository
public class TourPackageDAOImpl implements TourPackageDAOInt {

	private static Logger log = Logger.getLogger(TourPackageDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(TourPackageDTO dto) {
		log.info("TourPackageDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("TourPackageDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(TourPackageDTO dto) {
		log.info("TourPackageDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("TourPackageDAOImpl Delete method End");

	}

	@Override
	public TourPackageDTO findBypk(long pk) {
		log.info("TourPackageDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		TourPackageDTO dto = (TourPackageDTO) session.get(TourPackageDTO.class, pk);
		log.info("TourPackageDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public TourPackageDTO findByName(String name) {
		log.info("TourPackageDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TourPackageDTO.class);
		criteria.add(Restrictions.eq("name",name));
		TourPackageDTO dto = (TourPackageDTO) criteria.uniqueResult();
		log.info("TourPackageDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(TourPackageDTO dto) {
		log.info("TourPackageDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("TourPackageDAOImpl update method End");
	}

	@Override
	public List<TourPackageDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<TourPackageDTO> list(int pageNo, int pageSize) {
		log.info("TourPackageDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<TourPackageDTO> query = session.createQuery("from TourPackageDTO", TourPackageDTO.class);
		List<TourPackageDTO> list = query.getResultList();
		log.info("TourPackageDAOImpl List method End");
		return list;
	}

	@Override
	public List<TourPackageDTO> search(TourPackageDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<TourPackageDTO> search(TourPackageDTO dto, int pageNo, int pageSize) {
		log.info("TourPackageDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from TourPackageDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getHomeStayId() > 0) {
				hql.append("and u.homeStayId = " + dto.getHomeStayId());
			}
			
			if (dto.getName() != null && dto.getName().length() >0) {
				hql.append("and u.name like '" + dto.getName()+"%'");
			}
			
			if (dto.getDestination() != null && dto.getDestination().length() >0) {
				hql.append("and u.destination like '" + dto.getDestination()+"%'");
			}
			
			if (dto.getUserId() > 0) {
				hql.append("and u.userId = " + dto.getUserId());
			}
		}
		Query<TourPackageDTO> query = session.createQuery(hql.toString(), TourPackageDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<TourPackageDTO> list = query.getResultList();
		log.info("TourPackageDAOImpl Search method End");
		return list;
	}

	
}
