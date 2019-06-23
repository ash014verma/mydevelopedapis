package com.ashish.design.system.project.lms.upload;

import org.springframework.util.StringUtils;

import com.ashish.design.system.project.lms.domain.Team;
import com.ashish.design.system.project.lms.enums.Role;
import com.ashish.design.system.project.lms.enums.TeamTypeEnum;
import com.ashish.design.system.project.lms.exception.LMSSystemException;
import com.ashish.design.system.project.lms.vo.Resource;

public class UploadBATeam extends Team {

	public void addResource(Resource resource) throws LMSSystemException{
		if(isBARole(resource)) {
			baUploadLMSTeamSet.add(resource);
			teamMap.put(TeamTypeEnum.UPLOAD_BA_TEAM, baUploadLMSTeamSet);
		}else {
			throw new LMSSystemException("wrong team selection");
		}
	}
	public void removeResource(Resource resource) throws LMSSystemException {
		if(isBARole(resource)) {
				baUploadLMSTeamSet.remove(resource);
				teamMap.put(TeamTypeEnum.UPLOAD_DEV_TEAM, baUploadLMSTeamSet);
			}
	}
	private boolean isBARole(Resource resource) throws LMSSystemException {
		if(resource != null && !StringUtils.isEmpty(resource.getName())) {
			return Role.BA.equals(resource.getRole()) ? Boolean.TRUE : Boolean.FALSE;
		}
		else {
			throw new LMSSystemException("resource name is null or empty.");
		}
	}
}
