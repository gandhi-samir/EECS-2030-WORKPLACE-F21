package model;

public class Registration {
private String name="";
private int marks=0;
private int credits=0;

	public Registration(String name, int credits, int marks) {
		this.name=name;
		this.marks=marks;
		this.credits=credits;
	}

	public Registration(String name, int credits) {
		this.name=name;
		this.credits=credits;
	}

	public String getCourseName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public double getNumberOfCredits() {
		// TODO Auto-generated method stub
		return this.credits;
	}

	public int getMarks() {
		// TODO Auto-generated method stub
		return this.marks;
	}

	public void setMarks(int marks) {
	this.marks=marks;
		
	}

	public String getLetterGrade() {
		/* Here is the map from numerical raw marks to string letter grades:
		 * Marks >= 90			: "A+"
		 * 80 <= Marks <  90	: "A"
		 * 70 <= Marks <  80	: "B"
		 * 60 <= Marks <  70	: "C"
		 * 50 <= Marks <  60	: "D"
		 * Marks < 50			: "F"
		 */
		
		String letter="";
		if(this.marks>=90) {
			letter="A+";
		}
		else if(this.marks<90&&this.marks>=80) {
			letter="A";
		}
		else if(this.marks<80&&this.marks>=70) {
			letter="B";
		}
		else if(this.marks<70&&this.marks>=60) {
			letter="C";
		}
		else if (this.marks<60&&this.marks>=50) {
			letter="D";
		}
		else {
			letter="F";
		}
		return letter;
	}

	public int getWeightedGradePoint() {
		/*
		 * Weighted Grade Point: grade point * number of credits.
		 * Here is the map from string letter grades to numerical grade points:
		 * "A+"	: 9
		 * "A"	: 8
		 * "B"	: 7
		 * "C" 	: 6
		 * "D"	: 5
		 * "F"	: 0
		 * For example, for r1 with letter grade B (and hence grade point 7) and 3 credits, 
		 * its weighted grade point is 7 * 3. 
		 */
		
	String letter = getLetterGrade();
	int gp=0;
	
	if(letter.equals("A+")) {
		gp=9*this.credits;
		
	}
	else if(letter.equals("A")) {
		gp=8*this.credits;
	}
	else if(letter.equals("B")) {
		gp=7*this.credits;
		
	}
	else if(letter.equals("C")) {
		gp=6*this.credits;
	}
	else if(letter.equals("D")) {
		gp=5*this.credits;
	}
	else {
		gp=0*this.credits;
	}
	
		return gp;
	}

}
