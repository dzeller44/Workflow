package controllers.account;

import controllers.Application;
import models.Lookup;
import models.Token;
import models.User;
import models.enums.RoleType;
import models.utils.AppException;
import models.utils.Hash;
import models.utils.Mail;
import org.apache.commons.mail.EmailException;
import play.Configuration;
import play.Logger;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;

import javax.inject.Inject;

import views.html.account.signup.confirm;
import views.html.account.signup.create;
import views.html.account.signup.created;
import views.html.account.signup.approval;
import views.html.admin.createuser;
import views.html.admin.createduser;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static play.data.Form.form;

/**
 * Signup to PlayStartApp : save and send confirm mail.
 * <p/>
 * User: yesnault Date: 31/01/12
 */
public class Signup extends Controller {
	@Inject
	MailerClient mailerClient;

	/**
	 * Display the create form.
	 *
	 * @return create form
	 */
	public Result create() {
		List<Lookup> lookups = Lookup.find.all();
		return ok(create.render(form(Application.Register.class), lookups));
	}

	/**
	 * Display the create admin form.
	 *
	 * @return create admin form
	 */
	public Result createUser() {
		List<Lookup> lookups = Lookup.find.all();
		return ok(createuser.render(form(Application.RegisterUser.class), lookups));
	}

	/**
	 * Display the create form only (for the index page).
	 *
	 * @return create form
	 */
	public Result createFormOnly() {
		List<Lookup> lookups = Lookup.find.all();
		return ok(create.render(form(Application.Register.class), lookups));
		// return ok(create.render());
	}

