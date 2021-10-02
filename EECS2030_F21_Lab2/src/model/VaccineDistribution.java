package model;

public class VaccineDistribution {
	private Vaccine vaccineName;
	private int doesAvail=0;
	private String status="";

	public VaccineDistribution(Vaccine vaccineName, int dosesAvail) {
		this.vaccineName=vaccineName;
		this.doesAvail=dosesAvail;
		status=dosesAvail+" doses of "+vaccineName.getCodeName()+" by "+vaccineName.getManufacturer();
	}
	public String toString() {
		return status;
	}
	
	public int getDoses() {
		return this.doesAvail;
	}
	
	public String getCode() {
		return vaccineName.getCodeName();
	}
	
	public String getManufacturer() {
		return vaccineName.getManufacturer();
	}
	
	public void addDose(int doses) {
		doesAvail+=doses;
	}
	public void remDose() {
		doesAvail=doesAvail-1;
	}
	
	public Vaccine getVaccine() {
		return vaccineName;
	}
}
