package it.peruvianit.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import it.peruvianit.data.constant.DataAccessConstant;
import it.peruvianit.data.exception.DataAccesException;
import it.peruvianit.model.entity.Tbl1002LoginAccess;

public class Tbl1002LoginAccessDao extends GenericDao {
	Logger logger = Logger.getLogger(Tbl1002LoginAccessDao.class);
	
	private Tbl1002LoginAccessDao(EntityManager em) {
		super(em);		
	}
	
	public static Tbl1002LoginAccessDao getInstance(final EntityManager em) throws DataAccesException {
		if (em == null) {
			throw new DataAccesException("Repository configuration not found!");
		}
		return new Tbl1002LoginAccessDao(em);
	}
	
	
	public Tbl1002LoginAccess findByRequestSignature(String requestSignature) throws DataAccesException {
		TypedQuery<Tbl1002LoginAccess> query = em.createNamedQuery(DataAccessConstant.TBL1002LOGIN_ACCESS_FIND_BY_REQUEST_SIGNATURE,Tbl1002LoginAccess.class);

		query.setParameter("requestSignature", requestSignature);
		
		return query.getSingleResult();
	}
	
	public List<Tbl1002LoginAccess> findByIdUserAgent(Integer idUserAgent) throws DataAccesException {
		TypedQuery<Tbl1002LoginAccess> query = em.createNamedQuery(DataAccessConstant.TBL1002LOGIN_ACCESS_FIND_BY_ID_USER_AGENT,Tbl1002LoginAccess.class);

		query.setParameter("idUserAgent", idUserAgent);
		
		return query.getResultList();
	}
}
