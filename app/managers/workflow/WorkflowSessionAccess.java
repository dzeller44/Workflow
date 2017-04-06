package managers.workflow;

import java.util.List;

import javax.annotation.Nullable;

import com.avaje.ebean.Ebean;

import managers.workflow.WorkflowSessionData;
import managers.workflow.WorkflowSessionManager;
import models.enums.workflow.WorkflowRole;
import models.workflow.WorkflowSession;
import models.workflow.WorkflowUser;
import play.mvc.Controller;
import play.mvc.Http;

/**
 * @author Rich Helton
 *
 */
public class WorkflowSessionAccess extends Controller {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public static WorkflowSessionData createUserSession(WorkflowUser user) {
		// Logger.debug("createUserSession(WorkflowUser
		// user)--->"+user.getEmail());
		WorkflowSessionData sessionData = WorkflowSessionData.createFromUser(user);
		Http.Session session = session();

		WorkflowSessionManager.putSessionData(session, sessionData, user.getFullName(), user.getEmail(),
				user.getUserKey(), user.getRole(), user.getRoleName());

		return sessionData;
	}

	/**
	 * Return String email
	 * 
	 * @return string value
	 */
	public static String getSessionEmail() {
		WorkflowSessionData sessionData = WorkflowSessionManager.getSessionData(session());
		return sessionData.getEmail();
	}

	/**
	 * Return String user id
	 * 
	 * @return string value
	 */
	public static String getSessionID() {
		WorkflowSessionData sessionData = WorkflowSessionManager.getSessionData(session());
		return sessionData.getUserId();
	}

	/**
	 * Return String role
	 * 
	 * @return boolean value
	 */
	public static WorkflowRole getSessionRole() {
		WorkflowSessionData sessionData = WorkflowSessionManager.getSessionData(session());
		return sessionData.getRole();
	}

	public static String getSessionRolename() {
		WorkflowSessionData sessionData = WorkflowSessionManager.getSessionData(session());
		return sessionData.getRolename();
	}

	/**
	 * Return String user key
	 * 
	 * @return string value
	 */
	public static String getSessionUserKey() {
		WorkflowSessionData sessionData = WorkflowSessionManager.getSessionData(session());
		return sessionData.getUserkey();
	}

	/**
	 * Return true if user have session
	 * 
	 * @return boolean value
	 */
	public static boolean isAuthenticated() {
		WorkflowSessionData sessionData = WorkflowSessionManager.getSessionData(session());
		return isAuthenticated(sessionData);
	}

	/**
	 * 
	 * @param sessionData
	 * @return
	 */
	protected static boolean isAuthenticated(@Nullable WorkflowSessionData sessionData) {
		if (sessionData == null)
			return false;

		// Use email as key...
		WorkflowUser user = Ebean.find(models.workflow.WorkflowUser.class).where().eq("email", sessionData.getEmail())
				.findUnique();
		String userId = "";
		if (user != null) {
			userId = user.getFullName();
			return true;
		} else {
			return false;
		}

	}

	public static void removeSessionRecords(WorkflowUser user) {
		// Get all session records based on the user's email...
		String email = user.getEmail();
		List<WorkflowSession> sessionRecords = WorkflowSession.findByEmail(email);
		// Remove all the records...
		for (WorkflowSession session : sessionRecords) {
			session.delete();
		}
	}

}
