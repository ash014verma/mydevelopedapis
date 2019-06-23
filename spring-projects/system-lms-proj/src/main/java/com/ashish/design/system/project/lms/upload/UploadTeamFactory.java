package com.ashish.design.system.project.lms.upload;

import com.ashish.design.system.project.lms.domain.Team;
import com.ashish.design.system.project.lms.enums.TeamTypeEnum;

public class UploadTeamFactory {
	
	private static UploadDEVTeam uploadDevTeam = null;
	private static UploadBATeam uploadBATeam = null;
	private static UploadTestTeam uploadTestTeam = null;
	
	public static Team createTeam(TeamTypeEnum teamType) {
		if(teamType.equals(TeamTypeEnum.UPLOAD_DEV_TEAM)) {
			return uploadDevTeam != null ? uploadDevTeam : new UploadDEVTeam();
		}
		else if(teamType.equals(TeamTypeEnum.UPLOAD_BA_TEAM)) {
			return uploadBATeam != null ? uploadBATeam : new UploadBATeam();
		}
		else if(teamType.equals(TeamTypeEnum.UPLOAD_TEST_TEAM)) {
			return uploadTestTeam != null ? uploadTestTeam : new UploadTestTeam();
		}
		else {
			return null;
		}
	}

}
