package com.ashish.design.system.project.lms.master;

import com.ashish.design.system.project.lms.Team;
import com.ashish.design.system.project.lms.TeamTypeEnum;

public class MasterTeamFactory {
	private static MasterDEVTeam masterDevTeam = null;
	private static MasterBATeam masterBATeam = null;
	private static MasterTestTeam masterTestTeam = null;

	public static Team createTeam(TeamTypeEnum teamType) {
		if(teamType.equals(TeamTypeEnum.MASTER_DEV_TEAM)) {
			return masterDevTeam != null ? masterDevTeam : new MasterDEVTeam();
		}
		else if(teamType.equals(TeamTypeEnum.MASTER_BA_TEAM)) {
			return masterBATeam != null ? masterBATeam : new MasterBATeam();
		}
		else if(teamType.equals(TeamTypeEnum.MASTER_TEST_TEAM)) {
			return masterTestTeam != null ? masterTestTeam : new MasterTestTeam();
		}
		else {
			return null;
		}
	}

}
