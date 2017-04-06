/**
 * 
 */
package models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Expr;
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
public class RemovedCard extends Model {

	@Id
	public Long id;

	@Constraints.Required
	public String name;

	@Constraints.Required
	public String team;

	@Constraints.Required
	public String teamkey;

	@Constraints.Required
	public String position;

	@Constraints.Required
	public String cardmaker;

	@Constraints.Required
	public Integer year;

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
	
    public String removedBy;
    
    public String removedbyuserkey;
    
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date dateRemoved;

	// -- Queries (long id, profile.class)
	public static Model.Finder<Long, RemovedCard> find = new Model.Finder<Long, RemovedCard>(Long.class, RemovedCard.class);

	public static List<RemovedCard> filterByTeam(String value) {
		return find.where().eq("team", value).findList();
	}
	
	public static List<RemovedCard> filterByPosition(String value) {
		return find.where().eq("position", value).findList();
	}

	public static RemovedCard findByUniqueKey(String uniqueKey) {
		return find.where().eq("uniquekey", uniqueKey).findUnique();
	}
	
	public static List<RemovedCard> searchAllCards(String value) {
		return find.where()
				.disjunction()
				.add(Expr.like("name", "%" + value + "%"))
				.add(Expr.like("position", "%" + value + "%"))
				.add(Expr.like("team", "%" + value + "%"))
				.add(Expr.like("cardmaker", "%" + value + "%"))
				.findList();
	}

	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			RemovedCard record = RemovedCard.findByUniqueKey(uniqueKey);
			if (record != null) {
				// Found key, not unique...
				Logger.debug("Unique Key " + uniqueKey + " is not unique, creating a new one...");
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
