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
		stt.printSpeech("korean", "C:/Users/imaxsoft-21/Desktop/small.wav");
		stt.printSpeech("korean", "C:/Users/imaxsoft-21/Desktop/testCase01.wav");
		stt.printSpeech("korean", "C:/Users/imaxsoft-21/Desktop/testCase02.wav");
	}

}
