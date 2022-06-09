package nextStep.chapter02;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 * 1. 쉼표 또는 콜론을 구부자로 가지는 문자열을 전달하는 경우 
 * 	  구분자를 기준으로 분리한 각 숫자의 합을 반환
 * 
 * 2. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
 *    커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 
 *    문자를 커스텀 구분자로 사용한다.
 *    
 * 3. 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외처리 한다.
 * 
 * */

public class StringCalculator {
	
	public int overZero(int a) {
		if(a < 0) throw new RuntimeException();
		return a;
	}
	
	public int tokenAdd(String[] tokens) {
		int sum = 0;
		for(String s : tokens)
			sum += overZero(Integer.parseInt(s));
		return sum;
	}
	
	public String[] split(String str) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
		if(m.find()) {
			return m.group(2).split(m.group(1));
		}
		return str.split(",|:");
	}
	
	public int add(String str) {
		if(str == null || str.isEmpty()) return 0;
		
		return tokenAdd(split(str));
	}
}