	/**
	 * Save the new user.
	 *
	 * @return Successfull page or created form if bad
	 */
	public Result save() {
		Form<Application.Register> registerForm = form(Application.Register.class).bindFromRequest();
		List<Lookup> lookups = Lookup.find.all();
		if (registerForm.hasErrors()) {			
			return badRequest(create.render(registerForm, lookups));
			// return badRequest(create.render());
		}

		Application.Register register = registerForm.get();
		Result resultError = checkBeforeSave(registerForm, register.email);

		if (resultError != null) {
			return resultError;
		}

		try {
			User user = new User();
			user.setEmail(register.email);
			user.fullname = register.fullname;
			user.passwordHash = Hash.createPassword(register.inputPassword);
			user.confirmationToken = UUID.randomUUID().toString();
			user.userkey = user.createUserKey();
			user.dateCreation = new Date();
			user.active = "Y";
			// Custom fields...
			String role = register.role;
			switch (role) {
			case "User":
				user.role = RoleType.USER;
				break;
			case "Admin":
				user.role = RoleType.ADMIN;
				break;
			default:
				user.role = RoleType.UNDEFINED;
				break;
			}
			// Create reminder dates...
			// Update account...
			Calendar cal = null;
			Date result = null;
			cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 6);
			result = cal.getTime();
			// DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			// String dateOnly = dateFormat.format(result);
			user.dateRemind = result;
			// Password...
			cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 3);
			result = cal.getTime();
			user.datePasswordRemind = result;
			user.save();
			sendMailAskForConfirmation(user);
			return ok(created.render());

		} catch (EmailException e) {
			Logger.debug("Signup.save Cannot send email", e);
			flash("error", Messages.get("error.sending.email"));
		} catch (Exception e) {
			Logger.error("Signup.save error", e);
			flash("error", Messages.get("error.technical"));
		}
		return badRequest(create.render(registerForm, lookups));
		// return badRequest(create.render());
	}

	public Result saveUser() throws EmailException {
		Form<Application.RegisterUser> registerUserForm = form(Application.RegisterUser.class).bindFromRequest();
		List<Lookup> lookups = Lookup.find.all();
		if (registerUserForm.hasErrors()) {
			return badRequest(createuser.render(registerUserForm, lookups));
		}

		Application.RegisterUser newUser = registerUserForm.get();
		Result resultError = checkUserBeforeSave(registerUserForm, newUser.email);
		if (resultError != null) {
			return resultError;
		}

		try {
			User user = new User();
			user.setEmail(newUser.email);
			user.fullname = newUser.fullname;
			String checkPassword = Messages.get("admin.default.password");
			user.passwordHash = Hash.createPassword(checkPassword);
			user.userkey = user.createUserKey();
			user.dateCreation = new Date();
			user.active = "Y";
			user.rolename = newUser.rolename;
			// Set the role...
			switch (user.rolename) {
			case "User":
				user.role = RoleType.USER;
				break;
			case "Admin":
				user.role = RoleType.ADMIN;
				break;
			default:
				user.role = RoleType.UNDEFINED;
				break;
			}
			// Create reminder dates...
			// Update account...
			Calendar cal = null;
			Date result = null;
			cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 6);
			result = cal.getTime();
			// DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			// String dateOnly = dateFormat.format(result);
			user.dateRemind = result;
			// Password...
			cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 3);
			result = cal.getTime();
			user.datePasswordRemind = result;
			user.save();

			// Send reset password email?
			Token t = new Token();
			t.sendNewUserMail(user, mailerClient);
			return ok(createduser.render());

		} catch (Exception e) {
			Logger.error("Signup.saveUser error", e);
			flash("error", Messages.get("error.technical"));
		}
		return badRequest(createuser.render(registerUserForm, lookups));
	}

	/**
	 * Check if the email already exists.
	 *
	 * @param registerForm
	 *            User Form submitted
	 * @param email
	 *            email address
	 * @return Index if there was a problem, null otherwise
	 */
	private Result checkBeforeSave(Form<Application.Register> registerForm, String email) {
		// Check unique email
		if (User.findByEmail(email) != null) {
			flash("error", Messages.get("error.email.already.exist"));
			List<Lookup> lookups = Lookup.find.all();
			return badRequest(create.render(registerForm, lookups));
		}
		return null;
	}

	/**
	 * Check if the email already exists.
	 *
	 * @param registerForm
	 *            User Form submitted
	 * @param email
	 *            email address
	 * @return Index if there was a problem, null otherwise
	 */
	private Result checkUserBeforeSave(Form<Application.RegisterUser> registerForm, String email) {
		// Check unique email...
		List<Lookup> lookups = Lookup.find.all();
		if (User.findByEmail(email) != null) {
			flash("error", Messages.get("error.email.already.exist"));
			return badRequest(createuser.render(registerForm, lookups));
		}
		return null;
	}

	/**
	 * Send the welcome Email with the link to confirm.
	 *
	 * @param user
	 *            user created
	 * @throws EmailException
	 *             Exception when sending mail
	 */
	private void sendMailAskForConfirmation(User user) throws EmailException, MalformedURLException {
		String subject = Messages.get("mail.confirm.subject");

		String urlString = "http://" + Configuration.root().getString("server.hostname");
		urlString += "/confirm/" + user.confirmationToken;
		URL url = new URL(urlString); // validate the URL, will throw an
										// exception if bad.
		String message = Messages.get("mail.confirm.message", url.toString());

		Mail.Envelop envelop = new Mail.Envelop(subject, message, user.getEmail());
		Mail mailer = new Mail(mailerClient);
		mailer.sendMail(envelop);
	}

	private void sendMailAdminConfirm(String admin, String email) throws EmailException, MalformedURLException {
		String subject = Messages.get("mail.admin.subject");

		String urlString = "http://" + Configuration.root().getString("server.hostname");
		urlString += "/finduserurl?email=" + email;
		URL url = new URL(urlString); // validate the URL, will throw an
										// exception if bad.
		String message = Messages.get("mail.admin.message", url.toString());

		Mail.Envelop envelop = new Mail.Envelop(subject, message, admin);
		Mail mailer = new Mail(mailerClient);
		mailer.sendMail(envelop);
	}

	/**
	 * Valid an account with the url in the confirm mail.
	 *
	 * @param token
	 *            a token attached to the user we're confirming.
	 * @return Confirmationpage
	 */
	public Result confirm(String token) {
		User user = User.findByConfirmationToken(token);
		if (user == null) {
			flash("error", Messages.get("error.unknown.email"));
			return badRequest(confirm.render());
		}

		if (user.validated) {
			flash("error", Messages.get("error.account.already.validated"));
			return badRequest(confirm.render());
		}

		try {
			if (User.confirm(user)) {
				sendMailConfirmation(user);
				flash("success", Messages.get("account.successfully.validated"));
				return ok(confirm.render());
			} else {
				Logger.debug("Signup.confirm cannot confirm user");
				flash("error", Messages.get("error.confirm"));
				return badRequest(confirm.render());
			}
		} catch (AppException e) {
			Logger.error("Cannot signup", e);
			flash("error", Messages.get("error.technical"));
		} catch (EmailException e) {
			Logger.debug("Cannot send email", e);
			flash("error", Messages.get("error.sending.confirm.email"));
		}
		return badRequest(confirm.render());
	}

	/**
	 * Send the confirm mail.
	 *
	 * @param user
	 *            user created
	 * @throws EmailException
	 *             Exception when sending mail
	 */
	private void sendMailConfirmation(User user) throws EmailException {
		String subject = Messages.get("mail.welcome.subject");
		String message = Messages.get("mail.welcome.message");
		Mail.Envelop envelop = new Mail.Envelop(subject, message, user.getEmail());
		Mail mailer = new Mail(mailerClient);
		mailer.sendMail(envelop);
	}
}
