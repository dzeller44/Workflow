package controllers.account;

import models.Token;
import models.User;
import models.utils.AppException;
import models.utils.Mail;
import org.apache.commons.mail.EmailException;
import play.Logger;
import play.data.Form;
import play.data.validation.Constraints;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.account.reset.ask;
import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;
import javax.inject.Inject;
import views.html.account.reset.reset;
import views.html.account.reset.runAsk;
import views.html.account.reset.success;
import java.net.MalformedURLException;

import static play.data.Form.form;

/**
 * Token password : - ask for an email address. - send a link pointing them to a
 * reset page. - show the reset page and set them reset it.
 * <p/>
 * <p/>
 * User: yesnault Date: 20/01/12
 */
public class Reset extends Controller {
	@Inject
	MailerClient mailerClient;

	public static class AskForm {
		@Constraints.Required
		public String email;
	}

	public static class ResetForm {
		@Constraints.Required
		public String password;
		
		/**
		 * Validate the reset.
		 * @return null if validation ok, string with details otherwise
		 * Added by DZ 10/27/2016
		 */
		public String validate() {
			if (isBlank(password)) {
				return "Password is required";
			}
			else {
				// Need to make sure we have:
				// 8 characters; 1 Uppercase character; 1 Lowercase character; 1 Number; 1 Special Character
				String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$!%^&+=])(?=\\S+$).{8,}";
				if(!password.matches(passwordPattern)) {
					return Messages.get("password.message");
				}
			}
			
