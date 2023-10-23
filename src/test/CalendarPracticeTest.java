package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import paint.CalendarPractice;

class CalendarPracticeTest {
	
	private CalendarPractice cp;
	
	@BeforeEach
	void init() {
		cp = new CalendarPractice();
	}

	@Test
	void test(){
		String startTime = "202310231900";
		try {
			assertEquals("202310091900",cp.getTime(startTime, "WEEK", 2));
			assertEquals("202310211900",cp.getTime(startTime, "DAY", 2));
			assertEquals("202310231700",cp.getTime(startTime, "HOUR", 2));
			assertEquals("202310231858",cp.getTime(startTime, "MIN", 2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
