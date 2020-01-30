package za.co.discovery.assignment.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import za.co.discovery.assignment.entity.PlanetEntity;
import za.co.discovery.assignment.entity.RouteEntity;
import za.co.discovery.assignment.entity.TrafficEntity;

@Repository("baseDAO")
public class BaseDAO implements IBaseDAO{
	private EntityManagerFactory entityManagerFactory;


	@Override
	public void persistPlanetEntity(PlanetEntity entity) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public void persistRouteEntity(RouteEntity entity) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();

	}

	@Override
	public void persistTrafficEntity(TrafficEntity entity) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();

	}
	@PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}



}
