package za.co.discovery.assignment.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import za.co.discovery.assignment.service.FileUploadService;
import za.co.discovery.assignment.vo.FileUploadVO;
import za.co.discovery.assignment.vo.PlanetVO;
import za.co.discovery.assignment.vo.RouteVO;
import za.co.discovery.assignment.vo.TrafficVO;



@Controller("fileUploadController")
@RequestMapping("/fileUploadController")
public class FileUploadController extends BaseController{
	@Named("excelPOIHelper")
	@Inject
	ExcelPOIHelper excelPOIHelper;

	@Named("fileUploadService")
	@Inject
	FileUploadService fileUploadService;
	@RequestMapping(value = {"/fileupload"}, method = {RequestMethod.GET})
	public ModelAndView init(Model model, HttpServletRequest request) {
		return new ModelAndView("fileupload", "FileUploadVO", new FileUploadVO());
	}

	@RequestMapping(value = {"/uploadfunctionality/fileUpload"}, method = {RequestMethod.POST})
	@ResponseBody
	public String uploadFile(@ModelAttribute("FileUploadVO")FileUploadVO fileUploadVO,BindingResult result, Model model, HttpServletRequest request) throws IOException {
		CommonsMultipartFile fileData = fileUploadVO.getFileData();

		//TODO to validate the file with appropriate file format and data
		OutputStream os = null;
		File file = null;
		try {
			file = File.createTempFile("temp", ".xlsx");
			os = new FileOutputStream(file);
			os.write(fileData.getBytes());

			if (!fileData.isEmpty()) {
				try {
					Map<Integer, Map<Integer, List<MyCell>>> map = excelPOIHelper.readExcel(file.getAbsolutePath());
					if(map.size()== 0) {
						throw new Exception("The file format is not xls or xlsx");
					}
					List<Serializable> planetList = new ArrayList<>();
					List<Serializable> routeList = new ArrayList<>();
					List<Serializable> trafficList = new ArrayList<>();

					for(Entry<Integer, Map<Integer, List<MyCell>>> entry : map.entrySet()) {
						if(entry.getKey() == 0) {
							for(Entry<Integer, List<MyCell>> entrySet : entry.getValue().entrySet()) {
								PlanetVO planetVO = new PlanetVO();
								List<MyCell> cellList = entrySet.getValue();
								if(entrySet.getKey() != 0) {
									planetVO.setPlanetNode(cellList.get(0).getContent());
									planetVO.setPlanetName(cellList.get(1).getContent());
									planetList.add(planetVO);
								}
							}
						}else if(entry.getKey() == 1) {
							for(Entry<Integer, List<MyCell>> entrySet : entry.getValue().entrySet()) {
								RouteVO routeVO = new RouteVO();
								List<MyCell> cellList = entrySet.getValue();
								if(entrySet.getKey() != 0) {
									routeVO.setRouteId(Long.valueOf(Double.valueOf(cellList.get(0).getContent()).longValue()));
									routeVO.setPlanetOrigin(cellList.get(1).getContent());
									routeVO.setPlanetDestination(cellList.get(2).getContent());
									routeVO.setDistance(Double.valueOf(cellList.get(3).getContent()));
									routeList.add(routeVO);
								}
							}

						}else if(entry.getKey() == 2) {
							for(Entry<Integer, List<MyCell>> entrySet : entry.getValue().entrySet()) {
								TrafficVO trafficVO = new TrafficVO();
								List<MyCell> cellList = entrySet.getValue();
								if(entrySet.getKey() != 0) {
									trafficVO.setRouteId(Long.valueOf(Double.valueOf(cellList.get(0).getContent()).longValue()));
									trafficVO.setPlanetOrigin(cellList.get(1).getContent());
									trafficVO.setPlanetDestination(cellList.get(2).getContent());
									trafficVO.setTrafficDelay(Double.valueOf(cellList.get(3).getContent()));
									trafficList.add(trafficVO);
								}
							}

						}

					}
					fileUploadService.save(planetList);
					fileUploadService.save(routeList);
					fileUploadService.save(trafficList);
					System.out.println(map);
					return "You successfully uploaded file";
				} catch (Exception e) {
					return "You failed to upload " + e.getMessage();
				}
			} else {
				return "You failed to upload "
						+ " because the file was empty.";
			}
		}
		finally {
			if(os!= null) {
				file.delete();
				os.close();
			}
		}
	}
}
