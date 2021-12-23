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
