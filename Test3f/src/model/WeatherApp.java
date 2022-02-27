package model;

public class WeatherApp {
	protected String status="";
	protected String name="";
	protected int max=0;
	protected WeatherStation [] station = new WeatherStation[0];
	protected int count=0;
	protected WeatherStation[] temp = new WeatherStation[0];
	
	
	
	
	
	public void add(WeatherStation w1) {
		
		station[count]=w1;
		count++;
		
		WeatherStation [] temp2 = temp;
		temp = new WeatherStation[temp.length+1];
		
		for(int i =0; i <temp2.length;i++) {
			temp[i]=temp2[i];
			
		}
		
		temp[temp.length-1]=w1;
		
	}
	
	public WeatherStation[] getStation()
	{
		
			
		
		return temp;
		
	}
	
public String toString() {
	status="";
	if(this instanceof SensorApp) {
		status+="Weather Sensor App ";
	}
	if(this instanceof ForecastApp) {
		status+="Weather Forecast App ";
	}
	
	
		if(station[0]==null) {
			status+=this.name+" is connected to no stations.";
		}
		
		if(this.temp.length>0) {
			status+=this.name+" is connected to "+count+" stations: <";
			
			
			for(int i =0; i <station.length;i++) {
				if(station[i]!=null) {
					status+=station[i].name;
					if(i+1!=temp.length) {
						status+=", ";
					}
				}
				else {
					break;
				}
				
				
			}
			status+=">.";
		}
		return status;
	}
	
}




