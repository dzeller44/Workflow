/**
 * 
 */
package models.workflow;

import java.util.Date;
import java.util.List;
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
public class WorkflowLookup extends Model {

	@Id
	public Long id;
	
	@Constraints.Required
	public String lookupType;	

	@Constraints.Required
	public String name;	

	public String description;	
	
	@Constraints.Required
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateCreated;
	
	@Constraints.Required
	public String lookupKey;

	public String updatedBy;
	
	public String userKey;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateUpdated;
	
    // -- Queries (long id, profile.class)
    public static Model.Finder<Long, WorkflowLookup> find = new Model.Finder<Long, WorkflowLookup>(Long.class, WorkflowLookup.class);
       
    public static List<WorkflowLookup> filterByType(String type) {
		return find.where().eq("lookupType", type).findList();
	} 
    
    public static List<WorkflowLookup> findAllByType(String type) {
        return find.where().eq("lookupType", type).findList();
    } 
    
	public static WorkflowLookup findByName(String name) {
        return find.where().eq("name", name).findUnique();
    }
	
	public static WorkflowLookup findByUniqueKey(String uniqueKey) {
		return find.where().eq("lookupKey", uniqueKey).findUnique();
	}
	
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			WorkflowLookup lookup = WorkflowLookup.findByUniqueKey(uniqueKey);
			if (lookup != null) {
				// Found unique, not unique...
				Logger.debug("WorkflowLookup.createUniqueKey: unique Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// unique Key is unique...
				Logger.debug("WorkflowLookup.createUniqueKey: unique Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}

		return uniqueKey;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public String getLookupKey() {
		return lookupKey;
	}

	public String getLookupType() {
		return lookupType;
	}

	public String getName() {
		return name;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}


}
