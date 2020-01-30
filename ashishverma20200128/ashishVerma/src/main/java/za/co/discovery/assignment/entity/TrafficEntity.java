package za.co.discovery.assignment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Entity implementation class for Entity: TrafficEntity
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(schema ="APP" ,name = "TRAFFIC_DTL")
public class TrafficEntity  implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name= "ROUTE_ID")
	private Long routeId;
	@Column(name= "PLANET_ORIGIN")
	private String planetOrigin;
	@Column(name= "PLANET_DESTINATION")
	private String planetDestination;
	@Column(name= "TRAFFIC_DELAY")
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

}
