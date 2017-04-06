/**
 * 
 */
package managers;

import models.User;
import models.enums.RoleType;
//import models.enums.RoleType;

/**
 * @author rhelton
 *
 */
public class SessionData {

	private String email;
	private String userId;
	private String userkey;
	private RoleType role;
	private String rolename;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public static SessionData createFromUser(User user) {
        //store user session
        SessionData sessionData = new SessionData();        
        sessionData.setUserId(user.getFullname());
        sessionData.setEmail(user.getEmail());
        sessionData.setUserkey(user.getUserkey());
        sessionData.setRole(user.getRole());
        sessionData.setRolename(user.getRolename());		
        return sessionData;
	}
	
	public static SessionData getNew() {
		return new SessionData();
	}

	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}


	public String getUserkey() {
		return userkey;
	}


	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	private void setUserId(String id) {
		userId = id;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
