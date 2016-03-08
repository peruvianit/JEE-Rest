package it.peruvianit.data.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

public class Tbl1004ErrorDao extends GenericDao {
	Logger logger = Logger.getLogger(Tbl1004ErrorDao.class);
	
	private Tbl1004ErrorDao(EntityManager em) {
		super(em);		
	}
	
	public static Tbl1004ErrorDao getInstance(final EntityManager em) throws Exception {
		if (em == null) {
			throw new Exception("Repository configuration not found!");
		}
		return new Tbl1004ErrorDao(em);
	}
}
