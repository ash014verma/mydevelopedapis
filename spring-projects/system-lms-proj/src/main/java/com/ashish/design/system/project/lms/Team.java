package com.ashish.design.system.project.lms;

import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Team {
	protected static EnumMap<TeamTypeEnum, Set<Resource>> teamMap = new EnumMap<>(TeamTypeEnum.class);
	protected static Set<Resource> devUploadLMSTeamSet = new LinkedHashSet<>();
	protected static Set<Resource> baUploadLMSTeamSet = new LinkedHashSet<>();
	protected static Set<Resource> testUploadLMSTeamSet = new LinkedHashSet<>();
	protected static Set<Resource> devMasterLMSTeamSet = new LinkedHashSet<>();
	protected static Set<Resource> baMasterLMSTeamSet = new LinkedHashSet<>();
	protected static Set<Resource> testMasterLMSTeamSet = new LinkedHashSet<>();
	public abstract void addResource(Resource resource) throws LMSSystemException;
	public abstract void removeResource(Resource resource) ;
	public static int displayTeamSize(TeamTypeEnum teamType) {
		return teamMap.get(teamType) != null ? teamMap.get(teamType).size() : - 1;
	}
	public static Set<Resource> getTeam(TeamTypeEnum teamType) {
		return teamMap.get(teamType);
	}
}
