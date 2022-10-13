package cleanCode.chapter08;

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
}
