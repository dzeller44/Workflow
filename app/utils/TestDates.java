/**
 * 
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author zellerd
 *
 */
public class TestDates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Calendar c = GregorianCalendar.getInstance();
		 * 
		 * System.out.println("Current week = " + Calendar.DAY_OF_WEEK);
		 * 
		 * // Set the calendar to monday of the current week
		 * c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
		 * System.out.println("Current week = " + Calendar.DAY_OF_WEEK);
		 * 
		 * // Print dates of the current week starting on Monday DateFormat df =
		 * new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()); String
		 * startDate = ""; String endDate = "";
		 * 
		 * startDate=df.format(c.getTime());c.add(Calendar.DATE,4);endDate=df.
		 * format(c.getTime());
		 * 
		 * System.out.println("Start Date = "+startDate);System.out.
		 * println("End Date = "+endDate);
		 */
		LocalDate today = LocalDate.now();

		// Go backward to get Monday
		LocalDate monday = today;
		while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
			monday = monday.minusDays(1);
		}

		// Go forward to get Sunday
		LocalDate sunday = today;
		while (sunday.getDayOfWeek() != DayOfWeek.FRIDAY) {
			sunday = sunday.plusDays(1);
		}

		System.out.println("Today: " + today);
		System.out.println("Monday of the Week: " + monday);
		System.out.println("Friday of the Week: " + sunday);
	}

}
