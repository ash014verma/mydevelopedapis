package za.co.discovery.assignment.vo;

import java.io.Serializable;

public class PlanetVO implements Serializable{

	private Long id;
	private String planetNode;
	private String planetName;
	private static final long serialVersionUID = 1L;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlanetNode() {
		return this.planetNode;
	}

	public void setPlanetNode(String planetNode) {
		this.planetNode = planetNode;
	}
	public String getPlanetName() {
		return this.planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	@Override
	public String toString() {
		return "PlanetVO [planetNode=" + planetNode + ", planetName=" + planetName + "]";
	}



}
