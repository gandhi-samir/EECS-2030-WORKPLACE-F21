package model;

public class Assessment {
	private String assignmentName="";
	private double weight=0;
	private int mark=0;
	private String status="";
	private int newMark=0;
	private double newWeight=0;

	public Assessment(String assignmentName, double weight) {
	this.assignmentName=assignmentName;
	this.weight=weight;
	
	this.weight=this.weight*100;
	status="Assessment created: "+this.assignmentName+" accounts for "+String.format("%.3f", this.weight)+" percents of the course.";
	}

	public void setMarks(int mark) {
		if(mark<=100) {
		this.newMark=mark;
		status="Marks of assessment "+this.assignmentName+" (accounting for "+String.format("%.3f", this.weight)+" percents of the course) is changed from "+this.mark+" to "+this.newMark+".";
	this.mark=this.newMark;
	
	}
	}


	public void setWeight(double weight) {
		this.newWeight=weight*100;
		status="Weight of assessment "+assignmentName+" (with marks "+this.mark+") is changed from "+String.format("%.3f", this.weight)+" percents to "+String.format("%.3f", this.newWeight)+" percents.";
		this.weight=this.newWeight;
		
		
		
		
		
		
	}
	
	public String toString() {
		return status;
	}
	
	public String getAssignment() {
		return this.assignmentName;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public int getMarks() {
		return this.mark;
	}

}
