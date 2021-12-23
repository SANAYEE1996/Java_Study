package ysp_2021_12_24;

public class Generic {

	public static void main(String[] args) {
		ClassName<String> a = new ClassName<>();
		ClassName<Integer> b = new ClassName<>();
		
		a.set("Let's roll!");
		b.set(1);
		
		System.out.println(a.get());
		System.out.println(b.get());
		
		System.out.println("주소값 ? : "+a);
		System.out.println("주소값 ? : "+b);
	}

}

class ClassName<E>{
	private E element;
	
	void set(E element) {
		this.element = element;
	}
	
	E get(){
		return element;
	}
	
	
}

/* Generic
 * 제네릭 - 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것!
 * 특정(Specific) 타입을 미리 지정해주는 것이 아닌 필요에 의해 지정할 수 있도록 하는 일반(Generic) 타입
 * !! 지정된다는 것 보다 타입의 경계를 지정하고, 컴파일 때 해당타입으로 캐스팅 하여 매개변수화 된 유형을 삭제하는 것?
 * 
 * 장점
 * 제너릭을 사용하면 잘못된 타입이 들어 올수 있는 것을 컴파일 단계에서 방지할 수 있다.
 * 클래스 외부에서 타입을 지정해주기 때문에 따로 타입을 체크하고 변환해줄 필요가 없다. -> 관리하기 편하다
 * 비슷한 기능을 지원하는 경우 코드의 재사용성이 높아진다.
 * 
 * 주의사항!
 * 타입 파라미터로 명시할 수 있는 것은 참조 타입(Reference Type)밖에 올수 없다.
 * int, double, char 같은 primitive type은 올 수 없다.
 * Integer, Double 와 같은 wrapper Type을 쓰도록 합시다!
 * 
 * */
