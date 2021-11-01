package model;

public class Unit {
	private int dimensionWide = 0;
	private int dimensionLong = 0;
	private String room = "";
	private String status="";
	private double wideMeter=0;
	private double longMeter=0;
	private double squareMeters =0;
	public boolean conversion=false;
	

	public Unit(String room, int dimensionWide, int dimensionLong) {
		this.room = room;
		this.dimensionLong = dimensionLong;
		this.dimensionWide = dimensionWide;
		status="A unit of "+getSqft()+" square feet ("+this.dimensionWide+"' wide and "+this.dimensionLong+"' long) functioning as "+this.room;

	}

	public void toogleMeasurement() {
		
		this.squareMeters=(this.dimensionLong*0.3048)*(this.dimensionWide*0.3048);
		if(conversion == false) {
		status="A unit of "+String.format("%.2f",this.squareMeters)+" square meters ("+String.format("%.2f",getWideMeters())+" m wide and "+String.format("%.2f",getLongMeters())+" m long) functioning as "+this.room;
		conversion=true;
		}
		else if(conversion=true) {
		status="A unit of "+getSqft()+" square feet ("+this.dimensionWide+"' wide and "+this.dimensionLong+"' long) functioning as "+this.room;
		conversion=false;
		}
	}
	
	public String toString() {
		return status;
		
	}
	
	public int getSqft() {
		return this.dimensionLong*dimensionWide;
	}
	
	public double getWideMeters() {
		this.wideMeter=this.dimensionWide*0.3048;
		return this.wideMeter;
	}
	
	public double getLongMeters() {
		this.longMeter=this.dimensionLong*0.3048;
		return this.longMeter;
	}
	
	public String getRoom() {
		return this.room;
	}
	
	public int getWidth() {
		return this.dimensionWide;
	}
	
	public int getLength() {
		return this.dimensionLong;
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		Unit other = (Unit) obj;
		boolean equal = false;
		if(this.room.equals(other.room)&&this.getSqft()==other.getSqft()) {
			equal = true;
			
			} 
		
		return equal;
	}

}
 

