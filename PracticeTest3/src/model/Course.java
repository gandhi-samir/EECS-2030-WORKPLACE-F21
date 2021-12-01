package model;

public class Course {
	
	protected double fee=0;
	private String name="";

	public Course(String string, double d) {
		this.fee=d;
		this.name=string;
	}

	public double getFee() {
		// TODO Auto-generated method stub
		return fee;
	}
	
	public String getName() {
		return name;
	}

}
