package models.workflow;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Dan Zeller
 *
 */
@Entity
public class WorkflowRouting extends Model {

	@Id
	private Long id;

	@Constraints.Required
	public String appName;
	
	public String appKey;
	
	@Constraints.Required
	public String routeName;
	
	@Constraints.Required
	public Integer routeSeq;
	
	@Constraints.Required
	public String routeType;
	
	@Constraints.Required
	public String routeIsFinalStep;
	
	@Constraints.Required
	public String routeNextStep;
	
	@Constraints.Required
	public String routeNextStepKey;
	
	@Constraints.Required
	public String routePrevStep;
	
	@Constraints.Required
	public String routePrevKey;
	
	@Constraints.Required
	public String routeNotify;
	
	@Constraints.Required
	public String routeMessage;
	
	public String routeKey;
	
	public String editKey;
	
	public String updatedBy;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateCreated;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateUpdated;

	// -- Queries (long id, user.class)
	public static Model.Finder<Long, WorkflowRouting> find = new Model.Finder<Long, WorkflowRouting>(Long.class, WorkflowRouting.class);

	public static WorkflowRouting findByUniqueKey(String uniqueKey) {
		return find.where().eq("uniquekey", uniqueKey).findUnique();
	}
	
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			WorkflowRouting record = WorkflowRouting.findByUniqueKey(uniqueKey);
			if (record != null) {
				// Found key, not unique...
				Logger.debug("Unique Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// Key is unique...
				Logger.debug("Unique Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}

		return uniqueKey;
	}
}
