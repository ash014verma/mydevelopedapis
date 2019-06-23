package com.ashish.design.system.project.lms;

import java.util.Arrays;

import com.ashish.design.system.project.lms.master.MasterTeamFactory;
import com.ashish.design.system.project.lms.upload.UploadTeamFactory;

public class TeamFactory {
	public static Team createTeam(TeamTypeEnum teamType) {
		if(Arrays.asList(TeamTypeEnum.MASTER_BA_TEAM,TeamTypeEnum.MASTER_DEV_TEAM,
				TeamTypeEnum.MASTER_TEST_TEAM ).contains(teamType)){
			return MasterTeamFactory.createTeam(teamType);
		}else if(Arrays.asList(TeamTypeEnum.UPLOAD_BA_TEAM,TeamTypeEnum.UPLOAD_DEV_TEAM,
				TeamTypeEnum.UPLOAD_TEST_TEAM ).contains(teamType)) {
			return UploadTeamFactory.createTeam(teamType);
		}
		return null;
	}
}
