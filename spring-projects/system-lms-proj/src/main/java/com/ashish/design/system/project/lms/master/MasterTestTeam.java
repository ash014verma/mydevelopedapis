package com.ashish.design.system.project.lms.master;

import org.springframework.util.StringUtils;

import com.ashish.design.system.project.lms.LMSSystemException;
import com.ashish.design.system.project.lms.Resource;
import com.ashish.design.system.project.lms.Role;
import com.ashish.design.system.project.lms.Team;
import com.ashish.design.system.project.lms.TeamTypeEnum;

public class MasterTestTeam extends Team {

	
	public void addResource(Resource resource) throws LMSSystemException{
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
				if(resource.getRole().equals(Role.TESTER)) {
					testMasterLMSTeamSet.add(resource);
					teamMap.put(TeamTypeEnum.MASTER_TEST_TEAM, testMasterLMSTeamSet);
				}else {
					throw new LMSSystemException("wrong team selection");
				}
		}
	}
	public void removeResource(Resource resource) {
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
				if(resource.getRole().equals(Role.TESTER)) {
					testMasterLMSTeamSet.remove(resource);
					teamMap.put(TeamTypeEnum.MASTER_TEST_TEAM, testMasterLMSTeamSet);
				}
		}
	}



}
