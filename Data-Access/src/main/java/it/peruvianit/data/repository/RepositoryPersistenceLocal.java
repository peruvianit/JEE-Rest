package it.peruvianit.data.repository;

import javax.persistence.EntityManager;

public interface RepositoryPersistenceLocal {
	EntityManager getEntityManager();
}
