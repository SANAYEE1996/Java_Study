package paint;

import java.util.Arrays;

public class Paint {

	public static void main(String[] args) {
		String[] strArray = "115','39','21".split("','");
		System.out.println(Arrays.toString(strArray));
		strArray = "54".split("','");
		System.out.println(Arrays.toString(strArray));
	}

}
