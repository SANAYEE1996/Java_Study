package paint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarPractice {

	public String getTime(String time, String type, int value) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(time));
		if(type.equals("WEEK")) {
			cal.add(Calendar.DATE, -value*7);
		}
		else if(type.equals("DAY")){
			cal.add(Calendar.DATE, -value);
		}
		else if(type.equals("HOUR")){
			cal.add(Calendar.HOUR, -value);
		}
		else if(type.equals("MIN")){
			cal.add(Calendar.MINUTE, -value);
		}
		return sdf.format(cal.getTime());
	}
}
