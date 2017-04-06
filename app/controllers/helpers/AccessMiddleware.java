/**
 * 
 */
package controllers.helpers;

import java.util.List;

import javax.annotation.Nullable;

import com.avaje.ebean.Ebean;

import managers.SessionData;
import managers.SessionManager;
import models.Session;
import models.User;
import models.enums.RoleType;
import play.mvc.Controller;
import play.mvc.Http;

/**
 * @author rhelton
 *
 */
public class AccessMiddleware extends Controller {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public static SessionData createUserSession(User user) {
		// Logger.debug("createUserSession(User user)--->"+user.getEmail());
		SessionData sessionData = SessionData.createFromUser(user);
		Http.Session session = session();

		SessionManager.putSessionData(session, sessionData, user.getFullname(), user.getEmail(), user.getUserkey(), user.getRole(), user.getRolename());

		return sessionData;
	}

	/**
	 * Return String email
	 * 
	 * @return string value
	 */
	public static String getSessionEmail() {
		SessionData sessionData = SessionManager.getSessionData(session());
		return sessionData.getEmail();
	}

	/**
	 * Return String user id
	 * 
	 * @return string value
	 */
	public static String getSessionID() {
		SessionData sessionData = SessionManager.getSessionData(session());
		return sessionData.getUserId();
	}
	
	/**
	 * Return String role
	 * 
	 * @return boolean value
	 */
	public static RoleType getSessionRole() {
		SessionData sessionData = SessionManager.getSessionData(session());
		return sessionData.getRole();
	}
	
	public static String getSessionRolename() {
		SessionData sessionData = SessionManager.getSessionData(session());
		return sessionData.getRolename();
	}
	
	/**
	 * Return String user key
	 * 
	 * @return string value
	 */
	public static String getSessionUserKey() {
		SessionData sessionData = SessionManager.getSessionData(session());
		return sessionData.getUserkey();
	}
	
	/**
	 * Return true if user have session
	 * 
	 * @return boolean value
	 */
	public static boolean isAuthenticated() {
		SessionData sessionData = SessionManager.getSessionData(session());
		return isAuthenticated(sessionData);
	}

	/**
	 * 
	 * @param sessionData
	 * @return
	 */
	protected static boolean isAuthenticated(@Nullable SessionData sessionData) {
		if (sessionData == null)
			return false;
		
		// Use email as key...
		User user = Ebean.find(models.User.class).where().eq("email", sessionData.getEmail()).findUnique();
		String userId = "";
		if (user != null) {
			userId = user.getFullname();
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public static void removeSessionRecords(User user) {
		// Get all session records based on the user's email...
		String email = user.getEmail();
		List<Session> sessionRecords = Session.findByEmail(email);
		// Remove all the records...
		for (Session session : sessionRecords) {
			session.delete();
		}
	}

}
