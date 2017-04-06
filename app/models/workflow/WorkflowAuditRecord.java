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
public class WorkflowAuditRecord extends Model {

	@Id
	public Long id;
	
	@Constraints.Required
	public String author;
	
	@Constraints.Required
	public String authorEmail;
	
	@Constraints.Required
	public String authorkey;
	
	@Constraints.Required
	public String message;
	
	@Constraints.Required
	public String parentKey;
	
	@Constraints.Required
	public String uniqueKey;
		
	@Constraints.Required
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateCreated;
	
	// -- Queries (long id, profile.class)
	public static Model.Finder<Long, WorkflowAuditRecord> find = new Model.Finder<Long, WorkflowAuditRecord>(Long.class, WorkflowAuditRecord.class);
	
	public static WorkflowAuditRecord findByAuditKey(String uniqueKey) {
		return find.where().eq("uniqueKey", uniqueKey).findUnique();
	}
	
	public static List<WorkflowAuditRecord> getAllByParentKey(String parentKey) {
		return find.where().eq("parentKey", parentKey).findList();
	}
	
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			WorkflowAuditRecord unique = WorkflowAuditRecord.findByAuditKey(uniqueKey);
			if (unique != null) {
				// Found key, not unique...
				Logger.debug(
						"Comment.createCommentKey: card Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// Key is unique...
				Logger.debug("Comment.createCommentKey: card Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}

		return uniqueKey;
	}

	public String getAuthor() {
		return author;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public String getAuthorkey() {
		return authorkey;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public String getParentKey() {
		return parentKey;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public void setAuthorkey(String authorkey) {
		this.authorkey = authorkey;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
}
