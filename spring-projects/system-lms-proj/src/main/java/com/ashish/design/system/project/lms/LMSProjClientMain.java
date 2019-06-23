package com.ashish.design.system.project.lms;

import java.util.LinkedHashSet;
import java.util.Set;

public class LMSProjClientMain {
	public static void main(String[] args) throws LMSSystemException {
		LMSProjectManager manager = LMSProjectManager.getProjectManager();
		Set<Resource> resources = new LinkedHashSet<>();
		/*Upload BA Team*/
		resources.add(new Resource("Lalit Arora", Role.BA, TeamTypeEnum.UPLOAD_BA_TEAM));
		resources.add(new Resource("Harjot Kaur", Role.BA, TeamTypeEnum.UPLOAD_BA_TEAM));
		resources.add(new Resource("Rita Saini", Role.BA, TeamTypeEnum.UPLOAD_BA_TEAM));
		resources.add(new Resource("Rahul Jain", Role.BA, TeamTypeEnum.UPLOAD_BA_TEAM));
		
		/*Upload DEV Team */
		resources.add(new Resource("Meenu Garg", Role.STL, TeamTypeEnum.UPLOAD_DEV_TEAM));
		resources.add(new Resource("Ashish Kumar Verma", Role.TL, TeamTypeEnum.UPLOAD_DEV_TEAM));
		resources.add(new Resource("Rajat Tyagi", Role.DEVELOPER, TeamTypeEnum.UPLOAD_DEV_TEAM));
		resources.add(new Resource("Shagun Tyagi", Role.DEVELOPER, TeamTypeEnum.UPLOAD_DEV_TEAM));
		resources.add(new Resource("Pooja Gupta", Role.DEVELOPER, TeamTypeEnum.UPLOAD_DEV_TEAM));
		resources.add(new Resource("Amit Yadav", Role.DEVELOPER, TeamTypeEnum.UPLOAD_DEV_TEAM));
		resources.add(new Resource("Amit Yadav", Role.DEVELOPER, TeamTypeEnum.UPLOAD_DEV_TEAM));
		
		/*Upload Testing Team */
		resources.add(new Resource("Deependra Singh", Role.TESTER, TeamTypeEnum.UPLOAD_TEST_TEAM));
		resources.add(new Resource("Tushar Mittal", Role.TESTER, TeamTypeEnum.UPLOAD_TEST_TEAM));
		
		/*Master BA Team */
		resources.add(new Resource("Ashish Gupta", Role.BA, TeamTypeEnum.MASTER_BA_TEAM));
		
		/*Master DEV Team */
		resources.add(new Resource("Meenu Garg", Role.STL, TeamTypeEnum.MASTER_DEV_TEAM));
		resources.add(new Resource("Ashish Kumar Verma", Role.TL, TeamTypeEnum.MASTER_DEV_TEAM));
		resources.add(new Resource("Aishwary Gupta", Role.DEVELOPER, TeamTypeEnum.MASTER_DEV_TEAM));
		resources.add(new Resource("Aishwarya Kaushik", Role.DEVELOPER, TeamTypeEnum.MASTER_DEV_TEAM));
		resources.add(new Resource("Ekta Kumari", Role.DEVELOPER, TeamTypeEnum.MASTER_DEV_TEAM));
		
		/*Master Testing Team */
		resources.add(new Resource("Deependra Singh", Role.TESTER, TeamTypeEnum.MASTER_TEST_TEAM));
		resources.add(new Resource("Ashish Chaudhary", Role.TESTER, TeamTypeEnum.MASTER_TEST_TEAM));
		
		manager.createTeams(resources);
		System.out.println(manager.getTeamSize(TeamTypeEnum.UPLOAD_DEV_TEAM));
		System.out.println(manager.getTeam(TeamTypeEnum.UPLOAD_DEV_TEAM));
		
		System.out.println(manager.getTeamSize(TeamTypeEnum.UPLOAD_BA_TEAM));
		System.out.println(manager.getTeam(TeamTypeEnum.UPLOAD_BA_TEAM));
		
		System.out.println(manager.getTeamSize(TeamTypeEnum.UPLOAD_TEST_TEAM));
		System.out.println(manager.getTeam(TeamTypeEnum.UPLOAD_TEST_TEAM));
		
		System.out.println(manager.getTeamSize(TeamTypeEnum.MASTER_DEV_TEAM));
		System.out.println(manager.getTeam(TeamTypeEnum.MASTER_DEV_TEAM));
		
		System.out.println(manager.getTeamSize(TeamTypeEnum.MASTER_BA_TEAM));
		System.out.println(manager.getTeam(TeamTypeEnum.MASTER_BA_TEAM));
		
		
		
		System.out.println(manager.getTeamSize(TeamTypeEnum.MASTER_TEST_TEAM));
		System.out.println(manager.getTeam(TeamTypeEnum.MASTER_TEST_TEAM));
	}

}
