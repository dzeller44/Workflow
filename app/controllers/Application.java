package controllers;

import static play.data.Form.form;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.mail.EmailException;

import com.opencsv.CSVWriter;

import controllers.helpers.AccessMiddleware;
import managers.SessionData;
import managers.workflow.WorkflowSessionAccess;
import managers.workflow.WorkflowSessionData;
import models.AuditLog;
import models.Card;
import models.CardAudit;
import models.CardEdit;
import models.Comment;
import models.Lookup;
import models.RemovedCard;
import models.RemovedUser;
import models.Team;
import models.User;
import models.enums.RoleType;
import models.utils.AppException;
import models.utils.Mail;
import models.workflow.WorkflowUser;
import play.Configuration;
import play.Logger;
import play.data.Form;
import play.data.validation.Constraints;
import play.i18n.Messages;
import play.libs.mailer.MailerClient;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.accessdenied;
import views.html.auth;
import views.html.contact;
import views.html.contactsent;
import views.html.exportready;
import views.html.genericsuccess;
import views.html.home;
import views.html.index;
import views.html.useraccount;
import views.html.admin.admin;
import views.html.admin.deleteconfirm;
import views.html.admin.deleteduser;
import views.html.admin.editlookup;
import views.html.admin.getuser;
import views.html.admin.lookup;
import views.html.admin.lookupcreated;
import views.html.admin.lookups;
import views.html.admin.lookupupdated;
import views.html.admin.openuser;
import views.html.admin.saveduser;
import views.html.admin.searchusers;
import views.html.admin.showuser;
import views.html.admin.usermaint;
import views.html.card.card;
import views.html.card.cardcreated;
import views.html.card.cardupdated;
import views.html.card.deletecardconfirm;
import views.html.card.deletedcard;
import views.html.card.editcard;
import views.html.card.searchcards;

/**
 * Author:	Dan Zeller/Rich Helton
 */
public class Application extends Controller {

	public static Result GO_ADMIN = redirect(routes.Application.adminHome());

	public static Result GO_HOME = redirect(routes.Application.index());

	public static Result GO_USER = redirect(routes.Application.userHome());

	public static Result USER_LOGIN = redirect(routes.Application.openLogin());

	public static Result ACCESS_DENIED = redirect(routes.Application.accessDenied());

	public static final String delimiter = "~~";

	public static String openCardKey = "";

	@Inject
	MailerClient mailerClient;

	public static class CardAdd {

		@Constraints.Required
		public String name;

		@Constraints.Required
		public String team;

		@Constraints.Required
		public String position;

		@Constraints.Required
		public String cardmaker;

		@Constraints.Required
		public Integer year;

	}

	public static class Contact {

		public String name;

		public String email;

		public String message;

	}

	public static class FindUser {

		public String approved;

		public String email;

		public String searchText;

		public String fullname;

		public String role;

		private boolean isBlank(String input) {
			return input == null || input.isEmpty() || input.trim().isEmpty();
		}

		/*
		 * public String validate() {
		 * 
		 * User user = User.findByEmail(email); if (user != null) { // Open user
		 * record... return null; } else { // Display message... return
		 * Messages.get("search.user.bademail"); } }
		 */
	}

	public static class LookupAdd {

		@Constraints.Required
		public String lookuptype;

		@Constraints.Required
		public String name;

		public String description;

		private boolean isBlank(String input) {
			return input == null || input.isEmpty() || input.trim().isEmpty();
		}

		/**
		 * Validate the authentication.
		 *
		 * @return null if validation ok, string with details otherwise
		 */
		public String validate() {

			return null;
		}
	}

	/**
	 * Login class used by Login Form.
	 */
	public static class Login {

		@Constraints.Required
		public String email;
		String errMessage = "";

		@Constraints.Required
		public String password;
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getErrMessage() {
			return errMessage;
		}

		public void setErrMessage(String errMessage) {
			this.errMessage = errMessage;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * Validate the authentication.
		 *
		 * @return null if validation ok, string with details otherwise
		 */
		public String validate() {
			Logger.debug("Login - validate()");
			User user = null;
			try {
				user = User.authenticate(this.getEmail(), this.getPassword());
				SessionData createUserSession = AccessMiddleware.createUserSession(user);
				AuditLog.setLog(user.getFullname(), user.getEmail(), "Login", "validate()", "User authenticated",
						user.getFullname());
				
				// Let's setup the Workflow Session...				
				WorkflowUser workflowUser = WorkflowUser.initialize(this.getEmail());
				WorkflowSessionData workflowCreateUserSession = WorkflowSessionAccess.createUserSession(workflowUser);

			} catch (AppException e) {
				errMessage = Messages.get("error.technical");
				return errMessage;
			}
			if (user == null) {
				errMessage = Messages.get("invalid.user.or.password");
				return errMessage;
			} else if (!user.validated) {
				errMessage = Messages.get("account.not.validated.check.mail");
				return errMessage;
			}
			return null;
		}

	}

	public static class Register {

		public String approved;

		@Constraints.Required
		public String email;

		@Constraints.Required
		public String fullname;

		@Constraints.Required
		public String inputPassword;

		// Custom fields...
		@Constraints.Required
		public String role;

		private boolean isBlank(String input) {
			return input == null || input.isEmpty() || input.trim().isEmpty();
		}

		/**
		 * Validate the authentication.
		 *
		 * @return null if validation ok, string with details otherwise
		 */
		public String validate() {
			if (isBlank(email)) {
				return "Email is required";
			}

			if (isBlank(fullname)) {
				return "User name is required";
			}

			if (isBlank(inputPassword)) {
				return "Password is required";
			} else {
				// Need to make sure we have:
				// 8 characters; 1 Uppercase character; 1 Lowercase character; 1
				// Number; 1 Special Character
				String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$!%^&+=])(?=\\S+$).{8,}";
				if (!inputPassword.matches(passwordPattern)) {
					return Messages.get("password.message");
				}
			}

			if (isBlank(role)) {
				return "Account Role is required";
			}

