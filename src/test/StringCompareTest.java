package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.StringCompare;

class StringCompareTest {
	
	private StringCompare s;
	
	@BeforeEach
	public void setup() {
		s = new StringCompare();
	}
	
	@Test
	void testSameLengthWord() {
		assertEquals(1,s.compareTo("abcd","abcc"));
		assertEquals(-1,s.compareTo("abcc","abcd"));
		assertEquals(0,s.compareTo("abcc","abcc"));
	}
	
	@Test
	void testDifferenceLengthWord() {
		assertEquals(1,s.compareTo("abcd","abc"));
		assertEquals(-1,s.compareTo("abc","abcd"));
	}

}
