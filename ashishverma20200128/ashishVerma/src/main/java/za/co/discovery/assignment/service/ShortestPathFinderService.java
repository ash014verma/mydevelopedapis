package za.co.discovery.assignment.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import za.co.discovery.assignment.businessobject.FileUploadBusinessObject;
import za.co.discovery.assignment.vo.PlanetVO;
import za.co.discovery.assignment.vo.RouteVO;

@Service("shortestPathFinderService")
public class ShortestPathFinderService {
	@Named("fileUploadBusinessObject")
	@Inject
	FileUploadBusinessObject fileUploadBusinessObject;
	private  DecimalFormat df = new DecimalFormat("#.##");
	private  String displayShortestPath(Double distance[], List<PlanetVO> planetVOList){
		StringBuilder builder = new StringBuilder("");
		for (int i = 1; i < planetVOList.size(); i++) {
			builder.append("Shortest path of planet " + planetVOList.get(i).getPlanetName() + " from Earth is : " + df.format(distance[i]) + "\n");
		}
		return builder.toString();
	}

	public  String shortestPath(Double graphAdMatrix[][], int src, List<PlanetVO> planetVOList){
		Double distance[] = new Double[planetVOList.size()];
		Boolean shortestPathSet[] = new Boolean[planetVOList.size()];
		for (int i = 0; i < planetVOList.size(); i++) {
			distance[i] = Double.MAX_VALUE;
			shortestPathSet[i] = false;
		}
		distance[src] = 0.0;
		for (int count = 0; count < planetVOList.size() - 1; count++) {

			int u = minimumDistance(distance, shortestPathSet, planetVOList.size());

			shortestPathSet[u] = true;

			for (int v = 0; v < planetVOList.size(); v++)

				if (!shortestPathSet[v] && graphAdMatrix[u][v] != 0 &&
				distance[u] != Integer.MAX_VALUE && distance[u] + graphAdMatrix[u][v] < distance[v])
					distance[v] = distance[u] + graphAdMatrix[u][v];
		}
		return displayShortestPath(distance, planetVOList);
	}

	private  int minimumDistance(Double distance[], Boolean shortestPathSet[], int planetCount){
		Double min = Double.MAX_VALUE;
		int minIndex = -1;
		for (int v = 0; v < planetCount; v++)
			if (shortestPathSet[v] == Boolean.FALSE && distance[v] <= min) {
				min = distance[v];
				minIndex = v;
			}
		return minIndex;
	}

	public  Double[][] prepareAdjacencyMatrix(List<PlanetVO> planetVOList,List<RouteVO> routeVOList){
		List<ImmutablePair<String, String>> pairList = new ArrayList<>();
		HashMap<ImmutablePair<String, String>, Double> hashMap = new HashMap<>();
		for(RouteVO routeVO : routeVOList) {
			ImmutablePair<String, String> pair = ImmutablePair.of(routeVO.getPlanetOrigin(), routeVO.getPlanetDestination());
			pairList.add(pair);
			hashMap.put(pair, routeVO.getDistance());
		}
		Double adjacencyMatrix[][] = new Double[planetVOList.size()][planetVOList.size()];
		for(int i = 0; i < planetVOList.size(); i++) {
			for(int j = 0; j < planetVOList.size(); j++) {
				if(i == j) {
					adjacencyMatrix[i][j] = Double.valueOf(0.0d);
				}else  {
					ImmutablePair<String,String> pair = ImmutablePair.of(planetVOList.get(i).getPlanetNode(), planetVOList.get(j).getPlanetNode());
					if(pairList.contains(pair)) {
						adjacencyMatrix[i][j] = hashMap.get(pair);
					}else {
						adjacencyMatrix[i][j] = Double.valueOf(0.0d);
					}
				}

			}
		}
		return adjacencyMatrix;
	}

}