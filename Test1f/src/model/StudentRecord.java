package model;

public class StudentRecord {
	private String course="";
	private Assessment assessment[]=new Assessment[0];

	public StudentRecord(String course) {
		this.course=course;
	}

	public Object getCourse() {
		
		return this.course;
	}

	public String getAssessmentReport() {
		String report="";
		
		if(assessment.length==0) {
			report = "Number of assessments in "+this.course+": 0 []";
		}
		else {
			report="Number of assessments in "+this.course+": "+assessment.length+" [";
			
			for(int i =0; i <assessment.length;i++) {
				report+=assessment[i].getAssignment()+" (weight: "+String.format("%.3f", assessment[i].getWeight())+" percents; marks: "+assessment[i].getMarks()+")";
				if(i <assessment.length-1) {
					report+=", ";
				}
			}
			report+="]";
			
			
			//2 [Midterm 1 (weight: 15.379 percents; marks: 75), Midterm 2 (weight: 25.378 percents; marks: 80)]"
		}
				return report;
	}

	public double getCompletionRate() {
		double rate=0;
	if(assessment.length>=1) {
		for(int i =0; i <assessment.length;i++) {
			rate+=assessment[i].getWeight();
	
			
		}
		rate=rate/100;
	}
		return rate;
	}

	public double getRawMarks() {
		
		double raw=0;
		if(assessment.length>=1) {
			for(int i =0; i <assessment.length;i++) {
				raw+=assessment[i].getMarks()*(assessment[i].getWeight()/100);
			}
			}
		return raw;
	}

	public void addAssessment(String course, double weight, int mark) {
		Assessment a1= new Assessment(course,weight);
		a1.setMarks(mark);
		
		addAssessment(a1);
		
	}

	public void addAssessment(Assessment m1) {
		if(assessment.length<1) {
			assessment = new Assessment[1];
			assessment[0]=m1;
		}
		else if (assessment.length<11){
			Assessment temp []=assessment;
			assessment = new Assessment [assessment.length+1];
			
			for(int i =0; i <temp.length;i++) {
				assessment[i]=temp[i];
			}
			assessment[assessment.length-1]=m1;
			
		}
		
	}

	public void changeMarksOf(String className, int mark) {
		for(int i =0; i <assessment.length;i++) {
			if(assessment[i].getAssignment().equals(className)) {
				assessment[i].setMarks(mark);
				break;
			}
		}
		
	}

	public void removeAssessment(String className) {
		int index=-1;
		boolean isClass=false;
		for(int i =0; i <assessment.length;i++) {
			if(assessment[i].getAssignment().equals(className)) {
				index=i;
				isClass=true;
				break;
			}
			
			}
		
		if(isClass) {
		
		Assessment temp []= assessment;
		assessment= new Assessment[assessment.length-1];
		
		for(int j=0; j <index;j++) {
			assessment[j]=temp[j];
		}
		
		for(int k=index+1; k <temp.length;k++) {
			assessment[k-1]=temp[k];
		}
		
		
		
		}
		
		
	}

}
