package lamdaPractice;

import java.util.Arrays;

public class Chapter01 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Arrays.setAll(arr, (i) -> (int)(( Math.random()*5) + 1));
		System.out.println(Arrays.toString(arr));
		
		
		int[][] twoArray = {{1,2},{2,2},{3,1},{1,0}};
		
		Arrays.sort(twoArray, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		
		for(int[] i : twoArray) System.out.println(Arrays.toString(i));
	}

}
