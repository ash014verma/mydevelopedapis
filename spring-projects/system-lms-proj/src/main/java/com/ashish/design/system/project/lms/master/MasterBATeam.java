package com.ashish.design.system.project.lms.master;

import org.springframework.util.StringUtils;

import com.ashish.design.system.project.lms.domain.Team;
import com.ashish.design.system.project.lms.enums.Role;
import com.ashish.design.system.project.lms.enums.TeamTypeEnum;
import com.ashish.design.system.project.lms.exception.LMSSystemException;
import com.ashish.design.system.project.lms.vo.Resource;

public class MasterBATeam extends Team {

	public void addResource(Resource resource) throws LMSSystemException{
		if(isBARole(resource)) {
			baMasterLMSTeamSet.add(resource);
			teamMap.put(TeamTypeEnum.MASTER_BA_TEAM, baMasterLMSTeamSet);
		}else {
			throw new LMSSystemException("wrong team selection");
		}
	}
	public void removeResource(Resource resource) throws LMSSystemException {
		if(isBARole(resource)) {
			baMasterLMSTeamSet.remove(resource);
			teamMap.put(TeamTypeEnum.MASTER_BA_TEAM, baMasterLMSTeamSet);
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
