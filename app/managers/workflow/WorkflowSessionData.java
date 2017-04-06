package managers.workflow;

import models.enums.workflow.WorkflowRole;
import models.workflow.WorkflowUser;

/**
 * @author Rich Helton
 *
 */
public class WorkflowSessionData {

	private String email;
	private String userId;
	private String userkey;
	private WorkflowRole role;
	private String rolename;

	public static WorkflowSessionData createFromUser(WorkflowUser user) {
		// store user session
		WorkflowSessionData sessionData = new WorkflowSessionData();
		sessionData.setUserId(user.getFullName());
		sessionData.setEmail(user.getEmail());
		sessionData.setUserkey(user.getUserKey());
		sessionData.setRole(user.getRole());
		sessionData.setRolename(user.getRoleName());
		return sessionData;
	}

	public static WorkflowSessionData getNew() {
		return new WorkflowSessionData();
	}

	public String getEmail() {
		return email;
	}

	public WorkflowRole getRole() {
		return role;
	}

	public String getRolename() {
		return rolename;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserkey() {
		return userkey;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(WorkflowRole role) {
		this.role = role;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	private void setUserId(String id) {
		userId = id;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

}
