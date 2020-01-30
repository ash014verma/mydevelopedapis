package za.co.discovery.assignment.businessobject;

import java.io.Serializable;
import java.util.List;

import za.co.discovery.assignment.vo.PlanetVO;
import za.co.discovery.assignment.vo.RouteVO;

public interface IFileUploadBusinessObject {
	public void saveData(List<Serializable> voList);
	public List<PlanetVO> fetchPlanets();
	public List<RouteVO> fetchRouteDtl();
	public Long findPlanetId(String planetNode);
}
