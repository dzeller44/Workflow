/**
 * 
 */
package models.enums;

import com.avaje.ebean.annotation.EnumValue;

/**
 * @author zellerd
 *
 */
public enum RoleType {
	@EnumValue("0")
	UNDEFINED(0), @EnumValue("1")
	USER(1), @EnumValue("2")
	ADMIN(2);

	private int value;

	RoleType(int i) {
		value = i;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public String getRoleTextName(RoleType role) {
		String roleName;

		switch (role.toString()) {
		case "1":
			roleName = "User";
			break;
		case "2":
			roleName = "Admin";
			break;
		default:
			roleName = "Undefined";
			break;
		}

		return roleName;
	}

	public static String getRoleTextNameString(String role) {
		String roleName;

		switch (role) {
		case "1":
			roleName = "User";
			break;
		case "2":
			roleName = "Admin";
			break;
		default:
			roleName = "Undefined";
			break;
		}

		return roleName;
	}
}
