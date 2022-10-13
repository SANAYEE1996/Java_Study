package cleanCode.chapter08;

import java.util.HashMap;
import java.util.Map;

public class Sensor {
	private long serialNumber = 1L;
	private double value = 1.00;
	
	public Sensor(long serialNumber, double value) {
		this.serialNumber = serialNumber;
		this.value = value;
	}
	
	public void printNowSensor() {
		System.out.println("now serialNumber : " + serialNumber);
		System.out.println("now Value : " + value);
	}
	
	private Map sensors = new HashMap();
	
	public Sensor getById(String id) {
		return (Sensor) sensors.get(id);
	}
	
	
	/*
	 * 경계 인터페이스인 Map을 Sensor 안으로 숨긴다.
	 * 따라서 Map 인터페이스가 변하더라도 나머지 프로그램에는 영향을 미치지 않는다.
	 * 제네릭스를 사용하든 하지 않든 더이상 문제가 안된다.
	 * Sensors 클래스 안에서 객체 유형을 관리하고 변환하기 때문이다.
	 * 또한 Sensors 클래스는 프로그램에 필요한 인터페이스만 제공한다.
	 * 그래서 코드는 이해하기는 쉽지만 오용하기는 어렵다.
	 * Sensors 클래스는 나머지 프로그램이 설계규칙과 비지니스 규칙을 따르도록 강제할 수 있다.
	 * */
}
