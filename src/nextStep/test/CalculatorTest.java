package nextStep.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextStep.chapter02.Calculator;

class CalculatorTest {
	
	private Calculator cal;
	
	@BeforeEach
	public void setup() {
		cal = new Calculator();;
	}
	
	@Test
	void addTest() {
		assertEquals(8, cal.add(5,3));
	}
	
	@Test
	void minusTest() {
		assertEquals(2, cal.minus(5,3));
	}
	
	@Test
	void multipleTest() {
		assertEquals(15, cal.multiple(5,3));
	}
	
	@Test
	void divideTest() {
		assertEquals(1, cal.divide(5,3));
	}
	
	@Test
	void remainTest() {
		assertEquals(2, cal.remain(5,3));
	}

}
