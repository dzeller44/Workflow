package controllers.workflow;

import static play.data.Form.form;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import managers.workflow.WorkflowSessionAccess;
import models.enums.workflow.WorkflowRole;
import models.workflow.WorkflowAuditRecord;
import models.workflow.WorkflowLookup;
import models.workflow.WorkflowProfile;
import models.workflow.WorkflowProfileEdit;
import models.workflow.WorkflowUser;
import play.Logger;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.genericsuccess;
import views.html.workflow.denied;
import views.html.workflow.profile;
import views.html.workflow.profileview;
import views.html.workflow.profileedit;
import views.html.workflow.recordcreated;
import views.html.workflow.recordupdated;

/**
 * @author Dan Zeller
 *
 */
public class ApplicationProfile extends Controller {

	public static Result ACCESS_DENIED = redirect(routes.ApplicationProfile.accessDenied());
	
	public static final String delimiter = "~~";

	public static class NewProfile {

		public String appName;
		
		public String appDesc;
		
		public String appOwner;
		
		public String appOwnerEmail;
		
		public String appAgency;

	}

	public Result accessDenied() {
		// Direct to access denied...
		return ok(denied.render());
	}
	
	public Result addProfile() {
		// Check Role...
		if (hasCorrectAccess(WorkflowRole.ADMIN) != true) {
			return ACCESS_DENIED;
		} else {
			List<WorkflowLookup> lookups = WorkflowLookup.find.all();
			List<WorkflowUser> users = WorkflowUser.find.all();
			return ok(profile.render(form(NewProfile.class), lookups, users));
		}
	}
	
