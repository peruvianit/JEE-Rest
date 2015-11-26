package it.peruvianit.commons.util;

import java.util.Calendar;

public final class DateUtils {
	public static Long getCurrentTimeUTC(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTimeInMillis();		
	}
}
