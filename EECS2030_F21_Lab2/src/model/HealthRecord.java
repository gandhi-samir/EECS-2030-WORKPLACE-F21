package model;

public class HealthRecord {
	private String name="";
	private int maxDoses=0;
	private String location="";
	private String date="";
	Vaccine v1;
	private String status="";
	private String appStatus="";
	
private String[] vaccinationeciept=new String[0];

	public HealthRecord(String name, int maxDoses) {
	this.name=name;
	this.maxDoses=maxDoses;
	appStatus="No vaccination appointment for "+name+" yet";
	}

	public String getVaccinationReceipt() {
		if (vaccinationeciept.length==0) {
			this.status=this.name+" has not yet received any doses.";
		}
		else {
			this.status = "Number of doses "+this.name+" has received: "+vaccinationeciept.length+" [";
			for(int i =0; i< vaccinationeciept.length;i++) {
				this.status+=vaccinationeciept[i];
				if(i!=vaccinationeciept.length-1) {
					this.status+="; ";
				}
			}
			this.status+="]";
			
		}
		return this.status;
	}

	public String getAppointmentStatus() {
	
		return appStatus;
	}
	
	public void setAppointmentStatus(String location,String pass) {
		if(pass=="pass") {
		this.appStatus="Last vaccination appointment for "+name+" with "+location+" succeeded";
		}
		else {
			this.appStatus="Last vaccination appointment for "+name+" with "+location+" failed";
		}
	}

	public void addRecord(Vaccine v1, String location, String date) {
	this.v1=v1;
	this.date=date;
	this.location=location;
	
	
	
	
	if(vaccinationeciept.length==0) {
		vaccinationeciept=new String[1];
		vaccinationeciept[0]=""+v1.toString()+" in "+this.location+" on "+this.date;
			
	}
	else if(vaccinationeciept.length<this.maxDoses) {
		String[] temp=vaccinationeciept;
		vaccinationeciept=new String[vaccinationeciept.length+1];
		for(int i =0; i <temp.length;i++) {
			vaccinationeciept[i]=temp[i];
			
		}
		vaccinationeciept[vaccinationeciept.length-1]=""+v1.toString()+" in "+this.location+" on "+this.date;
	}
		
	}

}