	public boolean hasCorrectAccess(WorkflowRole accessRole) {
		// Make sure user has correct role to access...
		// Pass in Role user should have use...
		// Compare with user's current role...

		// Is the user authenticated?
		boolean isAuth = WorkflowSessionAccess.isAuthenticated();
		if (isAuth) {
			// Get the current role and compare...
			WorkflowRole currentRole = WorkflowSessionAccess.getSessionRole();
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
	
	public Result initializeRecordUniqueKeys() {
		List<WorkflowLookup> lookups = WorkflowLookup.find.all();
		for (WorkflowLookup lookup : lookups) {
			lookup.setDateCreated(new Date());
			lookup.setLookupKey(lookup.createUniqueKey());
			lookup.save();
		}

		List<WorkflowUser> users = WorkflowUser.find.all();
		for (WorkflowUser user : users) {
			user.setUserKey(user.createUniqueKey());
			user.setDateCreation(new Date());
			user.save();
		}

		return ok(genericsuccess.render());
	}
	
	public Result saveProfile() {
		Form<NewProfile> newProfile = form(NewProfile.class).bindFromRequest();

		if (newProfile.hasErrors()) {
			List<WorkflowLookup> lookups = WorkflowLookup.find.all();
			List<WorkflowUser> users = WorkflowUser.find.all();
			return badRequest(profile.render(newProfile, lookups, users));
		}
		// Save the profileEdit...
		WorkflowUser user = null;
		NewProfile profile = newProfile.get();
		Logger.debug("Save WorkflowProfile - good request");
		WorkflowProfile profileEdit = new WorkflowProfile();
		profileEdit.setAppName(profile.appName);
		profileEdit.setAppDesc(profile.appDesc);
		profileEdit.setAppOwner(profile.appOwner);
		profileEdit.setAppOwnerEmail(profile.appOwnerEmail);
		profileEdit.setAppAgency(profile.appAgency);
		// Create the unique key...
		profileEdit.setAppKey(profileEdit.createUniqueKey());
		// Set the date created...
		profileEdit.setDateCreated(new Date());
		profileEdit.save();

		// Add initial auditRecord...
		String userkey = WorkflowSessionAccess.getSessionUserKey();
		user = WorkflowUser.findByUserKey(userkey);

		// Let's create an Audit record...
		WorkflowAuditRecord auditRecord = new WorkflowAuditRecord();
		auditRecord.setParentKey(profileEdit.getAppKey());
		auditRecord.setMessage(Messages.get("workflow.appProfile.new.auditRecord"));
		auditRecord.setUniqueKey(auditRecord.createUniqueKey());
		auditRecord.setDateCreated(new Date());
		if (user != null) {
			auditRecord.setAuthor(user.getFullName());
			auditRecord.setAuthorEmail(user.getEmail());
			auditRecord.setAuthorkey(userkey);
		}
		auditRecord.save();

		return ok(recordcreated.render("workflow.appProfile.created"));
	}
	
	public Result viewProfiles() {
		// Get the current user...
		String userkey = WorkflowSessionAccess.getSessionUserKey();
		WorkflowUser user = WorkflowUser.findByUserKey(userkey);
		List<WorkflowLookup> lookups = WorkflowLookup.find.all();
		List<WorkflowProfile> profileList = WorkflowProfile.find.all();
		return ok(profileview.render(profileList, lookups, user));
	}
	
	public Result filterView(String type, String value) {
		List<WorkflowProfile> profileList = null;
		if (value.equals("All")) {
			profileList = WorkflowProfile.find.all();
		} else {
			// Decode the value, just in case...
			try {
				value = URLDecoder.decode(value, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			// Get type...
			switch (type) {
			case "agency":
				profileList = WorkflowProfile.filterByAgency(value);
				break;

			default:
				break;
			}
		}
		// Grab the current user...
		String userkey = WorkflowSessionAccess.getSessionUserKey();
		WorkflowUser user = WorkflowUser.findByUserKey(userkey);
		List<WorkflowLookup> lookups = WorkflowLookup.find.all();
		return ok(profileview.render(profileList, lookups, user));
	}
	
	public Result openProfile(String recordKey) {
		Form<NewProfile> profileEntry = form(NewProfile.class).bindFromRequest();		
		// Get correct record...
		WorkflowProfile profile = WorkflowProfile.findByUniqueKey(recordKey);

		// Someone is editing the record...
		// Need to record current version of this record to compare on save...
		// This will record the Audit History...
		// Create new record in WorkflowProfileEdit table...
		WorkflowProfileEdit profileEdit = new WorkflowProfileEdit();
		profileEdit.setAppName(profile.appName);
		profileEdit.setAppDesc(profile.appDesc);
		profileEdit.setAppOwner(profile.appOwner);
		profileEdit.setAppOwnerEmail(profile.appOwnerEmail);
		profileEdit.setAppAgency(profile.appAgency);
		profileEdit.setAppKey(profile.appKey);
		// Set the date created...
		profileEdit.setDateCreated(new Date());

		// Create editkey...
		String editkey = profileEdit.createUniqueKey();
		profileEdit.setEditKey(editkey);
		profileEdit.save();
		profile.setEditKey(editkey);
		profile.save();

		List<WorkflowLookup> lookups = WorkflowLookup.find.all();
		List<WorkflowAuditRecord> profileAudits = WorkflowAuditRecord.getAllByParentKey(recordKey);
		List<WorkflowUser> users = WorkflowUser.find.all();
		return ok(profileedit.render(profileEntry, lookups, users, profile, profileAudits));
	}
	
	public Result updateProfile(String recordKey) {
		Form<NewProfile> profileEntry = form(NewProfile.class).bindFromRequest();
		// Get correct profile...
		WorkflowProfile profile = WorkflowProfile.findByUniqueKey(recordKey);
		// Get the current user...
		String userkey = WorkflowSessionAccess.getSessionUserKey();
		WorkflowUser user = WorkflowUser.findByUserKey(userkey);
		if (profileEntry.hasErrors()) {
			Logger.debug("Update WorkflowProfile - errors");
			List<WorkflowLookup> lookups = WorkflowLookup.find.all();
			List<WorkflowAuditRecord> profileAudits = WorkflowAuditRecord.getAllByParentKey(recordKey);
			List<WorkflowUser> users = WorkflowUser.find.all();
			return badRequest(profileedit.render(profileEntry, lookups, users, profile, profileAudits));
		}
		NewProfile profileForm = profileEntry.get();
		Logger.debug("Update WorkflowProfile - good request");
		profile.setAppName(profileForm.appName);
		profile.setAppDesc(profileForm.appDesc);
		profile.setAppOwner(profileForm.appOwner);
		profile.setAppOwnerEmail(profileForm.appOwnerEmail);
		profile.setAppAgency(profileForm.appAgency);
		profile.save();

		// Let's check the WorkflowProfileEdit record and see what is different...
		String editkey = profile.editKey;
		WorkflowProfileEdit profileEdit = WorkflowProfileEdit.findByEditKey(editkey);
		if (profileEdit != null) {
			// Compare the 2 records...
			String fieldSplit = "";
			String[] splitValues = null;
			String fieldName = "";
			String fieldDisplay = "";
			String oldValue = "";
			String newValue = "";
			String userName = "";
			String userEmail = "";
			String todayDate = "";
			String message = "";
			Field field = null;
			Object fieldObject = null;
			WorkflowAuditRecord profileAudit = null;
			String[] fieldArray = profileFieldControl();
			// Cycle through fieldArray...
			for (int x = 0; x < fieldArray.length; x++) {
				fieldSplit = fieldArray[x];
				splitValues = fieldSplit.split(delimiter);
				fieldName = splitValues[0];
				fieldDisplay = splitValues[1];
				try {
					// Get old value...
					field = profileEdit.getClass().getField(fieldName);
					fieldObject = field.get(profileEdit);
					if (fieldObject != null) {
						oldValue = fieldObject.toString();
					} else {
						oldValue = "";
					}
					// Get new value...
					field = profile.getClass().getField(fieldName);
					fieldObject = field.get(profile);
					if (fieldObject != null) {
						newValue = fieldObject.toString();
					} else {
						newValue = "";
					}
					if (!oldValue.equals(newValue)) {
						// Different values, create Audit record...
						profileAudit = new WorkflowAuditRecord();
						profileAudit.setParentKey(profileEdit.getAppKey());
						profileAudit.setUniqueKey(profileAudit.createUniqueKey());
						profileAudit.setDateCreated(new Date());
						if (user != null) {
							userName = user.getFullName();
							userEmail = user.getEmail();
							profileAudit.setAuthor(userName);
							profileAudit.setAuthorEmail(userEmail);
							profileAudit.setAuthorkey(userkey);
						}
						todayDate = new Date().toString();
						message = Messages.get("workflow.appProfile.fieldchanged", userName, userEmail, fieldName, oldValue, newValue, todayDate);
						profileAudit.setMessage(message);
						profileAudit.save();
					}
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} // Remove the WorkflowProfileEdit record...
			profileEdit.delete();
		}
		return ok(recordupdated.render("workflow.appProfile.updated"));
	}
	
	public static String[] profileFieldControl() {

		String[] fieldArray = new String[5];

		fieldArray[0] = "appName" + delimiter + "Application Name";
		fieldArray[1] = "appDesc" + delimiter + "Description";
		fieldArray[2] = "appOwner" + delimiter + "Application Owner";
		fieldArray[3] = "appOwnerEmail" + delimiter + "Application Owner Email";
		fieldArray[4] = "appAgency" + delimiter + "Agency";

		return fieldArray;
	}
	
}
