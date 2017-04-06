package utils;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.avaje.ebean.Ebean;
import com.opencsv.CSVWriter;
import models.User;

/**
 * @author zellerd
 *
 */
public class Export {

	public static void exportAllUsers() {
		try {
			List<User> users = Ebean.find(models.User.class).findList();
			String usersCSV = "C:\\temp\\users.csv";
			System.out.println("Writing -----users.csv----------------");
			CSVWriter usersWriter = new CSVWriter(new FileWriter(usersCSV));
			List<String[]> usersArr = new ArrayList<String[]>();
			usersArr.add(new String[] { "ID", "Email", "Full Name" });

			for (User user : users) {
				usersArr.add(new String[] { new Long(user.getId()).toString(), user.getEmail(), user.fullname });
			}

			usersWriter.writeAll(usersArr);
			usersWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void exportUserData(String whatData) {
		
		List<User> users = null;
		
		try {
			switch (whatData) {
			case "EMNeedApproval":
				users = User.findUnapprovedEM();
				break;
			default:
				users = User.find.all();
				break;
			}

			String usersCSV = "C:\\temp\\users.csv";
			System.out.println("Writing -----users.csv----------------");
			CSVWriter usersWriter = new CSVWriter(new FileWriter(usersCSV));
			List<String[]> usersArr = new ArrayList<String[]>();
			usersArr.add(new String[] { "ID", "Email", "Full Name" });

			for (User user : users) {
				usersArr.add(new String[] { new Long(user.getId()).toString(), user.getEmail(), user.fullname });
			}

			usersWriter.writeAll(usersArr);
			usersWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
