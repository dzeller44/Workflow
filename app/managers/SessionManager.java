/**
 * 
 */
package managers;

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

import models.Session;
import models.enums.RoleType;
import play.mvc.Http;
import utils.DateUtils;
import utils.SessionIdentifierGenerator;

/**
 * @author rhelton
 *
 */
public class SessionManager {
    private final static Pattern sessionRePattern = Pattern.compile("[a-zA-Z0-9-]{20,40}");
    private final static HashMap<String, SessionData> sessionHash = Maps.newHashMap();
    private final static int  SESSION_EXPIRED_HOURS = 8;
/*
 * session.timeout = 60
#session expire 8 hours after they are generated
session.expire = 8
    private final static int  SESSION_EXPIRED_HOURS = AppGlobals.getSessionExpireHour();

 */
    
    /**
     * Validate session id
     * @param sessionId
     * @return
     */
    private static boolean checkSession(String sessionId){
        if (Strings.isNullOrEmpty(sessionId))
            return false;
        Matcher matcher = sessionRePattern.matcher(sessionId);
        return matcher.matches();
    }

    
    /**
     * GEt user session id from http session object
     * @param session
     * @return
     */
    public static String getSessionId(Http.Session session){
        if (session == null)
            return "";

        if (!session.containsKey("SESSION_ID")){
            String sessionId = SessionIdentifierGenerator.nextSessionId();// java.util.UUID.randomUUID().toString();
            session.put("SESSION_ID", sessionId);
            return sessionId;
        }

        return session.get("SESSION_ID");
    }  
    /**
     * Manually check the session timeout by checking userTimeout value in session
     * @param sessionRequest
     * @return
     */
    private static boolean isSessionTimeout(Http.Session sessionRequest){

        // see if the session is expired
        String previousTick = sessionRequest.get("userTimeout");

        if (previousTick == null || previousTick.equals("")) {
            return true; //expire as no value set
        }

        long previousT = Long.valueOf(previousTick);
        long currentT = new Date().getTime();
//        long timeout = Long.valueOf(AppGlobals.getSessionTimeout()) * 1000 * 60;
        long timeout = 60 * 1000 * 60;

        long diff = (currentT - previousT);

        if(diff > timeout){
            return true;
        }else{
            return false;
        }
    }    
    
    /**
     * Get user data from session
     * @param httpSession
     * @return
     */
    @NotNull
    public static SessionData getSessionData(Http.Session httpSession) {
        String sessionId = getSessionId(httpSession);
        boolean isTimeout = isSessionTimeout(httpSession);
        SessionData sessionData = null;

        if (checkSession(sessionId) && !isTimeout){
            if (sessionHash.containsKey(sessionId)){
                sessionData =  sessionHash.get(sessionId);
            }else{
        		Session session = Ebean.find(models.Session.class).where().eq("id",sessionId).findUnique();
                try {
                    if (DateUtils.getHoursBetweenDate(new Date(), session.getExpirationDate()) > SESSION_EXPIRED_HOURS) {
                        // Session is expired, must be remove from db
                        removeSessionBySessionId(sessionId);
                    }else{
                        Gson gson = new GsonBuilder().create();
                        sessionData = gson.fromJson(session.getData(), SessionData.class);
                    }
                } catch (Exception e){
                    e.printStackTrace();
 //                   Logger.error("Session manager error. Cannot decode json. Invalid format");

                    // Bad session Json - must be remove from db
                    removeSessionBySessionId(sessionId);
                }
            }

            setSessionTimeout(httpSession); //update session timeout
        }

        return Optional.fromNullable(sessionData).or(SessionData.getNew());
    }
    
    /*
    * Put user custom data in session
    * @param sessionRequest
    * @param sessionData
    * @param userId
    */
   public static void putSessionData(Http.Session sessionRequest, SessionData sessionData, String userId, String email, String userkey, RoleType role, String rolename) {
       if (userId == null || userId.equals("")) return;
       String sessionId = getSessionId(sessionRequest);
       if (!checkSession(sessionId)) return;

       if (sessionHash.containsKey(sessionId)) {
           sessionHash.remove(sessionId);
       }
       sessionHash.put(sessionId, sessionData);

       Gson gson = new GsonBuilder().create();
       Session session = Ebean.find(models.Session.class).where().eq("id", sessionId).findUnique();

 //      Session session = Session.query.getByHashOrNew(sessionId);

       if (session == null || session.getUserId() == null) {
           session = new Session();
           session.setExpirationDate(new Date());
           session.setHash(sessionId);
           session.setData(gson.toJson(sessionData, SessionData.class));
           session.setUserId(userId);
           session.setEmail(email);
           session.setUserkey(userkey);
           session.setRole(role);
           session.setRolename(rolename);
           session.save();
       } else {
    	   
    	   String json = gson.toJson(sessionData, SessionData.class);
           session.setData(json);
           session.update();
       }
       setSessionTimeout(sessionRequest); //update session timeout
   }

   /**
    * Setting the userTimeout value in session
    * @param sessionRequest
    */
   private static void setSessionTimeout(Http.Session sessionRequest){
       String tickString = Long.toString(new Date().getTime());
       sessionRequest.put("userTimeout",tickString);
   }
   /**
    * Remove user session data from db
    * @param sessionId
    */
   public static void removeSessionBySessionId(String sessionId){
       if (!checkSession(sessionId)) return;
		Session session = Ebean.find(models.Session.class).where().eq("id",sessionId).findUnique();
       if (session != null) session.delete();
   }
 
   /**
    * Clear session data
    * @param userId
    */
   public static void clearSessionData(Long userId){
 //      List<Session> sessions = Session.query.getByUserId(userId);
       List<Session> sessions = Ebean.find(models.Session.class).where().eq("user_id", userId).findList();

       for (Session session : sessions) {
           if (sessionHash.containsKey(session.getHash())) {
               sessionHash.remove(session.getHash());
           }
           session.delete();
       }
   }
 
   
}
