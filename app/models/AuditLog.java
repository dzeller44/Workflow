/**
 * 
 */
package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.*;

import models.enums.RoleType;
import play.mvc.Http;

/**
 * @author rhelton
 *
 */
@Entity
@Table(name = "audit_log")
public class AuditLog {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "email")
	private String email;

	@Column(name = "role")
	private String role;

	@Column(name = "context")
	private String context;

	@Column(name = "screen")
	private String screen;

	@Column(name = "field")
	private String field;

	@Column(name = "value")
	private String value;

	@Column(name = "ip")
	private String ip;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "host")
	private String host;

	@Column(name = "created")
	private Date created;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @return the screen
	 */
	public String getScreen() {
		return screen;
	}

	/**
	 * @param screen
	 *            the screen to set
	 */
	public void setScreen(String screen) {
		this.screen = screen;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * 
	 * @param userId
	 * @param context
	 * @param screen
	 * @param field
	 * @param value
	 */
	public static void setLog(String userId, String email, String context, String screen, String field, String value) {
		String ip = Http.Context.current().request().remoteAddress();
		String path = Http.Context.current().request().path();
		String host = Http.Context.current().request().host();
		setLog(userId, email, context, screen, field, value, ip, path, host);
	}

	/**
	 * 
	 * @param userId
	 * @param context
	 * @param screen
	 * @param field
	 * @param value
	 * @param ip
	 */
	public static void setLog(String userId, String email, String context, String screen, String field, String value, String ip, String path, String host) {
		RoleType role = null;

		if (role == null) {
			User user = Ebean.find(models.User.class).where().eq("email", email).findUnique();
			if (user != null)
				role = user.getRole();
			else
				role = null;
		}

		AuditLog log = new AuditLog();
		log.setUserId(userId);
		if (role != null) {
			log.setRole(role.toString());
		}
		else {
			log.setRole("N/A");
		}		
		log.setEmail(email);
		log.setContext(context);
		log.setScreen(screen);
		log.setField(field);
		log.setValue(value);
		log.setCreated(new Date());
		log.setIp(ip);
		log.setPath(path);
		log.setHost(host);
		Ebean.save(log);

	}
}
