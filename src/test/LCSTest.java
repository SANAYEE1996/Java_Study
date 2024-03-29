package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithm.LCS;

class LCSTest {
	
	private LCS lcs;
	
	@BeforeEach
	public void setup() {
		lcs = new LCS();
	}

	@Test
	void test() {
		assertEquals("ars",lcs.gogo("tars", "arts"));
	}
	
	@Test
	void test02() {
		assertEquals("etion",lcs.gogo("intention", "execution"));
	}
	
	@Test
	void test03() {
		assertEquals("intton",lcs.gogo("intentionplease", "executionbutton"));
	}
	
	@Test
	void test04() {
		assertEquals("ee",lcs.gogo("eniplease", "executobu"));
	}

}
