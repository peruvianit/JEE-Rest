package it.peruvianit.data.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import it.peruvianit.data.exception.DataAccesException;

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
}
