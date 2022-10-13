package cleanCode.chapter08;

import java.util.HashMap;
import java.util.Map;

public class Simulator {
	public static void main(String[] args) {
		Map sensors00 = new HashMap();
		String sensorId00 = "timeId";
		Sensor s00 = (Sensor) sensors00.get(sensorId00);
		/*
		 * Map이 반환하는 Object를 올바른 유형으로 변환할 책임은 Map을 사용하는 클라이언트에 있다.
		 * 그래도 코드는 동작하지만, 깨끗한 코드라 보기는 어렵다. 아래와 같이 제너릭스를 사용하면
		 * 코드 가독성이 크게 높아진다.
		 * */
		
		Map<String, Sensor> sensors01 = new HashMap<>();
		String sensorId01 = "timeId";
		Sensor s01 = sensors01.get(sensorId01);
		/*
		 * Map<String, Sensor> sensors01 가 사용자에게 필요하지 않은 기능까지 제공한다는 문제는 여전히 존재.
		 * */
		
		
	}
}
