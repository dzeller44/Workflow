package models.workflow;

import play.data.format.Formats;
import play.data.validation.Constraints;

import com.avaje.ebean.Model;

import models.User;
import models.enums.workflow.WorkflowRole;
import models.utils.AppException;
import models.utils.Hash;
import play.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Dan Zeller
 *
 */
@Entity
public class WorkflowUser extends Model {

	@Id
	private Long id;

	@Constraints.Required
	@Formats.NonEmpty
	@Column(unique = true)
	private String email;

	@Constraints.Required
	@Formats.NonEmpty
	@Column(unique = true)
	public String fullName;

	// Custom Fields...
	@Constraints.Required
	@Formats.NonEmpty
	public WorkflowRole role;

	@Constraints.Required
	public String roleName;

	@Constraints.Required
	public String appName;

	@Constraints.Required
	public String appKey;

	public String active;

	@Constraints.Required
	@Formats.NonEmpty
	public String userKey;

	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateCreation;

	public String updatedBy;

	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateUpdated;

	// -- Queries (long id, user.class)
	public static Model.Finder<Long, WorkflowUser> find = new Model.Finder<Long, WorkflowUser>(Long.class,
			WorkflowUser.class);

	public static WorkflowUser findByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}

	public static WorkflowUser findByFullname(String fullname) {
		return find.where().eq("fullName", fullname).findUnique();
	}

	public static List<WorkflowUser> findByRole(WorkflowRole role) {
		return find.where().eq("role", role).findList();
	}

	public static WorkflowUser findByUserKey(String userKey) {
		return find.where().eq("userKey", userKey).findUnique();
	}

	public static List<WorkflowUser> findUserWithWildcard(String searchText) {
		return find.where().ilike("email", "%" + searchText + "%").ilike("fullName", "%" + searchText + "%").findList();
	}

	public static List<String> getNamesByRole(WorkflowRole role) {
		List<WorkflowUser> userList = WorkflowUser.findByRole(role);
		List<String> stringArray = new ArrayList<String>();
		for (WorkflowUser user : userList) {
			stringArray.add(user.getFullName());
		}
		return stringArray;
	}

	public static WorkflowUser initialize(String email) throws AppException {
		// Let's initialize the WorkflowUser...
		WorkflowUser user = null;
		user = find.where().eq("email", email).findUnique();
		if (user != null) {
			return user;
		}
		else {
			// Let's create a user with low-level access...
			user = new WorkflowUser();
			user.setEmail(email);
			user.setRole(WorkflowRole.USER);
			user.setRoleName(WorkflowRole.getRoleTextName(WorkflowRole.USER));
			user.setActive("Y");
			user.setUserKey(user.createUniqueKey());
			user.setDateCreation(new Date());
			user.save();
			return user;
		}
	}

	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			WorkflowProfile record = WorkflowProfile.findByUniqueKey(uniqueKey);
			if (record != null) {
				// Found key, not unique...
				Logger.debug("WorkflowUser Unique Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// Key is unique...
				Logger.debug("WorkflowUser Unique Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}

		return uniqueKey;
	}

	public String getActive() {
		return active;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}

	public Long getId() {
		return id;
	}

	public WorkflowRole getRole() {
		return role;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(WorkflowRole role) {
		this.role = role;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

}
