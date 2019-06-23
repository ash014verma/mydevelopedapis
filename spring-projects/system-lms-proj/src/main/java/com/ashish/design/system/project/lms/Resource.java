package com.ashish.design.system.project.lms;

public class Resource {
	private String name;
	private Role role;
	private TeamTypeEnum teamName;
	public Resource(String name) {
		this.name = name;
	}
	
	public Resource(String name, Role role, TeamTypeEnum teamName) {
		super();
		this.name = name;
		this.role = role;
		this.teamName = teamName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public TeamTypeEnum getTeamName() {
		return teamName;
	}
	public void setTeamName(TeamTypeEnum teamName) {
		this.teamName = teamName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resource other = (Resource) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role != other.role)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Resource [name=" + name + ", role=" + role + ", teamName=" + teamName + "]";
	}
	
	
}
