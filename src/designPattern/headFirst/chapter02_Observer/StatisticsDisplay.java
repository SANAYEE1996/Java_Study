package designPattern.headFirst.chapter02_Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	private WeatherData weatherData;

	public StatisticsDisplay(WeatherData weatherdata) {
		this.weatherData = weatherdata;
		weatherData.registerObserver(this);
	}

	public void update() {
		tempSum += weatherData.getTemperature();
		numReadings++;

		if (weatherData.getTemperature() > maxTemp) {
			maxTemp = weatherData.getTemperature();
		}
 
		if (weatherData.getTemperature() < minTemp) {
			minTemp = weatherData.getTemperature();
		}
	}

	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}
