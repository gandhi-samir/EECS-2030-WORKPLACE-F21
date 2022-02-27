package model;



public class WeatherStation {
protected String status="";
protected String name="";
protected int maxApps=0;
protected WeatherApp[] appList = new WeatherApp[0];
protected WeatherApp[] temp = new WeatherApp[0];
protected int count=0;
protected int temprature=0;
protected int maxtemprature=0;
protected int pressure=0;
protected int prevpressure=0;
SensorApp[] sensors = new SensorApp[0];


	public WeatherStation(String name, int max) {
		this.maxApps=max;
		this.name=name;
		appList = new WeatherApp[max];
	}
	
	

	public void connect(WeatherApp app1) {
		appList[count]=app1;
		count++;
		app1.add(this);
	
		WeatherApp [] temp2 = temp;
		temp = new WeatherApp[temp.length+1];
		
		for(int i =0; i <temp2.length;i++) {
			temp[i]=temp2[i];
			
		}
		
		if(app1 instanceof SensorApp) {
			
			SensorApp[] sensorTemp = sensors;
			sensors= new SensorApp[sensors.length+1];
			
			for(int j=0; j <sensorTemp.length;j++) {
				sensors[j]=sensorTemp[j];
			}
			sensors[sensors.length-1]=(SensorApp) app1;
			
		}
		
		
	}
	
	
	public String toString() {
	//"Station@NorthYork is connected by 1 apps: <Weather Sensor App Sensor1234>."
		status="";

		if(temp.length==0) {
			status=name+" has no connected apps.";
		}
		
		if(temp.length>0) {
			status="";
					
		status+=name+" is connected by "+count+" apps: <";
		
			for(int i =0;i <appList.length;i++) {
				if(appList[i]!=null) {
					
					if(appList[i] instanceof SensorApp) {
						status+="Weather Sensor App ";
					}
					if(appList[i] instanceof ForecastApp) {
						status+="Weather Forecast App ";
					}
				status+=appList[i].name;
				
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



	public SensorApp[] getSensors() {
		

	
		return sensors;
	}

}
