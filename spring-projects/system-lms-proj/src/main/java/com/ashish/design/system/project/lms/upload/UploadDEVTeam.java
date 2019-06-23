package com.ashish.design.system.project.lms.upload;

import java.util.Arrays;

import org.springframework.util.StringUtils;

import com.ashish.design.system.project.lms.LMSSystemException;
import com.ashish.design.system.project.lms.Resource;
import com.ashish.design.system.project.lms.Role;
import com.ashish.design.system.project.lms.Team;
import com.ashish.design.system.project.lms.TeamTypeEnum;

public class UploadDEVTeam extends Team{

	public void addResource(Resource resource) throws LMSSystemException{
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
			if(Arrays.asList(Role.DEVELOPER, Role.TL, Role.STL).contains(resource.getRole())) {
				devUploadLMSTeamSet.add(resource);
				teamMap.put(TeamTypeEnum.UPLOAD_DEV_TEAM, devUploadLMSTeamSet);
			}else {
				throw new LMSSystemException("wrong team selection");
			}
		}
	}
	public void removeResource(Resource resource) {
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
			devUploadLMSTeamSet.remove(resource);
			teamMap.put(TeamTypeEnum.UPLOAD_DEV_TEAM, devUploadLMSTeamSet);
		}
	}
}




