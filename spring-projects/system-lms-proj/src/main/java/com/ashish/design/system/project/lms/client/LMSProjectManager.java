package com.ashish.design.system.project.lms;

import java.util.Set;

public class LMSProjectManager {
	private static LMSProjectManager projectManager = new LMSProjectManager();
	private LMSProjectManager() {

	}
	public static LMSProjectManager getProjectManager() {
		return projectManager;
	}
	public Team createTeam(TeamTypeEnum teamType, Set<Resource> resources) throws LMSSystemException {
		Team team  = TeamFactory.createTeam(teamType);
		resources.forEach((resource) -> {
			try {
				team.addResource(resource);
			} catch (LMSSystemException e) {
				e.printStackTrace();
			}
		});
		return team;
	}
	public void createTeams(Set<Resource> resources) {
		resources.forEach((resource) -> {try {
			TeamFactory.createTeam(resource.getTeamName()).addResource(resource);
		} catch (LMSSystemException e) {
			e.printStackTrace();
		}
		});
	}
	public  void shuffleResource(TeamTypeEnum oldTeam, Resource resource, TeamTypeEnum newTeam) throws LMSSystemException {
		Team team  = TeamFactory.createTeam(oldTeam);
		team.removeResource(resource);
		team  = TeamFactory.createTeam(newTeam);
		team.addResource(resource);
	}
	public Set<Resource> getTeam(TeamTypeEnum teamType) {
		return Team.getTeam(teamType);
		
	}
	public int getTeamSize(TeamTypeEnum teamType) {
		return Team.displayTeamSize(teamType);
	}

}
