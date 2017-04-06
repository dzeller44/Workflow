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
public class Comment extends Model {

	@Id
	public Long id;
	
	@Constraints.Required
	public String author;
	
	@Constraints.Required
	public String authoremail;
	
	@Constraints.Required
	public String comment;
	
	@Constraints.Required
	public String cardkey;
	
	@Constraints.Required
	public String uniquekey;
	
	@Constraints.Required
	public String userkey;
	
	@Constraints.Required
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date datecreated;
	
	// -- Queries (long id, profile.class)
	public static Model.Finder<Long, Comment> find = new Model.Finder<Long, Comment>(Long.class, Comment.class);
	
	public static Comment findByCommentKey(String uniqueKey) {
		return find.where().eq("uniquekey", uniqueKey).findUnique();
	}
	
	public static List<Comment> getAllByCardKey(String cardKey) {
		return find.where().eq("cardkey", cardKey).findList();
	}
	
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			Comment unique = Comment.findByCommentKey(uniqueKey);
			if (unique != null) {
				// Found key, not unique...
				Logger.debug(
						"Comment.createCommentKey: card Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// Key is unique...
				Logger.debug("Comment.createCommentKey: card Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}

		return uniqueKey;
	}
}
