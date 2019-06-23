package com.ashish.design.system.project.lms.upload;

import org.springframework.util.StringUtils;

import com.ashish.design.system.project.lms.LMSSystemException;
import com.ashish.design.system.project.lms.Resource;
import com.ashish.design.system.project.lms.Role;
import com.ashish.design.system.project.lms.Team;
import com.ashish.design.system.project.lms.TeamTypeEnum;

public class UploadTestTeam extends Team {


	public void addResource(Resource resource) throws LMSSystemException{
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
			if(resource.getRole().equals(Role.TESTER)) {
				testUploadLMSTeamSet.add(resource);
				teamMap.put(TeamTypeEnum.UPLOAD_TEST_TEAM, testUploadLMSTeamSet);
			}else {
				throw new LMSSystemException("wrong team selection");
			}
		}
	}
	public void removeResource(Resource resource) {
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
			if(resource.getRole().equals(Role.TESTER)) {
				testUploadLMSTeamSet.remove(resource);
				teamMap.put(TeamTypeEnum.UPLOAD_TEST_TEAM, testUploadLMSTeamSet);
			}
		}
	}



}
