package com.ashish.design.system.project.lms.master;

import java.util.Arrays;

import org.springframework.util.StringUtils;

import com.ashish.design.system.project.lms.domain.Team;
import com.ashish.design.system.project.lms.enums.Role;
import com.ashish.design.system.project.lms.enums.TeamTypeEnum;
import com.ashish.design.system.project.lms.exception.LMSSystemException;
import com.ashish.design.system.project.lms.vo.Resource;

public class MasterDEVTeam extends Team {

	public void addResource(Resource resource) throws LMSSystemException{
		if(isDEVRole(resource)) {
			devMasterLMSTeamSet.add(resource);
			teamMap.put(TeamTypeEnum.MASTER_DEV_TEAM, devMasterLMSTeamSet);
		}else {
			throw new LMSSystemException("wrong team selection");
		}
	}
	public void removeResource(Resource resource) throws LMSSystemException {
		if(isDEVRole(resource)) {
			devMasterLMSTeamSet.remove(resource);
			teamMap.put(TeamTypeEnum.MASTER_DEV_TEAM, devMasterLMSTeamSet);
		}
	}
	private boolean isDEVRole(Resource resource) throws LMSSystemException {
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
			return Arrays.asList(Role.DEVELOPER, Role.TL, Role.STL).contains(resource.getRole()) 
					? Boolean.TRUE : Boolean.FALSE;
		}
		else {
			throw new LMSSystemException("resource name is null or empty.");
		}
	}
}
