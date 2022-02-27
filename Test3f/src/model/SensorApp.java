package model;

public class SensorApp extends WeatherApp {



	public SensorApp(String string, int i) {
		this.name=string;
		this.max=i;
		this.station = new WeatherStation[i];
	}

	public void updateMeasurements(String station , int temp , int pressure) {
	
		
		for(int i =0; i <this.station.length;i++) {
			if(this.station[i]!=null) {
			if (this.station[i].name.equals(station)) {
if(this.station[i].prevpressure==0) {
					
				}
				else {
					this.station[i].prevpressure=this.station[i].pressure;
				}
				this.station[i].pressure=pressure;
				this.station[i].temprature=temp;
				if(this.station[i].temprature<temp) {
					this.station[i].maxtemprature=temp;
				
				
			}
			
		}}
		
	}
	
	


}

	public String[] getConnectedForcastersOf(String string) {
		String [] s = new String [0];
		return s;
	}
}
