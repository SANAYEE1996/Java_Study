package paint;

public class Paint {

	public static void main(String[] args) {
		int num = 0;
		int plus = 3;
		int index = 0;
		while(num < 1000000000) {
			num += plus;
			plus += 2;
			index++;
		}
		System.out.println("num : "+num);
		System.out.println("plus : "+plus);
		System.out.println("index : "+index);
	}

}
