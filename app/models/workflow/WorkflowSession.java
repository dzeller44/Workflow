package models.workflow;

import play.data.validation.Constraints;
import com.avaje.ebean.Model;

import models.enums.workflow.WorkflowRole;
import utils.Crypto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author Dan Zeller
 *
 */
@Entity
public class WorkflowSession extends Model {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="hash")
    @Constraints.MinLength(10)
    private String hash;

    @Column(name="user_id")
    private String userId;
    
    @Column(name="email")
    private String email;

    @Column(name="expiration_date")
    private Date expirationDate = new Date();

    @Column(name="data")
    @Constraints.MinLength(10)
    private String data;
    
    @Column(name="userkey")
    private String userkey;
    
    @Column(name="role")
    private WorkflowRole role;
    
    @Column(name="rolename")
    private String rolename;

	// -- Queries (long id, user.class)
	public static Model.Finder<Long, WorkflowSession> find = new Model.Finder<Long, WorkflowSession>(Long.class, WorkflowSession.class);
	
	public static List<WorkflowSession> findByEmail(String email) {
		return find.where().eq("email", email).findList();
	}
	
    public String getData() {
        return  Crypto.decryptData(data);
    }

    public String getEmail() {
		return email;
	}

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getHash() {
        return hash;
    }

    public Integer getId() {
        return id;
    }

    public WorkflowRole getRole() {
		return role;
	}

    public String getRolename() {
		return rolename;
	}

    public String getUserId() {
        return userId;
    }

    public String getUserkey() {
		return userkey;
	}

    public void setData(String data) {
        this.data = Crypto.encryptData(data);
    }

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

	public void setHash(String hash) {
        this.hash = hash;
    }

	public void setId(Integer id) {
        this.id = id;
    }

	public void setRole(WorkflowRole role) {
		this.role = role;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public void setUserId(String userId) {
        this.userId = userId;
    }

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

}
