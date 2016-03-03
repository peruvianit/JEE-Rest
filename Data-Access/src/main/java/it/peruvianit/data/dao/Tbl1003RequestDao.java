package it.peruvianit.data.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

public class Tbl1003RequestDao extends GenericDao {
	Logger logger = Logger.getLogger(Tbl1003RequestDao.class);
	
	private Tbl1003RequestDao(EntityManager em) {
		super(em);		
	}
	
	public static Tbl1003RequestDao getInstance(final EntityManager em) throws Exception {
		if (em == null) {
			throw new Exception("Repository configuration not found!");
		}
		return new Tbl1003RequestDao(em);
	}
}
