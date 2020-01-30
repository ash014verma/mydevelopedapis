package za.co.discovery.assignment.vo;

import java.io.Serializable;

public class TrafficVO implements Serializable{

	private Long id;
	private Long routeId;
	private String planetOrigin;
	private String planetDestination;
	private Double trafficDelay;
	private static final long serialVersionUID = 1L;

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
	public Double getTrafficDelay() {
		return trafficDelay;
	}
	public void setTrafficDelay(Double trafficDelay) {
		this.trafficDelay = trafficDelay;
	}

	@Override
	public String toString() {
		return "TrafficVO [routeId=" + routeId + ", planetOrigin=" + planetOrigin + ", planetDestination="
				+ planetDestination + ", trafficDelay=" + trafficDelay + "]";
	}


}
