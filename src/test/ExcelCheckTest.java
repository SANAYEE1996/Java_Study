package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import paint.ExcelCheck;

class ExcelCheckTest {
	
	private ExcelCheck ec;
	
	@BeforeEach
	public void setup() {
		ec = new ExcelCheck();
	}

	@Test
	void test() {
		assertTrue(ec.isNumber("12345"));
	}
	
	@Test
	void test01() {
		assertTrue(ec.isNumber("12.345"));
		assertTrue(ec.isNumber("12.015"));
	}
	
	@Test
	void test02() {
		assertFalse(ec.isNumber("12.34.5"));
	}
	
	@Test
	void test03() {
		assertFalse(ec.isNumber("012"));
	}

}
