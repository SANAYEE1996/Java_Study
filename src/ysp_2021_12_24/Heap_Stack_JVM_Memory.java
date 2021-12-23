package ysp_2021_12_24;

public class Heap_Stack_JVM_Memory {

	public static void main(String[] args) {
		Integer a = 10;
		System.out.println("Before Integer : " +a);
		changeInteger(a);
		System.out.println("After Integer : " +a);
		
		String b = "Hi";
		System.out.println("Before String : " +b);
		changeString(b);
		System.out.println("After String : " +b);

	}
	
	public static void changeInteger(Integer param) {
		param += 10;
	}
	
	public static void changeString(String param) {
		param += " world!";
	}

}

/*
 * 자바에서 Wrapper Class에 해당하는 Integer, Character, Byte, Boolean, Long, Double,
 * Float, Short 클래스는 모드 Immutable!!
 * 그래서 heap에 있는 같은 오브젝트를 레퍼런스 하고 있는 경우라도 새로운 연산이 적용되는 순간 새로운 오브젝트가 heap에
 * 새롭게 할당 됩니다!
 * 
 * Integer 클래스의 구현을 보니 final 이라는 상속을 제한하는 목적인 제어자가 있습니다.
 * 내부에서 실제로 사용하는 값인 value 라는 변수가 있는데 이 변수는 private final int value;라고 선언되어 있습니다..
 * 즉 생성자에 의해 생성되는 순간에만 초기화 되고 변경불가능한 값이 됩니다.
 * 이것 때문에 Wrapper class 들도 String 처럼 Immuntable한 오브젝트입니다!!!
 * 
 * 
 * */
