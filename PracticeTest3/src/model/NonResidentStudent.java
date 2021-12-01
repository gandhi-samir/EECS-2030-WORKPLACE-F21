package model;

public class NonResidentStudent extends Student {
	double rate=0;
	String name="";

	public NonResidentStudent(String string) {
		this.name=string;
	}

	public void setDiscountRate(double d) {
		this.rate=d;
		
	}

	public double getDiscountRate() {
		// TODO Auto-generated method stub
		return rate;
	}

}
