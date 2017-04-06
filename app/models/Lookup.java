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
public class Lookup extends Model {

	@Id
	public Long id;
	
	@Constraints.Required
	public String lookuptype;	

	@Constraints.Required
	public String name;	

	public String description;	
	
	@Constraints.Required
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date datecreated;
	
	@Constraints.Required
	public String lookupkey;

	public String updatedby;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date dateupdated;
	
	public String userkey;

    // -- Queries (long id, profile.class)
    public static Model.Finder<Long, Lookup> find = new Model.Finder<Long, Lookup>(Long.class, Lookup.class);
        
    public static Lookup findByName(String name) {
        return find.where().eq("name", name).findUnique();
    } 
    
    public static List<Lookup> findAllByType(String type) {
        return find.where().eq("lookupType", type).findList();
    } 
    
	public String createUniqueKey() {
		String uniqueKey = null;

		// Make sure it is unique...
		uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
		Boolean isUnique = false;
		while (!isUnique) {
			Lookup lookup = Lookup.findByUniqueKey(uniqueKey);
			if (lookup != null) {
				// Found unique, not unique...
				Logger.debug("Unique.createUniqueKey: unique Key " + uniqueKey + " is not unique, creating a new one...");
				uniqueKey = UUID.randomUUID().toString().replaceAll("-", "");
			} else {
				// unique Key is unique...
				Logger.debug("Unique.createUniqueKey: unique Key " + uniqueKey + " is unique.");
				isUnique = true;
			}
		}

		return uniqueKey;
	}
	
	/**
	 * Retrieves a record by unique key
	 *
	 * @param unique key
	 * @return a record if the unique key is found, null otherwise.
	 */
	public static Lookup findByUniqueKey(String uniqueKey) {
		return find.where().eq("lookupkey", uniqueKey).findUnique();
	}
	
	public static List<Lookup> filterByType(String type) {
		return find.where().eq("lookuptype", type).findList();
	}


}
