package model;

public class ResidentStudent extends Student {

	protected double rate=0;
	
	private String name="";
	
	
	public ResidentStudent(String string) {
		this.name=string;
	}

	public void setPremiumRate(double d) {
		this.rate=d;
		
	}

	public double getPremiumRate() {
		// TODO Auto-generated method stub
		return rate;
	}

	
}
