package designPattern.headFirst.chapter02_Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	
	private float temperature;
	private float humidity;
	private WeatherData weatherData;
	
	public CurrentConditionsDisplay(WeatherData weatherdata) {
		this.weatherData = weatherdata;
		weatherData.registerObserver(this);
	}
	
	public void display() {
		System.out.println("현재 상태: 온도 : " +temperature+"F, 습도 "+humidity +"%");
	}

	public void update() {
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
	}

}
