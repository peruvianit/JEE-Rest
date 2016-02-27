package it.peruvianit.data.dao;

import javax.persistence.EntityManager;

public class GenericDao {
	protected EntityManager em;

	public static GenericDao getDaoInstance(final EntityManager em) {
		return new GenericDao(em);
	}

	protected GenericDao(final EntityManager em) {
		super();
		this.em = em;
	}
	
	public <T extends Object> T save(final T entity) {
		em.persist(entity);
		return entity;
	}
}
