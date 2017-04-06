package utils;

import java.util.Date;
import java.util.List;

import models.Lookup;

public class PopulateLookups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Lookup> lookups = Lookup.find.all();

		for (Lookup lookup : lookups) {
			lookup.datecreated = new Date();
			lookup.lookupkey = lookup.createUniqueKey();		
			lookup.save();
		}

	}

}
