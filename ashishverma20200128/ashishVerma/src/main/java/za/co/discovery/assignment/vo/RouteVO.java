package za.co.discovery.assignment.vo;

import java.io.Serializable;

public class RouteVO implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long routeId;
	private String planetOrigin;
	private String planetDestination;
	private Double distance;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public String getPlanetOrigin() {
		return planetOrigin;
	}
	public void setPlanetOrigin(String planetOrigin) {
		this.planetOrigin = planetOrigin;
	}
	public String getPlanetDestination() {
		return planetDestination;
	}
	public void setPlanetDestination(String planetDestination) {
		this.planetDestination = planetDestination;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RouteVO [routeId=" + routeId + ", planetOrigin=" + planetOrigin + ", planetDestination="
				+ planetDestination + ", distance=" + distance + "]";
	}



}
