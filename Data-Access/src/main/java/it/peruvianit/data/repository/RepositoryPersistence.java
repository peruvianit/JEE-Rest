package it.peruvianit.data.repository;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RepositoryPersistence implements RepositoryPersistenceLocal{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		if (entityManager == null) {
			//entityManager = entityManagerFactory.createEntityManager(); // 
		}
		return entityManager;
	}		
}
