package za.co.discovery.assignment.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import za.co.discovery.assignment.businessobject.FileUploadBusinessObject;
import za.co.discovery.assignment.serviceinterface.IFileUploadService;
import za.co.discovery.assignment.vo.PlanetVO;
import za.co.discovery.assignment.vo.RouteVO;

@Service("fileUploadService")
public class FileUploadService implements IFileUploadService{
	@Named("fileUploadBusinessObject")
	@Inject
	FileUploadBusinessObject fileUploadBusinessObject;

	@Override
	public void save(List<Serializable> voList) {
		fileUploadBusinessObject.saveData(voList);

	}

	@Override
	public List<PlanetVO> fetchPlanets() {
		return fileUploadBusinessObject.fetchPlanets();
	}

	@Override
	public List<RouteVO> fetchRouteDtl() {
		return fileUploadBusinessObject.fetchRouteDtl();
	}

}
