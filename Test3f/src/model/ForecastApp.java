package model;

public class ForecastApp extends WeatherApp {
	


	public ForecastApp(String string, int i) {
		this.name=string;
		this.max=i;
		this.station = new WeatherStation[i];
		
	}
	


}
