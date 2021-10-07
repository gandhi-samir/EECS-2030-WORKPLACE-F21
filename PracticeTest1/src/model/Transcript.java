package model;
import model.Registration;

public class Transcript {
	private String name="";
	private Registration r[]=new Registration[0];


	public Transcript(String name) {
		this.name=name;
	}

	public Registration[] getReport() {
		// TODO Auto-generated method stub
		return r;
	}

	public void addRegistration(Registration r1) {
		
		
	if(r.length==0) {
		 r = new Registration[1];
		r[0]=r1;
	}
	else {
		Registration temp[]=r;
		 r = new Registration[r.length+1];
		for(int i=0;i<temp.length;i++) {
			r[i]=temp[i];
		}
		r[r.length-1]=r1;
		
	}
		
		
		
		
		
		
		
	}
	
	public void addRegistration(String name, int credits) {
		Registration r1= new Registration(name,credits);
		addRegistration(r1);
		
	}

	public void addRegistrations(Registration[] registrations) {
		if(registrations.length>=1){
			for(int i=0; i <registrations.length;i++) {
				addRegistration(registrations[i]);
				
			}
		}
		
	}

	public int getMarks(String className) {
		int marks=-1;
		for(int i =0;i<r.length;i++) {
			if(r[i].getCourseName().equals(className)) {
				marks=r[i].getMarks();
				break;
			}
		}
		return marks;
	}

	public void setMarks(String className, int mark) {
		for(int i =0;i<r.length;i++) {
			if(r[i].getCourseName().equals(className)) {
				r[i].setMarks(mark);
				
			}
		}
		
	}

	public double getWeightedGPA() {
		double gpa=0;
		
		if(r.length>0) {
			for(int i =0; i <r.length;i++) {
				gpa+=r[i].getWeightedGradePoint();
			}
			gpa=gpa/r.length;
		}
		
		
		return gpa;
	}

	public String getStudentName() {
	
		return this.name;
	}

}
