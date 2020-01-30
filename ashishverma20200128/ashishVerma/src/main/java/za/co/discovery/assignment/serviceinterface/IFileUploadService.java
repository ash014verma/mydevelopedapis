package za.co.discovery.assignment.serviceinterface;

import java.io.Serializable;
import java.util.List;

import za.co.discovery.assignment.vo.PlanetVO;
import za.co.discovery.assignment.vo.RouteVO;

public interface IFileUploadService {
	public void save(List<Serializable> voList);
	public List<PlanetVO> fetchPlanets();
	public List<RouteVO> fetchRouteDtl();

}
