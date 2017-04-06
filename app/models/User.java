package models;

import models.enums.RoleType;
import models.utils.AppException;
import models.utils.Hash;
import play.data.format.Formats;
import play.data.validation.Constraints;
import com.avaje.ebean.Model;
import play.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User: yesnault Date: 20/01/12
 */
@Entity
public class User extends Model {

	@Id
	private Long id;

	@Constraints.Required
	@Formats.NonEmpty
	@Column(unique = true)
	private String email;

	@Constraints.Required
	@Formats.NonEmpty
	@Column(unique = true)
	public String fullname;

	public String agency;
	
	public String confirmationToken;

	@Constraints.Required
	@Formats.NonEmpty
	public String passwordHash;

	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateCreation;

	@Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date datePasswordRemind;

	@Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date dateRemind;

	@Formats.NonEmpty
	public Boolean validated = false;

	// Custom Fields...
	@Constraints.Required
	@Formats.NonEmpty
	public RoleType role;

	@Constraints.Required
	public String rolename;

	public String approved;

	public String active;

	@Constraints.Required
	@Formats.NonEmpty
	public String userkey;

	public String updatedBy;

	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateUpdated;

	// -- Queries (long id, user.class)
	public static Model.Finder<Long, User> find = new Model.Finder<Long, User>(Long.class, User.class);

	/**
	 * Authenticate a User, from a email and clear password.
	 *
	 * @param email
	 *            email
	 * @param clearPassword
	 *            clear password
	 * @return User if authenticated, null otherwise
	 * @throws AppException
	 *             App Exception
	 */
	public static User authenticate(String email, String clearPassword) throws AppException {

		// get the user with email only to keep the salt password
		User user = find.where().eq("email", email).findUnique();
		if (user != null) {
			// get the hash password from the salt + clear password
			if (Hash.checkPassword(clearPassword, user.passwordHash)) {
				return user;
			}
		}
		return null;
	}

	public void changePassword(String password) throws AppException {
		this.passwordHash = Hash.createPassword(password);
		this.save();
	}

	/**
	 * Confirms an account.
	 *
	 * @return true if confirmed, false otherwise.
	 * @throws AppException
	 *             App Exception
	 */
	public static boolean confirm(User user) throws AppException {
		if (user == null) {
			return false;
		}

		user.confirmationToken = null;
		user.validated = true;
		user.save();
		return true;
	}

	public String createUserKey() {
		String userKey = null;

		// Make sure it is unique...
		userKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			User user = User.findByUserKey(userKey);
			if (user != null) {
				// Found user, not unique...
				Logger.debug("User.createUserKey: User Key " + userKey + " is not unique, creating a new one...");
				userKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// User Key is unique...
				Logger.debug("User.createUserKey: User Key " + userKey + " is unique.");
				isUnique = true;
			}
		}

		return userKey;
	}

	/**
	 * Retrieve a user from an email.
	 *
	 * @param email
	 *            email to search
	 * @return a user
	 */
	public static User findByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}
	public static List<User> findByRole(RoleType role) {
		return find.where().eq("role", role).findList();
	}

	/**
	 * Retrieves a user from a confirmation token.
	 *
	 * @param token
	 *            the confirmation token to use.
	 * @return a user if the confirmation token is found, null otherwise.
	 */
	public static User findByConfirmationToken(String token) {
		return find.where().eq("confirmationToken", token).findUnique();
	}

	public static List<String> getNamesByRole(RoleType role) {
		List<User> userList = User.findByRole(role);
		List<String> stringArray = new ArrayList<String>();
		for (User user : userList) {
			stringArray.add(user.fullname);
		}
		return stringArray;
	}

	/**
	 * Retrieve a user from a fullname.
	 *
	 * @param fullname
	 *            Full name
	 * @return a user
	 */
	public static User findByFullname(String fullname) {
		return find.where().eq("fullname", fullname).findUnique();
	}

	public static List<User> findByRemindDate(Date remindDate) {
		// Need to search for a date range...
		// Create a day before and a day after and use as parameters...
		Calendar cal = null;
		// Before date...
		cal = Calendar.getInstance();
		cal.setTime(remindDate);
		cal.add(Calendar.DATE, -1);
		Date beforeDate = cal.getTime();
		Logger.debug("User findByRemindDate - beforeDate: " + beforeDate);
		// After date...
		// Date has changed by a day earlier...
		// We need to add 2 days now to get day after the original remind
		// date...
		cal.add(Calendar.DATE, 2);
		Date afterDate = cal.getTime();
		Logger.debug("User findByRemindDate - afterDate: " + afterDate);

		// Query...
		return find.where().gt("dateRemind", beforeDate).lt("dateRemind", afterDate).findList();
	}

	/**
	 * Retrieves a user by unique user key.
	 *
	 * @param unique
	 *            user key.
	 * @return a user if the unique user key is found, null otherwise.
	 */
	public static User findByUserKey(String userKey) {
		return find.where().eq("userkey", userKey).findUnique();
	}

	public static List<User> findUnapprovedEM() {
		return find.where().eq("approved", "N").findList();
	}	
	
	public static List<User> findUserWithWildcard(String searchText) {
		return find.where().ilike("email", "%" + searchText + "%").ilike("fullname", "%" + searchText + "%").findList();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public RoleType getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(RoleType role) {
		this.role = role;
	}

	public String getRoleProperName(RoleType role) {
		String roleToDisplay = role.getRoleTextName(role);
		return roleToDisplay;
	}

	public String getRoleNameString(String role) {
		String roleToDisplay = RoleType.getRoleTextNameString(role);
		return roleToDisplay;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUserkey() {
		return userkey;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
