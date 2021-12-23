package ysp_2021_12_23;

public class Garbage_collection {

	public static void main(String[] args) {
		int[] a = new int[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a = new int[] {4,5,6};
		System.gc();
		System.out.println(a[0] +" " + a[1] + " " +a[2]);

	}

}
