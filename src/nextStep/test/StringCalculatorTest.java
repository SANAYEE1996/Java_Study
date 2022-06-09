package nextStep.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextStep.chapter02.StringCalculator;

class StringCalculatorTest {

private StringCalculator sc;
	
	@BeforeEach
	public void setup() {
		sc = new StringCalculator();
	}
	
	@Test
	void testCase01() {
		assertEquals(6,sc.add("1,2,3"));
	}
	
	@Test
	void testCase02() {
		assertEquals(6,sc.add("1,2:3"));
	}
	
	@Test
	void testCase03() {
		assertEquals(6,sc.add("1:2:3"));
	}
	
	@Test
	void testCase04() {
		assertEquals(6,sc.add("//;\n1;2;3"));
	}
	
	@Test
	void testCase05() {
		assertEquals(0,sc.add(""));
	}
	
	@Test
	void testCase06() {
		assertEquals(1,sc.add("1"));
	}
	
	@Test
	void testCase07() {
		assertEquals(0,sc.add(null));
	}
	
	@Test
	void runtimeExceptionCase() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			sc.add("//;\n1;-2;3");
	    });
	}
}
