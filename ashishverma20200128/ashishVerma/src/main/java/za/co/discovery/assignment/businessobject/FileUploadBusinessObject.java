package za.co.discovery.assignment.businessobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;

import za.co.discovery.assignment.dao.FileUploadDAO;
import za.co.discovery.assignment.entity.PlanetEntity;
import za.co.discovery.assignment.entity.RouteEntity;
import za.co.discovery.assignment.entity.TrafficEntity;
import za.co.discovery.assignment.vo.PlanetVO;
import za.co.discovery.assignment.vo.RouteVO;
import za.co.discovery.assignment.vo.TrafficVO;

@Named("fileUploadBusinessObject")
public class FileUploadBusinessObject implements IFileUploadBusinessObject{
	@Named("fileUploadDAO")
	@Inject
	FileUploadDAO fileUploadDAO;

	@Override
	public void saveData(List<Serializable> voList) {
		for(Serializable serial : voList) {
			if(serial instanceof PlanetVO) {
				PlanetEntity planetEntity = new PlanetEntity();
				BeanUtils.copyProperties(serial, planetEntity);
				fileUploadDAO.savePlanetEntity(planetEntity);
			}else if(serial instanceof RouteVO) {
				RouteEntity routeEntity = new RouteEntity();
				BeanUtils.copyProperties(serial, routeEntity);
				fileUploadDAO.saveRouteEntity(routeEntity);
			}else if(serial instanceof TrafficVO) {
				TrafficEntity trafficEntity = new TrafficEntity();
				BeanUtils.copyProperties(serial, trafficEntity);
				fileUploadDAO.saveTrafficEntity(trafficEntity);
			}
		}

	}

	@Override
	public List<PlanetVO> fetchPlanets() {
		List<PlanetEntity> planetEntityList=  fileUploadDAO.fetchPlanets();
		List<PlanetVO> planetVOList = new ArrayList<>();
		for(PlanetEntity planetEntity : planetEntityList) {
			PlanetVO planetVO = new PlanetVO();
			BeanUtils.copyProperties(planetEntity, planetVO);
			planetVOList.add(planetVO);
		}
		return planetVOList;
	}

	@Override
	public List<RouteVO> fetchRouteDtl() {
		List<RouteEntity> routeEntityList=  fileUploadDAO.fetchRouteDtl();
		List<RouteVO> routeVOList = new ArrayList<>();
		for(RouteEntity routeEntity : routeEntityList) {
			RouteVO routeVO = new RouteVO();
			BeanUtils.copyProperties(routeEntity, routeVO);
			routeVOList.add(routeVO);
		}
		return routeVOList;
	}

	@Override
	public Long findPlanetId(String planetNode) {
		return fileUploadDAO.findPlanetId(planetNode);
	}

}
