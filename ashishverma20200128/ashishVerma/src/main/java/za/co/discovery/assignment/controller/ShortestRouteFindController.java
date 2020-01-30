package za.co.discovery.assignment.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.discovery.assignment.service.FileUploadService;
import za.co.discovery.assignment.service.ShortestPathFinderService;
import za.co.discovery.assignment.vo.PlanetVO;

@RestController("shortestRouteFindController")
@RequestMapping("/shortestRouteFindController")
public class ShortestRouteFindController extends BaseController{

	@Named("fileUploadService")
	@Inject
	FileUploadService fileUploadService;

	@Named("shortestPathFinderService")
	@Inject
	ShortestPathFinderService shortestPathFinderService;
	@RequestMapping(value = {"/shortestroute"}, method = {RequestMethod.GET})
	public String init(Model model, HttpServletRequest request) {
		try {
		List<PlanetVO> planetVOList = fileUploadService.fetchPlanets();
		Double[][] graph = shortestPathFinderService.prepareAdjacencyMatrix(planetVOList, fileUploadService.fetchRouteDtl());
		if(graph.length != 0) {
			return shortestPathFinderService.shortestPath(graph, 0, planetVOList);
		}
		return "please upload the file first";
		}catch(Exception e) {
			return "Exception occurred!" + e.getMessage() ;
		}
	}

}
