package it.peruvianit.data.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

public class Tbl1005ClientAccessDao extends GenericDao {
	Logger logger = Logger.getLogger(Tbl1005ClientAccessDao.class);
	
	private Tbl1005ClientAccessDao(EntityManager em) {
		super(em);		
	}
	
	public static Tbl1005ClientAccessDao getInstance(final EntityManager em) throws Exception {
		if (em == null) {
			throw new Exception("Repository configuration not found!");
		}
		return new Tbl1005ClientAccessDao(em);
	}
}
