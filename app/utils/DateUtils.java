/**
 * 
 */
package utils;

import java.util.Date;

/**
 * @author rhelton
 *
 */
public class DateUtils {
	   /**
     * Get the hours difference between two dates
     * @param lastDate
     * @param extractDate
     * @return
     */
    public static int getHoursBetweenDate(Date lastDate, Date extractDate){
        long subDate = lastDate.getTime() - extractDate.getTime();
        return (int) (subDate / (60 * 60 * 1000));
    }
}
