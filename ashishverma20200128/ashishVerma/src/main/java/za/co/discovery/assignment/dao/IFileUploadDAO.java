package za.co.discovery.assignment.dao;

import java.util.List;

import javax.transaction.Transactional;

import za.co.discovery.assignment.entity.PlanetEntity;
import za.co.discovery.assignment.entity.RouteEntity;
import za.co.discovery.assignment.entity.TrafficEntity;

public interface IFileUploadDAO {
	@Transactional
	public void savePlanetEntity(PlanetEntity entity);
	@Transactional
	public void saveRouteEntity(RouteEntity entity);
	@Transactional
	public void saveTrafficEntity(TrafficEntity entity);

	public List<PlanetEntity> fetchPlanets();
	public List<RouteEntity> fetchRouteDtl();
	public Long findPlanetId(String planetNode);




}
