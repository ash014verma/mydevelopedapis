package com.ashish.design.system.project.lms.master;

import org.springframework.util.StringUtils;

import com.ashish.design.system.project.lms.LMSSystemException;
import com.ashish.design.system.project.lms.Resource;
import com.ashish.design.system.project.lms.Role;
import com.ashish.design.system.project.lms.Team;
import com.ashish.design.system.project.lms.TeamTypeEnum;

public class MasterTestTeam extends Team {


	public void addResource(Resource resource) throws LMSSystemException{
		if(isTestRole(resource)) {
			testMasterLMSTeamSet.add(resource);
			teamMap.put(TeamTypeEnum.MASTER_TEST_TEAM, testMasterLMSTeamSet);
		}else {
			throw new LMSSystemException("wrong team selection");
		}
	}
	public void removeResource(Resource resource) throws LMSSystemException {
		if(isTestRole(resource)) {
			testMasterLMSTeamSet.remove(resource);
			teamMap.put(TeamTypeEnum.MASTER_TEST_TEAM, testMasterLMSTeamSet);
		}

	}
	private boolean isTestRole(Resource resource) throws LMSSystemException {
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
			return Role.TESTER.equals(resource.getRole()) ? Boolean.TRUE : Boolean.FALSE;
		}
		else {
			throw new LMSSystemException("resource name is null or empty.");
		}
	}

}