			return null;
		}
	}

	public static class RegisterUser {

		@Constraints.Required
		public String fullname;

		@Constraints.Required
		public String email;

		public String rolename;

		private boolean isBlank(String input) {
			return input == null || input.isEmpty() || input.trim().isEmpty();
		}

		public String validate() {
			if (isBlank(email)) {
				return "Email is required";
			}

			if (isBlank(fullname)) {
				return "User name is required";
			}

			if (isBlank(rolename)) {
				return "Role is required";
			}

			return null;
		}
	}

	public Result accessDenied() {
		// Get the current role and compare...
		String roleToDisplay = "";
		RoleType currentRole = AccessMiddleware.getSessionRole();
		if (currentRole != null) {
			roleToDisplay = currentRole.getRoleTextName(currentRole);
		}
		// Direct to access denied...
		return ok(accessdenied.render(roleToDisplay));
	}

	public Result addCard() {
		List<Lookup> lookups = Lookup.find.all();
		List<Team> teams = Team.find.all();
		return ok(card.render(form(CardAdd.class), teams, lookups));
	}

	public Result addComments(String uniquekey, String comments) {
		// Grab what we need to display on the Card form...
		Form<CardAdd> cardEntry = form(CardAdd.class).bindFromRequest();
		List<Lookup> lookups = Lookup.find.all();
		List<User> users = User.find.all();
		String userkey = AccessMiddleware.getSessionUserKey();
		User user = User.findByUserKey(userkey);
		Card card = Card.findByUniqueKey(uniquekey);
		List<Comment> allComments = Comment.getAllByCardKey(uniquekey);

		// Let's create a Comment record...
		Comment comment = new Comment();
		comment.cardkey = uniquekey;
		comment.comment = comments;
		comment.uniquekey = comment.createUniqueKey();
		comment.datecreated = new Date();
		if (user != null) {
			comment.author = user.fullname;
			comment.authoremail = user.getEmail();
			comment.userkey = userkey;
		}
		comment.save();

		// Notify team they have been assigned...
		try {
			notifyTeam(card, comment, "Comment");
		} catch (MalformedURLException m) {
			m.printStackTrace();
		}

		// Need to refresh the page...
		String url = "../opencard/" + uniquekey;

		return redirect(url);
	}

	public Result addLookup() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			List<Lookup> lookups = Lookup.find.all();
			return ok(lookup.render(lookups));
		}
	}

	public Result adminHome() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			return ok(admin.render(form(Login.class)));
		}
	}

	public Result adminSearch() {
		// NEED TO CORRECT THIS -- NEED NEW ROUTE/VIEW
		List<User> users = User.find.all();
		return ok(searchusers.render(users));
	}

	/**
	 * Handle login form submission.
	 *
	 * @return Dashboard if auth OK or login form if auth KO
	 */
	public Result authenticate() {
		String errorMessage = "";

		Form<Login> loginForm = form(Login.class).bindFromRequest();
		Logger.debug("authenticate");
		Form<Register> registerForm = form(Register.class);

		if (loginForm.hasErrors()) {
			Logger.debug("authenticate - bad request");
			// return badRequest(index.render(registerForm, loginForm));
			return badRequest(auth.render(loginForm));
			// return badRequest(index.render());
			// return badRequest();
		} else {
			Logger.debug("authenticate - good request");
			session("email", loginForm.get().email);

			boolean isAuth = AccessMiddleware.isAuthenticated();
			RoleType role = AccessMiddleware.getSessionRole();

			// Let's see if we need to redirect...
			String cardKey = openCardKey;
			if (cardKey != null) {
				if (!cardKey.equals("")) {
					// Let's redirect...
					// First remove the session variable...
					openCardKey = "";
					return redirect(routes.Application.openCard(cardKey));
				}
			}

			switch (role) {
			case USER:
				return GO_USER;

			case ADMIN:
				return GO_ADMIN;

			default:
				return GO_HOME;

			}
		}
	}

	public Result contact() {
		return ok(contact.render(form(Contact.class)));
	}

	public Result contactSend() throws EmailException {
		Form<Contact> contact = form(Contact.class).bindFromRequest();

		String name = contact.get().name;
		String email = contact.get().email;
		String message = contact.get().message;

		String subject = Messages.get("mail.contact.subject");
		String messageToSend = new String(
				"Message from: " + name + "\n at email address: " + email + "\n Message: " + message);

		String to = Messages.get("mail.admin.address");

		// create and send the email to the admin shared mailbox, containing
		// name, email and message from contact form.
		// send a copy to the email entered in the contact form.

		Mail.Envelop envelop = new Mail.Envelop(subject, messageToSend, to);
		Mail.Envelop envelop2 = new Mail.Envelop(subject, messageToSend, email);
		Mail mailer = new Mail(mailerClient);
		mailer.sendMail(envelop);
		mailer.sendMail(envelop2);

		return ok(contactsent.render());
	}

	public Result deleteCard(String cardkey) {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			// Locate the user record and delete...
			Card card = Card.findByUniqueKey(cardkey);
			if (card != null) {
				// Open user record...
				Logger.debug("Application.deleteCard: Found Card based on " + cardkey);
			} else {
				// Display message...
				Logger.debug("Application.deleteCard: No Card found based on " + cardkey);
			}

			// Create record in the removed table
			// Capture user and date/time
			// Remove from table...
			RemovedCard removedCard = new RemovedCard();

			// Copy the record over...
			removedCard.name = card.name;
			removedCard.team = card.team;
			removedCard.teamkey = card.teamkey;
			removedCard.position = card.position;
			removedCard.cardmaker = card.cardmaker;
			removedCard.year = card.year;
			removedCard.userkey = card.userkey;
			removedCard.updatedby = card.updatedby;
			removedCard.dateupdated = card.dateupdated;
			removedCard.datecreated = card.datecreated;
			removedCard.uniquekey = card.uniquekey;

			// Set custom fields...
			removedCard.dateRemoved = new Date();
			removedCard.removedBy = AccessMiddleware.getSessionEmail();
			removedCard.removedbyuserkey = AccessMiddleware.getSessionUserKey();
			removedCard.save();

			// Delete the card...
			card.delete();

			AuditLog.setLog(AccessMiddleware.getSessionID(), AccessMiddleware.getSessionEmail(), "Card", "deleteCard()",
					"Card DELETED by Admin", AccessMiddleware.getSessionID());

			return ok(deletedcard.render());

		}
	}
	
	public Result deleteCardConfirm(String cardkey) {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			Card card = Card.findByUniqueKey(cardkey);
			return ok(deletecardconfirm.render(card));
		}
	}

	public Result deleteUser(String userkey) {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			// Locate the user record and delete...
			User user = User.findByUserKey(userkey);
			if (user != null) {
				// Open user record...
				Logger.debug("Application.deleteUser: Found User based on " + userkey);
			} else {
				// Display message...
				Logger.debug("Application.deleteUser: No User found based on " + userkey);
			}

			// Create record in removedusers table
			// Capture user and date/time
			// Remove from user table...
			RemovedUser removedUser = new RemovedUser();

			// Copy the record over...
			removedUser.email = user.getEmail();
			removedUser.fullname = user.fullname;
			removedUser.agency = user.agency;
			removedUser.passwordHash = user.passwordHash;
			removedUser.confirmationToken = user.confirmationToken;
			removedUser.dateCreation = user.dateCreation;
			removedUser.active = user.active;
			removedUser.role = user.role;
			removedUser.rolename = user.rolename;
			removedUser.approved = user.approved;
			removedUser.validated = user.validated;
			removedUser.userkey = user.userkey;
			removedUser.updatedBy = user.updatedBy;
			removedUser.dateUpdated = user.dateUpdated;

			// Set custom fields...
			removedUser.dateRemoved = new Date();
			removedUser.removedBy = AccessMiddleware.getSessionEmail();
			removedUser.removedbyuserkey = AccessMiddleware.getSessionUserKey();
			removedUser.save();

			// Delete the user...
			user.delete();

			AuditLog.setLog(AccessMiddleware.getSessionID(), AccessMiddleware.getSessionEmail(), "User", "deleteUser()",
					"User DELETED by Admin", AccessMiddleware.getSessionID());

			return ok(deleteduser.render());
		}
	}

	public Result deleteUserConfirm(String userkey) {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			User user = User.findByUserKey(userkey);
			return ok(deleteconfirm.render(user));
		}
	}

	public Result exportUsers(String whatData) {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			List<User> users = null;
			String userRole = "";
			String fileName = "";
			// Download file to "Downloads" folder
			String home = System.getProperty("user.home");
			String fileLocation = home + "\\Downloads\\";
			RoleType role = AccessMiddleware.getSessionRole();
			if (role != null) {
				userRole = role.getRoleTextName(role);
			} else {
				// Will force user back to home page, since no Role was found...
				userRole = "";
			}

			try {
				switch (whatData) {
				case "EMNeedApproval":
					users = User.findUnapprovedEM();
					fileName = "em_need_approval";
					break;
				default:
					users = User.find.all();
					fileName = "all_users";
					break;
				}

				String fileDate = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
				fileName = fileLocation + fileName + "_" + fileDate + ".csv";
				CSVWriter usersWriter = new CSVWriter(new FileWriter(fileName));
				List<String[]> usersArr = new ArrayList<String[]>();
				usersArr.add(new String[] { "ID", "Email", "Role" });

				for (User user : users) {
					usersArr.add(new String[] { user.getFullname(), user.getEmail(),
							user.getRoleNameString(user.getRole().toString()) });
				}

				usersWriter.writeAll(usersArr);
				usersWriter.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return ok(exportready.render(fileName, userRole));
		}
	}

	public Result exportOpenFile(String fileName) {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			// Open the file that was exported...
			try {
				Desktop.getDesktop().open(new File(fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}

			RoleType role = AccessMiddleware.getSessionRole();
			if (role != null) {
				switch (role.toString()) {

				default:
					return GO_HOME;
				}
			} else {
				return GO_HOME;
			}
		}
	}

	public Result filterCardSearch(String type, String value) {
		List<Card> cardList = null;
		if (value.equals("All")) {
			cardList = Card.find.all();
		} else {
			// Decode the value, just in case...
			try {
				value = URLDecoder.decode(value, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			// Get type...
			switch (type) {
			case "team":
				cardList = Card.filterByTeam(value);
				break;

			case "position":
				cardList = Card.filterByPosition(value);
				break;

			default:
				break;
			}
		}
		// Grab the current user...
		String userkey = AccessMiddleware.getSessionUserKey();
		User user = User.findByUserKey(userkey);
		List<Lookup> lookups = Lookup.find.all();
		List<Team> teams = Team.find.all();
		return ok(searchcards.render(cardList, lookups, teams, user));
	}

	public Result filterLookups(String type, String value) {
		// Grab the current user's userkey and role...
		List<Lookup> lookupList = null;
		if (value.equals("All")) {
			lookupList = Lookup.find.all();
		} else {
			// Get type...
			switch (type) {
			case "type":
				lookupList = Lookup.filterByType(value);
				break;

			default:
				break;
			}
		}
		return ok(lookups.render(lookupList));
	}

	public Result findUser() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			return ok(getuser.render(form(FindUser.class)));
		}
	}

	public Result getAllUsers() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			List<User> users = User.find.all();
			return ok(searchusers.render(users));
		}
	}

	public Result getLookupByKey(String lookupkey) {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			List<Lookup> lookups = Lookup.find.all();
			Lookup lookup = Lookup.findByUniqueKey(lookupkey);
			return ok(editlookup.render(lookups, lookup));
		}
	}

	public Result getUserByEmail() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			// Find user and display...
			Form<FindUser> findUserForm = form(FindUser.class).bindFromRequest();
			if (findUserForm.hasErrors()) {
				Logger.debug("getUserByEmail - errors");
				return badRequest(getuser.render(findUserForm));
			} else {
				// Find user and display...
				Logger.debug("getUserByEmail - good request");
				String email = findUserForm.get().searchText;
				User user = User.findByEmail(email);
				List<Lookup> lookups = Lookup.find.all();
				return ok(showuser.render(lookups, user));
			}
		}
	}

	public Result getUserByEmailWildcard() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			// Find user and display...
			Form<FindUser> findUserForm = form(FindUser.class).bindFromRequest();
			if (findUserForm.hasErrors()) {
				Logger.debug("getUserByEmailWildcard - errors");
				Messages.get("search.user.bademail");
				return badRequest(getuser.render(findUserForm));
			} else {
				// Find user and display...
				Logger.debug("getUserByEmailWildcard - good request");
				String email = findUserForm.get().searchText;
				List<User> users = User.findUserWithWildcard(email);
				return ok(searchusers.render(users));
			}
		}
	}

	public boolean hasCorrectAccess(RoleType accessRole) {
		// Make sure user has correct role to access...
		// Pass in Role user should have use...
		// Compare with user's current role...

		// Is the user authenticated?
		boolean isAuth = AccessMiddleware.isAuthenticated();
		if (isAuth) {
			// Get the current role and compare...
			RoleType currentRole = AccessMiddleware.getSessionRole();
			if (currentRole == accessRole) {
				// Good to go...
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Display the login page or dashboard if connected
	 *
	 * @return login page or dashboard
	 */
	public Result index() {
		// Check that the email matches a confirmed user before we redirect
		String email = ctx().session().get("email");
		if (email != null) {
			User user = User.findByEmail(email);
			if (user != null && user.validated) {
				boolean isAuth = AccessMiddleware.isAuthenticated();
				if (isAuth) {
					RoleType role = AccessMiddleware.getSessionRole();
					if (role != null) {
						switch (role) {
						case USER:
							return GO_USER;

						case ADMIN:
							return GO_ADMIN;

						default:
							return GO_HOME;
						}
					} else {
						Logger.debug("Application.index() - No Role - Clearing invalid session credentials");
						session().clear();
						return GO_HOME;
					}
				} else {
					Logger.debug("Application.index() - No user authenticated - Clearing invalid session credentials");
					session().clear();
					return GO_HOME;
				}
			} else {
				Logger.debug("Application.index() - Clearing invalid session credentials");
				session().clear();
			}
		}

		return ok(index.render(form(Register.class), form(Login.class)));
		// return ok(index.render());
	}

	public Result initializeRecordUniqueKeys() {
		List<Lookup> lookups = Lookup.find.all();
		for (Lookup lookup : lookups) {
			lookup.datecreated = new Date();
			lookup.lookupkey = lookup.createUniqueKey();
			lookup.save();
		}

		List<Team> teams = Team.find.all();
		for (Team team : teams) {
			team.uniquekey = team.createUniqueKey();
			team.datecreated = new Date();
			team.save();
		}

		List<Card> cards = Card.find.all();
		for (Card card : cards) {
			card.uniquekey = card.createUniqueKey();
			card.datecreated = new Date();
			// Does the team exist?
			String teamName = card.team;
			if (!teamName.equals("")) {
				Team team = Team.findByTeamName(teamName);
				card.teamkey = team.uniquekey;
			}
			card.save();
		}

		/*
		 * List<User> users = User.find.all(); for (User user : users) {
		 * RoleType role = user.getRole(); String roleName =
		 * role.getRoleTextName(role); user.setRolename(roleName);
		 * user.setUserkey(user.createUserKey()); user.dateCreation = new
		 * Date(); user.save(); }
		 */

		return ok(genericsuccess.render());
	}

	public Result logout() {
		// Remove all session records...
		String email = session("email");
		User user = User.findByEmail(email);
		AccessMiddleware.removeSessionRecords(user);

		// Reset all globals...
		openCardKey = "";

		// Clear the session...
		session().clear();

		flash("success", Messages.get("youve.been.logged.out"));
		return GO_HOME;
	}

	public Result lookupMaintenance() {
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			List<Lookup> lookupList = Lookup.find.all();
			return ok(lookups.render(lookupList));
		}
	}

	public void notifyTeam(Card card, Comment comment, String emailType) throws MalformedURLException {
		// Set up globals...
		String subject = "";
		String message = "";
		String urlString = "";
		String commentAuthor = "";
		String commentDate = "";
		String commentText = "";
		List<String> emailArray = null;
		URL url = null;
		String testPrefix = "TEST - PLEASE DISREGARD...";
		String emailMode = Configuration.root().getString("application.emailmode");
		String emailState = Configuration.root().getString("application.emailstate");

		switch (emailType) {
		case "New":
			// Build the subject...
			subject = Messages.get("mail.newcard.subject", card.name);
			// Build the URL to send...
			urlString = "http://" + Configuration.root().getString("server.hostname") + "/opencard/" + card.uniquekey;
			// Validate the URL, will throw an exception if bad...
			url = new URL(urlString);
			message = Messages.get("mail.newcard.message", url.toString());
			break;

		case "Comment":
			// Build the subject...
			subject = Messages.get("mail.newcomment.subject", card.name);
			// Build the URL to send...
			urlString = "http://" + Configuration.root().getString("server.hostname") + "/opencard/" + card.uniquekey;
			// Validate the URL, will throw an exception if bad...
			url = new URL(urlString);
			// Let's add the comment to the message...
			commentAuthor = comment.author;
			commentDate = comment.datecreated.toString();
			commentText = comment.comment;
			message = Messages.get("mail.newcomment.message", commentAuthor, commentDate, commentText, url.toString());
			break;

		default:
			return;
		}

		// Build the Send To email addresses...
		emailArray = new ArrayList<String>();
		// emailArray.add(intake.bamanageremail);

		// Are we in test email mode?
		if (emailMode.equals("test")) {
			subject = testPrefix + " " + subject;
			message = testPrefix + "<br><br>" + message;
		}
		Mail.Envelop envelop = new Mail.Envelop(subject, message, emailArray);
		Mail mailer = new Mail(mailerClient);
		// Are we sending email?
		if (emailState.equals("on")) {
			mailer.sendMail(envelop);
		}
	}

	public Result openCard(String cardkey) {
		// Let's make sure they are authenticated since user can click link in
		// email...
		String email = session("email");
		if (email != null) {
			User user = User.findByEmail(email);
			if (user != null && user.validated) {
				boolean isAuth = AccessMiddleware.isAuthenticated();
				if (!isAuth) {
					// Need to login...
					openCardKey = cardkey;
					return ok(auth.render(form(Login.class)));
				}
			} else {
				// Need to login...
				openCardKey = cardkey;
				return ok(auth.render(form(Login.class)));
			}
		} else {
			// Need to login...
			openCardKey = cardkey;
			return ok(auth.render(form(Login.class)));
		}
		Form<CardAdd> cardEntry = form(CardAdd.class).bindFromRequest();		
		// Get correct record...
		Card card = Card.findByUniqueKey(cardkey);

		// Someone is editing the record...
		// Need to record current version of this record to compare on save...
		// This will record the Audit History...
		// Create new record in CardEdit table...
		CardEdit cardEdit = new CardEdit();
		cardEdit.name = card.name;
		cardEdit.team = card.team;
		cardEdit.position = card.position;
		cardEdit.cardmaker = card.cardmaker;
		cardEdit.year = card.year;

		// Create editkey...
		String editkey = cardEdit.createUniqueKey();
		cardEdit.editkey = editkey;
		card.editkey = editkey;

		// Save both records...
		card.save();
		cardEdit.save();

		String userkey = AccessMiddleware.getSessionUserKey();
		User user = User.findByUserKey(userkey);
		List<Lookup> lookups = Lookup.find.all();
		List<CardAudit> cardAudits = CardAudit.findByCardKey(cardkey);
		List<Comment> allComments = Comment.getAllByCardKey(cardkey);
		List<Team> teams = Team.find.all();
		return ok(editcard.render(cardEntry, card, teams, lookups, cardAudits, allComments, user));
	}

	public Result openLogin() {
		boolean isAuth = AccessMiddleware.isAuthenticated();
		if (isAuth) {
			RoleType role = AccessMiddleware.getSessionRole();
			if (role != null) {
				switch (role.toString()) {

				default:
					return GO_HOME;
				}
			} else {
				Logger.debug("Application.index() - No Role - Clearing invalid session credentials");
				session().clear();
				return ok(auth.render(form(Login.class)));
			}
		} else {
			Logger.debug("Application.index() - No user authenticated - Clearing invalid session credentials");
			session().clear();
			return ok(auth.render(form(Login.class)));
		}
	}

	public Result openLookup(String lookupkey) {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			List<Lookup> lookups = Lookup.find.all();
			Lookup lookup = Lookup.findByUniqueKey(lookupkey);
			return ok(editlookup.render(lookups, lookup));
		}
	}

	public Result openUser() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			return ok(openuser.render());
		}
	}

	public Result openUserAccount(String email) {
		Form<FindUser> findUserForm = form(FindUser.class).bindFromRequest();
		User user = User.findByEmail(email);
		String name = user.fullname;

		if (findUserForm.hasErrors()) {
			Logger.debug("Open User Account - errors");
			return badRequest(useraccount.render(findUserForm, email, name));
		} else {
			// Find user and display...
			Logger.debug("Open User Account - good request");
			return ok(useraccount.render(findUserForm, email, name));
		}
	}

	public Result saveCard() {
		Form<CardAdd> cardEntry = form(CardAdd.class).bindFromRequest();

		if (cardEntry.hasErrors()) {
			List<Lookup> lookups = Lookup.find.all();
			List<Team> teams = Team.find.all();
			return badRequest(card.render(cardEntry, teams, lookups));
		}
		// Save the card...
		User user = null;
		CardAdd cardForm = cardEntry.get();
		Logger.debug("Save Card - good request");
		Card card = new Card();
		card.name = cardForm.name;
		card.position = cardForm.position;
		card.team = cardForm.team;
		// Let's also get the teamkey...
		Team team = Team.findByTeamName(cardForm.team);
		card.teamkey = team.uniquekey;
		card.cardmaker = cardForm.cardmaker;
		card.year = cardForm.year;
		card.datecreated = new Date();
		card.uniquekey = card.createUniqueKey();
		card.userkey = AccessMiddleware.getSessionUserKey();
		card.save();

		// Add initial comment...
		String userkey = AccessMiddleware.getSessionUserKey();
		user = User.findByUserKey(userkey);

		// Let's create a Comment record...
		Comment comment = new Comment();
		comment.cardkey = card.uniquekey;
		comment.comment = Messages.get("card.new.comment");
		comment.uniquekey = comment.createUniqueKey();
		comment.datecreated = new Date();
		if (user != null) {
			comment.author = user.fullname;
			comment.authoremail = user.getEmail();
			comment.userkey = userkey;
		}
		comment.save();

		AuditLog.setLog(AccessMiddleware.getSessionID(), AccessMiddleware.getSessionEmail(), "Card", "saveCard()",
				"New Card created and saved", AccessMiddleware.getSessionID());

		// Notify team they have been assigned...
		try {
			notifyTeam(card, null, "New");
		} catch (MalformedURLException m) {
			m.printStackTrace();
		}

		return ok(cardcreated.render());
	}

	public Result saveLookup() {
		Form<LookupAdd> lookupEntry = form(LookupAdd.class).bindFromRequest();

		if (lookupEntry.hasErrors()) {
			List<Lookup> lookups = Lookup.find.all();
			Logger.debug("Save Lookup - errors");
			return badRequest(lookup.render(lookups));
		}
		// Save the lookup...
		User user = null;
		LookupAdd lookupForm = lookupEntry.get();
		Logger.debug("Save Lookup - good request");
		Lookup lookup = new Lookup();
		lookup.lookupkey = lookup.createUniqueKey();
		lookup.lookuptype = lookupForm.lookuptype;
		lookup.name = lookupForm.name;
		lookup.description = lookupForm.description;
		lookup.datecreated = new Date();
		lookup.userkey = AccessMiddleware.getSessionUserKey();
		lookup.save();

		AuditLog.setLog(AccessMiddleware.getSessionID(), AccessMiddleware.getSessionEmail(), "Lookup", "saveLookup()",
				"New Lookup created and saved", AccessMiddleware.getSessionID());

		return ok(lookupcreated.render());
	}

	public Result searchAllCards(String searchText) {
		// Check the role and determine what to return...
		String userkey = AccessMiddleware.getSessionUserKey();
		if (userkey == null) {
			return ACCESS_DENIED;
		}
		RoleType role = AccessMiddleware.getSessionRole();
		if (role == null) {
			return ACCESS_DENIED;
		}
		User user = User.findByUserKey(userkey);
		List<Lookup> lookups = Lookup.find.all();
		List<Team> teams = Team.find.all();
		List<Card> cardList = Card.searchAllCards(searchText);
		return ok(searchcards.render(cardList, lookups, teams, user));
	}

	public Result searchCards() {
		// Get the current user...
		String userkey = AccessMiddleware.getSessionUserKey();
		User user = User.findByUserKey(userkey);
		List<Lookup> lookups = Lookup.find.all();
		List<Team> teams = Team.find.all();
		List<Card> cardList = Card.find.all();
		return ok(searchcards.render(cardList, lookups, teams, user));
	}

	public Result updateCard(String cardkey) {
		Form<CardAdd> cardEntry = form(CardAdd.class).bindFromRequest();
		// Get correct card...
		Card card = Card.findByUniqueKey(cardkey);
		// Get the current user...
		String userkey = AccessMiddleware.getSessionUserKey();
		User user = User.findByUserKey(userkey);
		if (cardEntry.hasErrors()) {
			Logger.debug("Update Card - errors");
			List<Lookup> lookups = Lookup.find.all();
			List<CardAudit> cardAudits = CardAudit.findByCardKey(cardkey);
			List<Comment> allComments = Comment.getAllByCardKey(cardkey);
			List<Team> teams = Team.find.all();
			return badRequest(editcard.render(cardEntry, card, teams, lookups, cardAudits, allComments, user));
		}
		CardAdd cardForm = cardEntry.get();
		Logger.debug("Update Card - good request");
		card.name = cardForm.name;
		card.team = cardForm.team;
		// Let's also get the teamkey...
		Team team = Team.findByTeamName(cardForm.team);
		card.teamkey = team.uniquekey;
		card.position = cardForm.position;
		card.cardmaker = cardForm.cardmaker;
		card.year = cardForm.year;
		card.userkey = AccessMiddleware.getSessionUserKey();
		card.updatedby = AccessMiddleware.getSessionEmail();
		card.dateupdated = new Date();
		card.save();

		// Let's check the CardEdit record and see what is different...
		String editkey = card.editkey;
		CardEdit cardEdit = CardEdit.findByEditKey(editkey);
		if (cardEdit != null) {
			// Compare the 2 records...
			String fieldSplit = "";
			String[] splitValues = null;
			String fieldName = "";
			String fieldDisplay = "";
			String oldValue = "";
			String newValue = "";
			Field field = null;
			Object fieldObject = null;
			CardAudit cardAudit = null;
			String[] fieldArray = cardFieldControl();
			// Cycle through fieldArray...
			for (int x = 0; x < fieldArray.length; x++) {
				fieldSplit = fieldArray[x];
				splitValues = fieldSplit.split(delimiter);
				fieldName = splitValues[0];
				fieldDisplay = splitValues[1];
				try {
					// Get old value...
					field = cardEdit.getClass().getField(fieldName);
					fieldObject = field.get(cardEdit);
					if (fieldObject != null) {
						oldValue = fieldObject.toString();
					} else {
						oldValue = "";
					}
					// Get new value...
					field = card.getClass().getField(fieldName);
					fieldObject = field.get(card);
					if (fieldObject != null) {
						newValue = fieldObject.toString();
					} else {
						newValue = "";
					}
					if (!oldValue.equals(newValue)) {
						// Different values, create Audit record...
						cardAudit = new CardAudit();
						cardAudit.fieldname = fieldName;
						cardAudit.fielddisplay = fieldDisplay;
						cardAudit.oldvalue = oldValue;
						cardAudit.newvalue = newValue;
						cardAudit.editor = AccessMiddleware.getSessionID();
						cardAudit.editoremail = AccessMiddleware.getSessionEmail();
						cardAudit.editorkey = AccessMiddleware.getSessionUserKey();
						cardAudit.cardkey = card.uniquekey;
						cardAudit.auditkey = cardAudit.createUniqueKey();
						cardAudit.editdate = new Date();
						cardAudit.save();
					}
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} // Remove the CardEdit record...
			cardEdit.delete();
		}
		AuditLog.setLog(AccessMiddleware.getSessionID(), AccessMiddleware.getSessionEmail(), "Card", "updateCard()",
				"Card updated and saved", AccessMiddleware.getSessionID());
		return ok(cardupdated.render());
	}

	public Result updateLookup(String lookupkey) {
		Form<LookupAdd> lookupEntry = form(LookupAdd.class).bindFromRequest();

		if (lookupEntry.hasErrors()) {
			List<Lookup> lookups = Lookup.find.all();
			Logger.debug("Save Lookup - errors");
			return badRequest(lookup.render(lookups));
		}
		// Save the lookup...
		User user = null;
		LookupAdd lookupForm = lookupEntry.get();
		Logger.debug("Save Lookup - good request");
		Lookup lookup = Lookup.findByUniqueKey(lookupkey);
		lookup.lookuptype = lookupForm.lookuptype;
		lookup.name = lookupForm.name;
		lookup.description = lookupForm.description;
		lookup.datecreated = new Date();
		lookup.updatedby = AccessMiddleware.getSessionEmail();
		lookup.dateupdated = new Date();
		lookup.userkey = AccessMiddleware.getSessionUserKey();
		lookup.save();

		AuditLog.setLog(AccessMiddleware.getSessionID(), AccessMiddleware.getSessionEmail(), "Lookup", "saveLookup()",
				"New Lookup created and saved", AccessMiddleware.getSessionID());

		return ok(lookupupdated.render());
	}

	public Result updateUser() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			String email;
			String name;
			String rolename;
			User user;

			Form<RegisterUser> findUserForm = form(RegisterUser.class).bindFromRequest();

			// Get values from the form...
			email = findUserForm.get().email;
			name = findUserForm.get().fullname;
			rolename = findUserForm.get().rolename;

			user = User.findByEmail(email);
			List<Lookup> lookups = Lookup.find.all();

			Logger.debug("Update User");

			if (findUserForm.hasErrors()) {
				Logger.debug("Update User - errors");
				return badRequest(showuser.render(lookups, user));
			}

			// Find user and save changes...
			Logger.debug("Update User - good request");

			// I know we have the user, but let's make sure we get the correct
			// user...
			user.fullname = name;
			user.rolename = rolename;
			switch (rolename) {
			case "Admin":
				user.role = RoleType.ADMIN;
				break;
			default:
				user.role = RoleType.UNDEFINED;
				break;
			}

			// Save the user...
			user.updatedBy = AccessMiddleware.getSessionEmail();
			user.dateUpdated = new Date();
			user.save();

			return ok(saveduser.render());
		}
	}

	public Result updateUserAccount() {
		String email;
		String name;
		String approved;
		String role;
		User user;

		Form<FindUser> findUserForm = form(FindUser.class).bindFromRequest();

		// Get values from the form...
		email = findUserForm.get().email;
		name = findUserForm.get().fullname;
		Logger.debug("Updating User Account");

		if (findUserForm.hasErrors()) {
			Logger.debug("Update User Account - errors");
			return badRequest(useraccount.render(findUserForm, "", ""));
		}

		// Find user and save changes...
		Logger.debug("Update User Account - good request");

		// I know we have the user, but let's make sure we get the correct
		// user...
		user = User.findByEmail(email);
		user.fullname = name;

		// Save the user...
		user.updatedBy = AccessMiddleware.getSessionEmail();
		user.dateUpdated = new Date();
		user.save();

		AuditLog.setLog(AccessMiddleware.getSessionID(), AccessMiddleware.getSessionEmail(), "User Account",
				"updateUserAccount()", "User account updated", AccessMiddleware.getSessionID());

		return ok(saveduser.render());
	}

	public Result userHome() {
		boolean isAuth = AccessMiddleware.isAuthenticated();
		if (isAuth) {
			RoleType role = AccessMiddleware.getSessionRole();
			if (role != null) {
				return ok(home.render());
			}
		}
		return GO_HOME;
	}

	public Result userMaintenance() {
		// Check Role...
		if (hasCorrectAccess(RoleType.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			return ok(usermaint.render(form(Login.class)));
		}
	}

	public static String[] cardFieldControl() {

		String[] fieldArray = new String[5];

		fieldArray[0] = "name" + delimiter + "Player Name";
		fieldArray[1] = "position" + delimiter + "Position";
		fieldArray[2] = "team" + delimiter + "Team";
		fieldArray[3] = "cardmaker" + delimiter + "Card Maker";
		fieldArray[4] = "year" + delimiter + "Year";

		return fieldArray;
	}

	public Result reportsCreate(String reportType) {
		/*
		 * List<String> nameList = null; List<Integer> totalList = null;
		 * RoleType role = null; String jsonStart = ""; String jsonColumns = "";
		 * String jsonRowStart = "'rows': ["; String jsonRowEntry = ""; String
		 * jsonRowEntry1 = ""; String jsonRowEntry2 = ""; String jsonEnd = "]}";
		 * String jsonString = ""; String jsonString1 = ""; String jsonString2 =
		 * ""; String nameValue = ""; String title = ""; String title1 = "";
		 * String title2 = ""; Integer total = 0;
		 * 
		 * switch (reportType) { case "Agencies": // Grab all intake by
		 * Agency... jsonColumns =
		 * "{'cols': [{'id': 'agency', 'label': 'Agency', 'type': 'string'},{'id': 'totals', 'label': 'Agency Totals', 'type': 'number'}],"
		 * ; title = "Projects By Agency"; nameList = Intake.getAgencyNames();
		 * nameList = removeDuplicates(nameList); for (int x = 0; x <
		 * nameList.size(); x++) { // Get the agency name and total... nameValue
		 * = nameList.get(x); total = Intake.getAgencyTotal(nameValue); if
		 * (jsonRowEntry.equals("")) { jsonRowEntry = "{'c':[{'v': '" +
		 * nameValue + "'}, {'v': " + total + "}]}"; } else { jsonRowEntry =
		 * jsonRowEntry + ",{'c':[{'v': '" + nameValue + "'}, {'v': " + total +
		 * "}]}"; } } break;
		 * 
		 * case "BySE": // Grab all intake by SE... jsonColumns =
		 * "{'cols': [{'id': 'se', 'label': 'SE', 'type': 'string'},{'id': 'totals', 'label': 'SE Totals', 'type': 'number'}],"
		 * ; title = "Projects By SE"; nameList = Intake.getSENames(); nameList
		 * = removeDuplicates(nameList); for (int x = 0; x < nameList.size();
		 * x++) { // Get the agency name and total... nameValue =
		 * nameList.get(x); total = Intake.getSETotal(nameValue); if
		 * (jsonRowEntry.equals("")) { jsonRowEntry = "{'c':[{'v': '" +
		 * nameValue + "'}, {'v': " + total + "}]}"; } else { jsonRowEntry =
		 * jsonRowEntry + ",{'c':[{'v': '" + nameValue + "'}, {'v': " + total +
		 * "}]}"; } } break;
		 * 
		 * case "All": // Grab all intake by Agency... jsonColumns =
		 * "{'cols': [{'id': 'agency', 'label': 'Agency', 'type': 'string'},{'id': 'totals', 'label': 'Agency Totals', 'type': 'number'}],"
		 * ; title1 = "Projects By Agency"; nameList = Intake.getAgencyNames();
		 * nameList = removeDuplicates(nameList); for (int x = 0; x <
		 * nameList.size(); x++) { // Get the agency name and total... nameValue
		 * = nameList.get(x); total = Intake.getAgencyTotal(nameValue); if
		 * (jsonRowEntry1.equals("")) { jsonRowEntry1 = "{'c':[{'v': '" +
		 * nameValue + "'}, {'v': " + total + "}]}"; } else { jsonRowEntry1 =
		 * jsonRowEntry1 + ",{'c':[{'v': '" + nameValue + "'}, {'v': " + total +
		 * "}]}"; } } jsonString1 = jsonColumns + jsonRowStart + jsonRowEntry1 +
		 * jsonEnd;
		 * 
		 * // Grab all intake by SE... jsonColumns =
		 * "{'cols': [{'id': 'se', 'label': 'SE', 'type': 'string'},{'id': 'totals', 'label': 'SE Totals', 'type': 'number'}],"
		 * ; title2 = "Projects By SE"; nameList = Intake.getSENames(); nameList
		 * = removeDuplicates(nameList); for (int x = 0; x < nameList.size();
		 * x++) { // Get the agency name and total... nameValue =
		 * nameList.get(x); total = Intake.getSETotal(nameValue); if
		 * (jsonRowEntry2.equals("")) { jsonRowEntry2 = "{'c':[{'v': '" +
		 * nameValue + "'}, {'v': " + total + "}]}"; } else { jsonRowEntry2 =
		 * jsonRowEntry2 + ",{'c':[{'v': '" + nameValue + "'}, {'v': " + total +
		 * "}]}"; } } jsonString2 = jsonColumns + jsonRowStart + jsonRowEntry2 +
		 * jsonEnd;
		 * 
		 * break;
		 * 
		 * case "DueThisWeekMonth": // Grab all intake by Agency... jsonColumns
		 * =
		 * "{'cols': [{'id': 'agency', 'label': 'Agency', 'type': 'string'},{'id': 'totals', 'label': 'Agency Totals', 'type': 'number'}],"
		 * ; title1 = "Projects By Agency"; nameList = Intake.getAgencyNames();
		 * nameList = removeDuplicates(nameList); for (int x = 0; x <
		 * nameList.size(); x++) { // Get the agency name and total... nameValue
		 * = nameList.get(x); total = Intake.getAgencyTotal(nameValue); if
		 * (jsonRowEntry1.equals("")) { jsonRowEntry1 = "{'c':[{'v': '" +
		 * nameValue + "'}, {'v': " + total + "}]}"; } else { jsonRowEntry1 =
		 * jsonRowEntry1 + ",{'c':[{'v': '" + nameValue + "'}, {'v': " + total +
		 * "}]}"; } } jsonString1 = jsonColumns + jsonRowStart + jsonRowEntry1 +
		 * jsonEnd;
		 * 
		 * // Grab all intake by SE... jsonColumns =
		 * "{'cols': [{'id': 'se', 'label': 'SE', 'type': 'string'},{'id': 'totals', 'label': 'SE Totals', 'type': 'number'}],"
		 * ; title2 = "Projects By SE"; nameList = Intake.getSENames(); nameList
		 * = removeDuplicates(nameList); for (int x = 0; x < nameList.size();
		 * x++) { // Get the agency name and total... nameValue =
		 * nameList.get(x); total = Intake.getSETotal(nameValue); if
		 * (jsonRowEntry2.equals("")) { jsonRowEntry2 = "{'c':[{'v': '" +
		 * nameValue + "'}, {'v': " + total + "}]}"; } else { jsonRowEntry2 =
		 * jsonRowEntry2 + ",{'c':[{'v': '" + nameValue + "'}, {'v': " + total +
		 * "}]}"; } } jsonString2 = jsonColumns + jsonRowStart + jsonRowEntry2 +
		 * jsonEnd;
		 * 
		 * break;
		 * 
		 * case "SETime": // Grab all the SEs based on Role from the User
		 * model... role = RoleType.SE; nameList = User.getNamesByRole(role);
		 * jsonColumns =
		 * "{'cols': [{'id': 'se', 'label': 'SE', 'type': 'string'},{'id': 'utilization', 'label': 'Utilization', 'type': 'number'}],"
		 * ; title = "SE Utilization"; for (int x = 0; x < nameList.size(); x++)
		 * { // Get the SE Name and total... nameValue = nameList.get(x); total
		 * = Intake.getSEUtilization(nameValue); if (jsonRowEntry.equals("")) {
		 * jsonRowEntry = "{'c':[{'v': '" + nameValue + "'}, {'v': " + total +
		 * "}]}"; } else { jsonRowEntry = jsonRowEntry + ",{'c':[{'v': '" +
		 * nameValue + "'}, {'v': " + total + "}]}"; } } jsonString =
		 * jsonColumns + jsonRowStart + jsonRowEntry + jsonEnd; return
		 * ok(chartsbar.render(jsonString, title));
		 * 
		 * case "BATime": // Grab all the BAs based on Role from the User
		 * model... role = RoleType.BA; nameList = User.getNamesByRole(role);
		 * jsonColumns =
		 * "{'cols': [{'id': 'ba', 'label': 'BA', 'type': 'string'},{'id': 'utilization', 'label': 'Utilization', 'type': 'number'}],"
		 * ; title = "BA Utilization"; for (int x = 0; x < nameList.size(); x++)
		 * { // Get the SE Name and total... nameValue = nameList.get(x); total
		 * = Intake.getBAUtilization(nameValue); if (jsonRowEntry.equals("")) {
		 * jsonRowEntry = "{'c':[{'v': '" + nameValue + "'}, {'v': " + total +
		 * "}]}"; } else { jsonRowEntry = jsonRowEntry + ",{'c':[{'v': '" +
		 * nameValue + "'}, {'v': " + total + "}]}"; } } jsonString =
		 * jsonColumns + jsonRowStart + jsonRowEntry + jsonEnd; return
		 * ok(chartsbar.render(jsonString, title));
		 * 
		 * default: return GO_HOME; }
		 * 
		 * // jsonString = "{cols: [{id: 'task', label: 'Task', type: 'string'},
		 * // {id: 'hours', label: 'Hours per Day', type: 'number'}],rows:
		 * [{c:[{v: // 'Work'}, {v: 11}]}, {c:[{v: 'Eat'}, {v: 2}]}, {c:[{v:
		 * 'Commute'}, {v: // 2}]}, {c:[{v: 'Watch TV'}, {v:2}]}, {c:[{v:
		 * 'Sleep'}, {v:7, // f:'7.000'}]}]}";
		 * 
		 * // jsonString = "{'cols': [{'id': 'task', 'label': 'Task', 'type': //
		 * 'string'}, {'id': 'hours', 'label': 'Hours per Day', 'type': //
		 * 'number'}],'rows': [{'c':[{'v': 'Work'}, {'v': 11}]}, {'c':[{'v': //
		 * 'Eat'}, {'v': 2}]}, {'c':[{'v': 'Commute'}, {'v': 2}]}, {'c':[{'v':
		 * // 'Watch TV'}, {'v':2}]}, {'c':[{'v': 'Sleep'}, {'v':7, //
		 * 'f':'7.000'}]}]}";
		 * 
		 * if (reportType.equals("All")) { return ok(charts2.render(jsonString1,
		 * jsonString2, title1, title2)); } else { jsonString = jsonColumns +
		 * jsonRowStart + jsonRowEntry + jsonEnd; return
		 * ok(charts1.render(jsonString, title)); }
		 */
		return GO_HOME;
	}

	public static List<String> removeDuplicates(List<String> currentArray) {
		List<String> newList = new ArrayList<>();
		for (String name : currentArray) {
			if (!newList.contains(name)) {
				newList.add(name);
			}
		}
		return newList;
	}

}