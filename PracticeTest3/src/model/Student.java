package model;

public class Student extends StudentManagementSystem {

	protected Course[] courses = new Course[0];

	public Course[] getCourses() {
		// TODO Auto-generated method stub
		return courses;
	}

	public double getTuition() {
		double tuition = 0;

		for (int i = 0; i < courses.length; i++) {
			if (courses[i] != null) {

				if (this instanceof ResidentStudent) {

					tuition += courses[i].getFee() * ((ResidentStudent) this).rate;
				}

				if (this instanceof NonResidentStudent) {

					tuition += courses[i].getFee() * ((NonResidentStudent) this).rate;
				}
			}
		}
		return tuition;

	}

	public void register(Course e) {
		Course[] temp = courses;

		courses = new Course[courses.length + 1];

		for (int i = 0; i < temp.length; i++) {
			courses[i] = temp[i];

		}

		courses[temp.length] = e;

	}

	public void drop(Course e) {
		int index = 0;
		boolean found = false;
		for (int i = 0; i < courses.length; i++) {
			if (courses[i].getName().equals(e.getName())) {

				index = i;
				found = true;

				break;
			}
		}

			if (found) {
				Course[] temp = courses;
				courses = new Course[courses.length - 1];

				for (int j = 0; j < index; j++) {
					courses[j] = temp[j];
				}

				for (int k = 1 + index; k < temp.length; k++) {
					courses[k - 1] = temp[k];
				}
			}
		
	}

}
