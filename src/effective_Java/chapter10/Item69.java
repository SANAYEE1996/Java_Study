package effective_Java.chapter10;

import java.util.ArrayList;
import java.util.List;

import effective_Java.chapter10.examObject.Mount;

public class Item69 {
	private void badExample(List<Mount> range) {
		mountListGenerator(range);
		try {
			int i = 0;
			while(true)
				range.get(i).climb();
		} catch (IndexOutOfBoundsException e) {
			// 아주 끔찍한 방식으로 사용하고 있다.
		}
	}
	
	private void mountListGenerator(List<Mount> range) {
		for(int i = 0; i < 10; i++) {
			range.add(new Mount());
		}
	}
	
	public static void main(String[] args) {
		List<Mount> range = new ArrayList<>();
		Item69 exampleMain = new Item69();
		exampleMain.badExample(range);
	}
}
