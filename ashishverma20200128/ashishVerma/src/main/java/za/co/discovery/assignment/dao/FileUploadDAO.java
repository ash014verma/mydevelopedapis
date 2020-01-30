package za.co.discovery.assignment.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import za.co.discovery.assignment.entity.PlanetEntity;
import za.co.discovery.assignment.entity.RouteEntity;
import za.co.discovery.assignment.entity.TrafficEntity;

@Repository("fileUploadDAO")
public class FileUploadDAO extends BaseDAO implements IFileUploadDAO{

	@Override
	public void savePlanetEntity(PlanetEntity entity) {
		super.persistPlanetEntity(entity);
	}

	@Override
	public void saveRouteEntity(RouteEntity entity) {
		super.persistRouteEntity(entity);
	}

	@Override
	public void saveTrafficEntity(TrafficEntity entity) {
		super.persistTrafficEntity(entity);

	}

	@Override
	public List<PlanetEntity> fetchPlanets() {
		TypedQuery<PlanetEntity> query = this.getEntityManagerFactory().createEntityManager().createNamedQuery("getPlanets", PlanetEntity.class);
		return query.getResultList();
	}

	@Override
	public List<RouteEntity> fetchRouteDtl() {
		TypedQuery<RouteEntity> query = this.getEntityManagerFactory().createEntityManager().createNamedQuery("routeDetail", RouteEntity.class);
		return query.getResultList();
	}

	@Override
	public Long findPlanetId(String planetNode) {
		Query query = this.getEntityManagerFactory().createEntityManager().createNamedQuery("getPlanetId");
		query.setParameter("planetNode", planetNode);
		return (Long) query.getSingleResult();

	}

}
