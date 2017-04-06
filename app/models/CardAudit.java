/**
 * 
 */
package models;

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
 * @author zellerd
 *
 */

@Entity
public class CardAudit extends Model {

	@Id
	public Long id;

	@Constraints.Required
	public String cardkey;
	
	@Constraints.Required
	public String editor;
	
	@Constraints.Required
	public String editoremail;
	
	@Constraints.Required
	public String editorkey;
	
	@Constraints.Required
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date editdate;
	
	@Constraints.Required
	public String fieldname;
	
	@Constraints.Required
	public String fielddisplay;
	
	@Constraints.Required
	public String oldvalue;
	
	@Constraints.Required
	public String newvalue;
	
	@Constraints.Required
	public String auditkey;
	
	 // -- Queries (long id, profile.class)
    public static Model.Finder<Long, CardAudit> find = new Model.Finder<Long, CardAudit>(Long.class, CardAudit.class);
	
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			CardAudit record = CardAudit.findByAuditKey(uniqueKey);
			if (record != null) {
				// Found record, not unique...
				Logger.debug("Audit.createUnqiueKey: audit Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// intake Key is unique...
				Logger.debug("Audit.createUniqueKey: audit Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}

		return uniqueKey;
	}

	public static CardAudit findByAuditKey(String auditKey) {
		return find.where().eq("auditkey", auditKey).findUnique();
	}
	
	public static List<CardAudit> findByCardKey(String cardKey) {
		return find.where().eq("cardkey", cardKey).findList();
	}

	
}
