package model;



public class Vaccine {
	private String codeName="";
	private String type="";
	private String manufacturer="";
	private String status="";
	
	private boolean reconizedVaccine=false;

	public Vaccine(String codeName, String type, String manufacturer) {
		this.codeName=codeName;
		this.type=type;
		this.manufacturer=manufacturer;
		
		if(this.manufacturer.equals("Moderna")||this.manufacturer.equals("Pfizer/BioNTech")||this.manufacturer.equals("Janssen")||this.manufacturer.equals("Oxford/AstraZeneca")) {
			this.status="Recognized vaccine: "+this.codeName+" ("+this.type+"; "+this.manufacturer+")";
			this.reconizedVaccine=true;
		}
		else {
			this.status="Unrecognized vaccine: "+this.codeName+" ("+this.type+"; "+this.manufacturer+")";
	
		}
	}
	
	public String toString() {
		return this.status;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	public String getCodeName() {
		return this.codeName;
	}
	
	public boolean checkValid()
	{
		return reconizedVaccine;
		
	}
}
