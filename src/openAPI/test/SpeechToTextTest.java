package openAPI.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import openAPI.SpeechToText;

class SpeechToTextTest {
	
	private SpeechToText stt;
	
	@BeforeEach
	public void setup() {
		stt = new SpeechToText("");
	}
	
	@Test
	void test() {
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", ""));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", ""));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", ""));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", ""));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", ""));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
	}

}
