package utils;

import play.Play;

public class AppGlobals {

	public static Integer getSessionTimeout() {
		return Play.application().configuration().getInt("session.timeout");
	}

    public static Integer getSessionExpireHour(){
        return  Play.application().configuration().getInt("session.expire");
    }
    
    /**
     * 
     * @return
     */
    public static String getAssigmentTimer() {
		return Play.application().configuration().getString("coassist.timer");
    }
	
}
