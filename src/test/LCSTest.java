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

}
