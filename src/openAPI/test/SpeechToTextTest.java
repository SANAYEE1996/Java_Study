package openAPI.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import openAPI.SpeechToText;

class SpeechToTextTest {
	
	private SpeechToText stt;
	
	@BeforeEach
	public void setup() {
		stt = new SpeechToText("C:/Users/imaxsoft-21/git/Java_Study/src/openAPI/setting.properties");
	}
	
	@Test
	void test() {
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", "C:/Users/imaxsoft-21/Desktop/audio/10scs.wav"));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", "C:/Users/imaxsoft-21/Desktop/audio/20scs.wav"));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", "C:/Users/imaxsoft-21/Desktop/audio/20scs_01.wav"));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", "C:/Users/imaxsoft-21/Desktop/audio/20scs_fast.wav"));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
		
		startTime = System.nanoTime();
		System.out.println(stt.getText("korean", "C:/Users/imaxsoft-21/Desktop/audio/31scs.wav"));
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " +(endTime - startTime) / 1000000000.0 +" sec\n");
	}

}
