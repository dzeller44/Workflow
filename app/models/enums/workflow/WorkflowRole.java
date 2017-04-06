package models.enums.workflow;

import com.avaje.ebean.annotation.EnumValue;

/**
 * @author Dan Zeller
 *
 */
public enum WorkflowRole {
	@EnumValue("0")
	UNDEFINED(0), @EnumValue("1")
	USER(1), @EnumValue("2")
	APPROVER(2), @EnumValue("9")
	ADMIN(9);

	private int value;

	WorkflowRole(int i) {
		value = i;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static String getRoleTextName(WorkflowRole role) {
		String roleName;

		switch (role) {
		case USER:
			roleName = "User";
			break;
		case APPROVER:
			roleName = "Approver";
			break;
		case ADMIN:
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
			roleName = "Approver";
			break;
		case "9":
			roleName = "Admin";
			break;
		default:
			roleName = "Undefined";
			break;
		}

		return roleName;
	}
}
