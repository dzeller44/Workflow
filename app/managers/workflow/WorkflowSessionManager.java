package managers.workflow;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jetbrains.annotations.NotNull;

import com.avaje.ebean.Ebean;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.enums.workflow.WorkflowRole;
import models.workflow.WorkflowSession;
import play.mvc.Http;
import utils.DateUtils;
import utils.SessionIdentifierGenerator;

/**
 * @author Rich Helton
 *
 */
public class WorkflowSessionManager {

	private final static Pattern sessionRePattern = Pattern.compile("[a-zA-Z0-9-]{20,40}");
	private final static HashMap<String, WorkflowSessionData> sessionHash = Maps.newHashMap();
	private final static int SESSION_EXPIRED_HOURS = 8;

	/*
	 * session.timeout = 60 #session expire 8 hours after they are generated
	 * session.expire = 8 private final static int SESSION_EXPIRED_HOURS =
	 * AppGlobals.getSessionExpireHour();
	 * 
	 */

	/**
	 * Validate session id
	 * 
	 * @param sessionId
	 * @return
	 */
	private static boolean checkSession(String sessionId) {
		if (Strings.isNullOrEmpty(sessionId))
			return false;
		Matcher matcher = sessionRePattern.matcher(sessionId);
		return matcher.matches();
	}

	/**
	 * Clear session data
	 * 
	 * @param userId
	 */
	public static void clearSessionData(Long userId) {
		// List<WorkflowSession> sessions =
		// WorkflowSession.query.getByUserId(userId);
		List<WorkflowSession> sessions = Ebean.find(models.workflow.WorkflowSession.class).where().eq("user_id", userId)
				.findList();

		for (WorkflowSession session : sessions) {
			if (sessionHash.containsKey(session.getHash())) {
				sessionHash.remove(session.getHash());
			}
			session.delete();
		}
	}

	/**
	 * Get user data from session
	 * 
	 * @param httpSession
	 * @return
	 */
	@NotNull
	public static WorkflowSessionData getSessionData(Http.Session httpSession) {
		String sessionId = getSessionId(httpSession);
		boolean isTimeout = isSessionTimeout(httpSession);
		WorkflowSessionData sessionData = null;

		if (checkSession(sessionId) && !isTimeout) {
			if (sessionHash.containsKey(sessionId)) {
				sessionData = sessionHash.get(sessionId);
			} else {
				WorkflowSession session = Ebean.find(models.workflow.WorkflowSession.class).where().eq("id", sessionId)
						.findUnique();
				try {
					if (DateUtils.getHoursBetweenDate(new Date(),
							session.getExpirationDate()) > SESSION_EXPIRED_HOURS) {
						// WorkflowSession is expired, must be remove from db
						removeSessionBySessionId(sessionId);
					} else {
						Gson gson = new GsonBuilder().create();
						sessionData = gson.fromJson(session.getData(), WorkflowSessionData.class);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// Logger.error("WorkflowSession manager error. Cannot
					// decode json.
					// Invalid format");

					// Bad session Json - must be remove from db
					removeSessionBySessionId(sessionId);
				}
			}

			setSessionTimeout(httpSession); // update session timeout
		}

		return Optional.fromNullable(sessionData).or(WorkflowSessionData.getNew());
	}

	/**
	 * GEt user session id from http session object
	 * 
	 * @param session
	 * @return
	 */
	public static String getSessionId(Http.Session session) {
		if (session == null)
			return "";

		if (!session.containsKey("SESSION_ID")) {
			String sessionId = SessionIdentifierGenerator.nextSessionId();// java.util.UUID.randomUUID().toString();
			session.put("SESSION_ID", sessionId);
			return sessionId;
		}

		return session.get("SESSION_ID");
	}

	/**
	 * Manually check the session timeout by checking userTimeout value in
	 * session
	 * 
	 * @param sessionRequest
	 * @return
	 */
	private static boolean isSessionTimeout(Http.Session sessionRequest) {

		// see if the session is expired
		String previousTick = sessionRequest.get("userTimeout");

		if (previousTick == null || previousTick.equals("")) {
			return true; // expire as no value set
		}

		long previousT = Long.valueOf(previousTick);
		long currentT = new Date().getTime();
		// long timeout = Long.valueOf(AppGlobals.getSessionTimeout()) * 1000 *
		// 60;
		long timeout = 60 * 1000 * 60;

		long diff = (currentT - previousT);

		if (diff > timeout) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Put user custom data in session
	 * 
	 * @param sessionRequest
	 * 
	 * @param sessionData
	 * 
	 * @param userId
	 */
	public static void putSessionData(Http.Session sessionRequest, WorkflowSessionData sessionData, String userId,
			String email, String userkey, WorkflowRole role, String rolename) {
		if (userId == null || userId.equals(""))
			return;
		String sessionId = getSessionId(sessionRequest);
		if (!checkSession(sessionId))
			return;

		if (sessionHash.containsKey(sessionId)) {
			sessionHash.remove(sessionId);
		}
		sessionHash.put(sessionId, sessionData);

		Gson gson = new GsonBuilder().create();
		WorkflowSession session = Ebean.find(models.workflow.WorkflowSession.class).where().eq("id", sessionId)
				.findUnique();

		// WorkflowSession session =
		// WorkflowSession.query.getByHashOrNew(sessionId);

		if (session == null || session.getUserId() == null) {
			session = new WorkflowSession();
			session.setExpirationDate(new Date());
			session.setHash(sessionId);
			session.setData(gson.toJson(sessionData, WorkflowSessionData.class));
			session.setUserId(userId);
			session.setEmail(email);
			session.setUserkey(userkey);
			session.setRole(role);
			session.setRolename(rolename);
			session.save();
		} else {

			String json = gson.toJson(sessionData, WorkflowSessionData.class);
			session.setData(json);
			session.update();
		}
		setSessionTimeout(sessionRequest); // update session timeout
	}

	/**
	 * Remove user session data from db
	 * 
	 * @param sessionId
	 */
	public static void removeSessionBySessionId(String sessionId) {
		if (!checkSession(sessionId))
			return;
		WorkflowSession session = Ebean.find(models.workflow.WorkflowSession.class).where().eq("id", sessionId)
				.findUnique();
		if (session != null)
			session.delete();
	}

	/**
	 * Setting the userTimeout value in session
	 * 
	 * @param sessionRequest
	 */
	private static void setSessionTimeout(Http.Session sessionRequest) {
		String tickString = Long.toString(new Date().getTime());
		sessionRequest.put("userTimeout", tickString);
	}

}
