package com.ashish.design.system.project.lms.upload;

import java.util.Arrays;

import org.springframework.util.StringUtils;

import com.ashish.design.system.project.lms.domain.Team;
import com.ashish.design.system.project.lms.enums.Role;
import com.ashish.design.system.project.lms.enums.TeamTypeEnum;
import com.ashish.design.system.project.lms.exception.LMSSystemException;
import com.ashish.design.system.project.lms.vo.Resource;

public class UploadDEVTeam extends Team{

	public void addResource(Resource resource) throws LMSSystemException{
		if(isDEVRole(resource)){
			devUploadLMSTeamSet.add(resource);
			teamMap.put(TeamTypeEnum.UPLOAD_DEV_TEAM, devUploadLMSTeamSet);
		}else {
			throw new LMSSystemException("wrong team selection");
		}
	}
	public void removeResource(Resource resource) throws LMSSystemException {
		if(isDEVRole(resource)){
			devUploadLMSTeamSet.remove(resource);
			teamMap.put(TeamTypeEnum.UPLOAD_DEV_TEAM, devUploadLMSTeamSet);
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




