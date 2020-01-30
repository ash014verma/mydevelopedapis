package za.co.discovery.assignment.dao;

import za.co.discovery.assignment.entity.PlanetEntity;
import za.co.discovery.assignment.entity.RouteEntity;
import za.co.discovery.assignment.entity.TrafficEntity;

public interface IBaseDAO {
	public void persistPlanetEntity(PlanetEntity entity);
	public void persistRouteEntity(RouteEntity entity);
	public void persistTrafficEntity(TrafficEntity entity);
}
