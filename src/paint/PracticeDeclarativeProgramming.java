package paint;

import java.util.Arrays;
import java.util.List;

public class PracticeDeclarativeProgramming {

	private int getSumByImperative(List<Integer> list) {
		int sum = 0;
		for(int number : list) {
			if(number > 6 && number % 2 != 0) {
				sum += number;
			}
		}
		return sum;
	}
	
	private int getSumByDeclarative(List<Integer> list) {
		return list.stream()
				.filter(number -> number > 6 && number%2 != 0)
				.mapToInt(number -> number)
				.sum();
	}
	
	public static void main(String[] args) {
		PracticeDeclarativeProgramming s = new PracticeDeclarativeProgramming();
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 21, 38, 48, 7);
		System.out.println("Imperative : " +s.getSumByImperative(list));
		System.out.println("Declarative : " +s.getSumByDeclarative(list));
	}
}
