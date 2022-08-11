package designPattern.headFirst.chapter02_Observer;

public class WeahterStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		HeatIndexDisplay heatDisplay = new HeatIndexDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		currentDisplay.display();
		heatDisplay.display();
		
		weatherData.setMeasurements(96, 70, 29.2f);
		currentDisplay.display();
		statisticsDisplay.display();  
	}
}
