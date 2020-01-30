package za.co.discovery.assignment.helper;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import za.co.discovery.assignment.vo.PlanetVO;
import za.co.discovery.assignment.vo.RouteVO;

public class ShortestPathFinder {

	private static DecimalFormat df = new DecimalFormat("#.##");

	private static String displayShortestPath(Double distance[], List<PlanetVO> planetVOList){
		StringBuilder builder = new StringBuilder("");
		for (int i = 1; i < planetVOList.size(); i++) {
			builder.append("Shortest path of planet " + planetVOList.get(i).getPlanetName() + " from Earth is : " + df.format(distance[i]) + "\n");
		}
		return builder.toString();

	}

	public static String shortestPath(Double graphAdMatrix[][], int src, List<PlanetVO> planetVOList){
		Double distance[] = new Double[planetVOList.size()]; // The output array. distance[i] will hold
		Boolean shortestPathSet[] = new Boolean[planetVOList.size()];
		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < planetVOList.size(); i++) {
			distance[i] = Double.MAX_VALUE;
			shortestPathSet[i] = false;
		}
		// Distance of source vertex from itself is always 0
		distance[src] = 0.0;
		// Find shortest path for all vertices
		for (int count = 0; count < planetVOList.size() - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minimumDistance(distance, shortestPathSet, planetVOList.size());
			// Mark the picked vertex as processed
			shortestPathSet[u] = true;
			// Update distance value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < planetVOList.size(); v++)
				// Update distance[v] only if is not in shortestPathSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of distance[v]
				if (!shortestPathSet[v] && graphAdMatrix[u][v] != 0 &&
				distance[u] != Integer.MAX_VALUE && distance[u] + graphAdMatrix[u][v] < distance[v])
					distance[v] = distance[u] + graphAdMatrix[u][v];
		}

		return displayShortestPath(distance, planetVOList);
	}

	private static int minimumDistance(Double distance[], Boolean shortestPathSet[], int planetCount){
		// Initialize min value
		Double min = Double.MAX_VALUE;
		int minIndex = -1;

		for (int v = 0; v < planetCount; v++)
			if (shortestPathSet[v] == Boolean.FALSE && distance[v] <= min) {
				min = distance[v];
				minIndex = v;
			}
		return minIndex;
	}

	public static Double[][] prepareAdjacencyMatrix(List<PlanetVO> planetVOList,List<RouteVO> routeVOList){
		Double adjacencyMatrix[][] = new Double[planetVOList.size()][planetVOList.size()];
		HashMap<String, String> map = new LinkedHashMap<>();
		HashMap<HashMap<String, String>, Double> hashMap = new LinkedHashMap<>();
		for(RouteVO routeVO : routeVOList) {
			map.put(routeVO.getPlanetOrigin(), routeVO.getPlanetDestination());
			hashMap.put(map, routeVO.getDistance());
		}
		for(int i = 0; i < planetVOList.size(); i++) {
			for(int j = 0; j < planetVOList.size(); j++) {
				if(planetVOList.get(j).getPlanetNode().equals(map.get(planetVOList.get(i).getPlanetNode()))) {
					adjacencyMatrix[i][j]=hashMap.get(map);
				}else {
					adjacencyMatrix[i][j]=0.0;
				}
			}
		}
		return adjacencyMatrix;
	}

}