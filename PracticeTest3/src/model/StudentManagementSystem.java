package model;

public class StudentManagementSystem {

	protected Student [] students= new Student [0];
	public Student [] getStudents() {
		// TODO Auto-generated method stub
		return students;
	}

	public void addStudent(Student s) {
		Student [] temp=students;
		students = new Student[students.length+1];
		
		for(int i =0; i <temp.length;i++) {
			students[i]=temp[i];
		}
		students[students.length-1]=s;
		
		
	}

	public void registerAll(Course e) {
for(Student s : students) {
	s.register(e);
	
}
		
	}

}