			return null;
		}

		private boolean isBlank(String input) {
			return input == null || input.isEmpty() || input.trim().isEmpty();
		}
		
	}

	/**
	 * Display the reset password form.
	 *
	 * @return reset password form
	 */
	public Result ask() {
		Form<AskForm> askForm = form(AskForm.class);
		return ok(ask.render(askForm));
	}

	/**
	 * Run ask password.
	 *
	 * @return reset password form if error, runAsk render otherwise
	 */
	public Result runAsk() {
		Form<AskForm> askForm = form(AskForm.class).bindFromRequest();

		if (askForm.hasErrors()) {
			flash("error", Messages.get("signup.valid.email"));
			return badRequest(ask.render(askForm));
		}

		final String email = askForm.get().email;
		Logger.debug("runAsk: email = " + email);
		User user = User.findByEmail(email);
		Logger.debug("runAsk: user = " + user);

		// If we do not have this email address in the list, we should not
		// expose this to the user.
		// This exposes that the user has an account, allowing a user
		// enumeration attack.
		// See
		// http://www.troyhunt.com/2012/05/everything-you-ever-wanted-to-know.html
		// for details.
		// Instead, email the person saying that the reset failed.
		if (user == null) {
			Logger.debug("No user found with email " + email);
			sendFailedPasswordResetAttempt(email);
			return ok(runAsk.render());
		}

		Logger.debug("Sending password reset link to user " + user);

		try {
			Token t = new Token();
			t.sendMailResetPassword(user, mailerClient);
			return ok(runAsk.render());
		} catch (MalformedURLException e) {
			Logger.error("Cannot validate URL", e);
			flash("error", Messages.get("error.technical"));
		}
		return badRequest(ask.render(askForm));
	}

	/**
	 * Sends an email to say that the password reset was to an invalid email.
	 *
	 * @param email
	 *            the email address to send to.
	 */
	private void sendFailedPasswordResetAttempt(String email) {
		String subject = Messages.get("mail.reset.fail.subject");
		String message = Messages.get("mail.reset.fail.message", email);

		Mail.Envelop envelop = new Mail.Envelop(subject, message, email);
		Mail mailer = new Mail(mailerClient);
		mailer.sendMail(envelop);

	}

	public Result reset(String token) {

		if (token == null) {
			flash("error", Messages.get("error.technical"));
			Form<AskForm> askForm = form(AskForm.class);
			return badRequest(ask.render(askForm));
		}

		Token resetToken = Token.findByTokenAndType(token, Token.TypeToken.password);
		if (resetToken == null) {
			flash("error", Messages.get("error.technical"));
			Form<AskForm> askForm = form(AskForm.class);
			return badRequest(ask.render(askForm));
		}

		if (resetToken.isExpired()) {
			resetToken.delete();
			flash("error", Messages.get("error.expiredresetlink"));
			Form<AskForm> askForm = form(AskForm.class);
			return badRequest(ask.render(askForm));
		}

		Form<ResetForm> resetForm = form(ResetForm.class);
		return ok(reset.render(resetForm, token));
	}
	
	public Result resetAdmin(String token) {
		
		Form<ResetForm> resetForm = form(ResetForm.class);

		if (token == null) {
			flash("error", Messages.get("error.technical"));			
			return badRequest(reset.render(resetForm, token));
		}

		Token resetToken = Token.findByTokenAndType(token, Token.TypeToken.admin);
		if (resetToken == null) {
			flash("error", Messages.get("error.technical"));
			return badRequest(reset.render(resetForm, token));
		}

		if (resetToken.isExpired()) {
			resetToken.delete();
			flash("error", Messages.get("error.expiredresetlink"));
			return badRequest(reset.render(resetForm, token));
		}

		return ok(reset.render(resetForm, token));
	}
	
	public Result resetUser(String token) {
		
		Form<ResetForm> resetForm = form(ResetForm.class);

		if (token == null) {
			flash("error", Messages.get("error.technical"));			
			return badRequest(reset.render(resetForm, token));
		}

		Token resetToken = Token.findByTokenAndType(token, Token.TypeToken.user);
		if (resetToken == null) {
			flash("error", Messages.get("error.technical"));
			return badRequest(reset.render(resetForm, token));
		}

		if (resetToken.isExpired()) {
			resetToken.delete();
			flash("error", Messages.get("error.expiredresetlink"));
			return badRequest(reset.render(resetForm, token));
		}

		return ok(reset.render(resetForm, token));
	}

	/**
	 * @return reset password form
	 */
	public Result runReset(String token) {
		Form<ResetForm> resetForm = form(ResetForm.class).bindFromRequest();

		if (resetForm.hasErrors()) {
			//flash("error", Messages.get("signup.valid.password"));
			return badRequest(reset.render(resetForm, token));
		}

		try {
			Token resetToken = Token.findByTokenAndType(token, Token.TypeToken.password);
			if (resetToken == null) {
				flash("error", Messages.get("error.technical"));
				return badRequest(reset.render(resetForm, token));
			}

			if (resetToken.isExpired()) {
				resetToken.delete();
				flash("error", Messages.get("error.expiredresetlink"));
				return badRequest(reset.render(resetForm, token));
			}

			// check email
			User user = User.find.byId(resetToken.userId);
			if (user == null) {
				// display no detail (email unknown for example) to
				// avoir check email by foreigner
				flash("error", Messages.get("error.technical"));
				return badRequest(reset.render(resetForm, token));
			}

			String password = resetForm.get().password;
			user.changePassword(password);

			// Send email saying that the password has just been changed.
			sendPasswordChanged(user);
			//flash("success", Messages.get("resetpassword.success"));
			return ok(success.render(resetForm, token));
		} catch (AppException e) {
			flash("error", Messages.get("error.technical"));
			return badRequest(reset.render(resetForm, token));
		} catch (EmailException e) {
			flash("error", Messages.get("error.technical"));
			return badRequest(reset.render(resetForm, token));
		}

	}
	
	public Result runResetAdmin(String token) {
		Form<ResetForm> resetForm = form(ResetForm.class).bindFromRequest();

		if (resetForm.hasErrors()) {
			//flash("error", Messages.get("signup.valid.password"));
			return badRequest(reset.render(resetForm, token));
		}

		try {
			Token resetToken = Token.findByTokenAndType(token, Token.TypeToken.admin);
			if (resetToken == null) {
				flash("error", Messages.get("error.technical"));
				return badRequest(reset.render(resetForm, token));
			}

			if (resetToken.isExpired()) {
				resetToken.delete();
				flash("error", Messages.get("error.expiredresetlink"));
				return badRequest(reset.render(resetForm, token));
			}

			// check email
			User user = User.find.byId(resetToken.userId);
			if (user == null) {
				// display no detail (email unknown for example) to
				// avoir check email by foreigner
				flash("error", Messages.get("error.technical"));
				return badRequest(reset.render(resetForm, token));
			}

			String password = resetForm.get().password;
			user.changePassword(password);

			// Send email saying that the password has just been changed.
			sendPasswordChanged(user);
			//flash("success", Messages.get("resetpassword.success"));
			return ok(success.render(resetForm, token));
		} catch (AppException e) {
			flash("error", Messages.get("error.technical"));
			return badRequest(reset.render(resetForm, token));
		} catch (EmailException e) {
			flash("error", Messages.get("error.technical"));
			return badRequest(reset.render(resetForm, token));
		}

	}
	
	public Result runResetUser(String token) {
		Form<ResetForm> resetForm = form(ResetForm.class).bindFromRequest();

		if (resetForm.hasErrors()) {
			//flash("error", Messages.get("signup.valid.password"));
			return badRequest(reset.render(resetForm, token));
		}

		try {
			Token resetToken = Token.findByTokenAndType(token, Token.TypeToken.user);
			if (resetToken == null) {
				flash("error", Messages.get("error.technical"));
				return badRequest(reset.render(resetForm, token));
			}

			if (resetToken.isExpired()) {
				resetToken.delete();
				flash("error", Messages.get("error.expiredresetlink"));
				return badRequest(reset.render(resetForm, token));
			}

			// check email
			User user = User.find.byId(resetToken.userId);
			if (user == null) {
				// display no detail (email unknown for example) to
				// avoir check email by foreigner
				flash("error", Messages.get("error.technical"));
				return badRequest(reset.render(resetForm, token));
			}

			String password = resetForm.get().password;
			user.changePassword(password);

			// Send email saying that the password has just been changed.
			sendPasswordChanged(user);
			//flash("success", Messages.get("resetpassword.success"));
			return ok(success.render(resetForm, token));
		} catch (AppException e) {
			flash("error", Messages.get("error.technical"));
			return badRequest(reset.render(resetForm, token));
		} catch (EmailException e) {
			flash("error", Messages.get("error.technical"));
			return badRequest(reset.render(resetForm, token));
		}

	}

	/**
	 * Send mail with the new password.
	 *
	 * @param user
	 *            user created
	 * @throws EmailException
	 *             Exception when sending mail
	 */
	private void sendPasswordChanged(User user) throws EmailException {
		String subject = Messages.get("mail.reset.confirm.subject");
		String message = Messages.get("mail.reset.confirm.message");
		Mail.Envelop envelop = new Mail.Envelop(subject, message, user.getEmail());
		Mail mailer = new Mail(mailerClient);
		mailer.sendMail(envelop);
	}

	public String passwordValidate(String password) {

		// Need to make sure we have:
		// 8 characters; 1 Uppercase character; 1 Lowercase character; 1 Number;
		// 1 Special Character
		String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$!%^&+=])(?=\\S+$).{8,}";
		if (!password.matches(passwordPattern)) {
			return Messages.get("password.message");
		}

		return null;
	}
}
