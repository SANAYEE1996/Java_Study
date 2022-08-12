package effective_Java.practicalWork.chapter02.item02;

public class Simulator {
	public static void main(String[] args) {
		NutritionFacts nf = new NutritionFacts.Builder(0,8).calories(1000)
														   .build();
		
		System.out.println(nf.getCalories());
	}
}
