package it.peruvianit.data.dao;

import javax.persistence.EntityManager;

import it.peruvianit.data.exception.DataAccesException;

public class GenericDao {
	protected EntityManager em;

	public static GenericDao getDaoInstance(final EntityManager em) {
		return new GenericDao(em);
	}

	protected GenericDao(final EntityManager em) {
		super();
		this.em = em;
	}
	
	public <T extends Object> T save(final T entity) throws DataAccesException {
		try{
			em.persist(entity);
		}catch(Exception ex){
			throw new DataAccesException(ex.getMessage());
		}
		return entity;
	}
}
