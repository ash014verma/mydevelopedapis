package za.co.discovery.assignment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Entity implementation class for Entity: PlanetEntity
 *
 */

@Entity
@DynamicInsert
@DynamicUpdate
@Table(schema ="APP" ,name = "PLANET_DTL")
@NamedQueries({@NamedQuery(name ="findPlanetCount", query = "select count(p) from PlanetEntity p"),
	@NamedQuery(name ="getPlanets", query = "select p from PlanetEntity p"),
	@NamedQuery(name ="getPlanetId", query = "select p.id from PlanetEntity p where p.planetNode =:planetNode")})
public class PlanetEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "PLANET_NODE")
	private String planetNode;
	@Column(name = "PLANET_NAME")
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

}
