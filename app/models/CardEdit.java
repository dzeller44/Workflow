package models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

import models.enums.RoleType;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author zellerd
 *
 */
@Entity
public class CardEdit extends Model {

	@Id
	public Long id;
	
	@Constraints.Required
	public String editkey;

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
	
	@Constraints.Required
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date datecreated;
	
	@Constraints.Required
	public String cardkey;
	
	public String userkey;

	public String updatedby;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateupdated;

    // -- Queries (long id, profile.class)
    public static Model.Finder<Long, CardEdit> find = new Model.Finder<Long, CardEdit>(Long.class, CardEdit.class);
    
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			CardEdit record = CardEdit.findByEditKey(uniqueKey);
			if (record != null) {
				// Found record, not unique...
				Logger.debug("Intake.createEditKey: intake Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// intake Key is unique...
				Logger.debug("Intake.createEditKey: intake Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}
		return uniqueKey;
	}

	public static CardEdit findByCardKey(String cardKey) {
		return find.where().eq("cardkey", cardKey).findUnique();
	}
	
	public static CardEdit findByEditKey(String editKey) {
		return find.where().eq("editkey", editKey).findUnique();
	}

}
