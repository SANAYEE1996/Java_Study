package initialSound;

//import java.lang.Boolean; //-->기본
//import java.io.*;   //--> 외부로 보냄

public class SoundSearcher {

	private static final char HANGUL_BEGIN_UNICODE = 44032; // 가

	private static final char HANGUL_LAST_UNICODE = 55203; // 힣

	private static final char HANGUL_BASE_UNIT = 588;// 각자음 마다 가지는 글자수

	private static final char[] INITIAL_SOUND = { 'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ',
			'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' };

	private boolean isInitialSound(char searchCharacter) {
		for (char c : INITIAL_SOUND) {
			if (c == searchCharacter) return true;
		}
		return false;
	}
	
	private boolean isHangul(char c) {
		return HANGUL_BEGIN_UNICODE <= c && c <= HANGUL_LAST_UNICODE;
	}
	
	private char getInitialSound(char c) {
		if(c < HANGUL_BEGIN_UNICODE) return c;
		return INITIAL_SOUND[(c - HANGUL_BEGIN_UNICODE) / HANGUL_BASE_UNIT];
	}


	
	private boolean isCharacterMatch(char targetCharacter, char searchCharacter) {
		if(targetCharacter == searchCharacter) {
			return true;
		}
		else if((isHangul(targetCharacter) || isInitialSound(targetCharacter))&&
				(isHangul(searchCharacter) || isInitialSound(searchCharacter)) &&
				getInitialSound(targetCharacter) == searchCharacter ){
			return true;
		}
		return false;
	}
	
	private int sameCount(String target, String search) {
		int sameCnt = 0;
		for(int i = 0; i < target.length(); i++) {
			if(isCharacterMatch(target.charAt(i), search.charAt(i))) sameCnt++;
			else break;
		}
		return sameCnt;
	}
	
	public boolean isMatch(String value, String search) {
		int searchLength = search.length();
		int lengthDiffer = value.length() - searchLength;
		if (lengthDiffer < 0) return false;
		
		for(int i = 0; i <= lengthDiffer; i++) {
			if(sameCount(value.substring(i,i+searchLength), search) == searchLength) 
				return true;
		}
		
		return false;
	}
	
}
