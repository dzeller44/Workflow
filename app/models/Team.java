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
public class Team extends Model {

	@Id
	public Long id;
	
	@Constraints.Required
	public String name;
	
	@Constraints.Required
	public String uniquekey;
	
	public String userkey;
	
	public String editkey;

	public String updatedby;
	
	@Constraints.Required
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date datecreated;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateupdated;
	
	// -- Queries (long id, profile.class)
	public static Model.Finder<Long, Team> find = new Model.Finder<Long, Team>(Long.class, Team.class);
	
	public static Team findByTeamName(String teamName) {
		return find.where().eq("name", teamName).findUnique();
	}
	
	public static Team findByUniqueKey(String uniqueKey) {
		return find.where().eq("uniquekey", uniqueKey).findUnique();
	}
	
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			Team record = Team.findByUniqueKey(uniqueKey);
			if (record != null) {
				// Found key, not unique...
				Logger.debug(
						"Unique Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// Key is unique...
				Logger.debug("Unique Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}

		return uniqueKey;
	}
}
