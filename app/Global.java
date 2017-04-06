import com.google.inject.Inject;

import play.*;
import play.mvc.Http;
import play.mvc.Http.Context;
import utils.ScheduleEmail;


public class Global extends GlobalSettings {
	@Override
	@Inject
	public void onStart(Application app) {
		Logger.debug("Application started...");
		// Turn on scheduler?
		String schedulerEnabled;
		schedulerEnabled = Configuration.root().getString("scheduler.enabled");
		if (schedulerEnabled.equals("true")) {
			ScheduleEmail.scheduleReminder();
		}
	}

	@Override
	public void onStop(Application app) {
		Logger.debug("Application shutdown...");
	}

}
