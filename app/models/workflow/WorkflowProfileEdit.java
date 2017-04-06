package models.workflow;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

import models.Card;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Dan Zeller
 *
 */
@Entity
public class WorkflowProfileEdit extends Model {

	@Id
	private Long id;

	@Constraints.Required
	public String appName;
	
	@Constraints.MaxLength(10000)
	public String appDesc;
	
	@Constraints.Required
	public String appInitialStep;
	
	@Constraints.Required
	public String appOwner;
	
	@Constraints.Required
	public String appOwnerEmail;
	
	@Constraints.Required
	public String appAgency;
	
	public String appKey;
	
	public String editKey;

	public String updatedBy;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateCreated;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateUpdated;

	// -- Queries (long id, user.class)
	public static Model.Finder<Long, WorkflowProfileEdit> find = new Model.Finder<Long, WorkflowProfileEdit>(Long.class, WorkflowProfileEdit.class);

	public static WorkflowProfileEdit findByEditKey(String editKey) {
		return find.where().eq("editKey", editKey).findUnique();
	}
	
	public static WorkflowProfileEdit findByUniqueKey(String uniqueKey) {
		return find.where().eq("appKey", uniqueKey).findUnique();
	}
	
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			WorkflowProfileEdit record = WorkflowProfileEdit.findByUniqueKey(uniqueKey);
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

	public String getAppAgency() {
		return appAgency;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public String getAppKey() {
		return appKey;
	}

	public String getAppName() {
		return appName;
	}

	public String getAppOwner() {
		return appOwner;
	}

	public String getAppOwnerEmail() {
		return appOwnerEmail;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public String getEditKey() {
		return editKey;
	}

	public Long getId() {
		return id;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setAppAgency(String appAgency) {
		this.appAgency = appAgency;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}

	public void setAppOwnerEmail(String appOwnerEmail) {
		this.appOwnerEmail = appOwnerEmail;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public void setEditKey(String editKey) {
		this.editKey = editKey;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
