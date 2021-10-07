package model;

public class RegistrationSystem {

	Transcript t[] = new Transcript[0];

	public Transcript[] getReport() {
		// TODO Auto-generated method stub
		return t;
	}

	public void addTranscript(Transcript transcript) {
		if (t.length == 0) {

			t = new Transcript[t.length + 1];
			t[0] = transcript;

		}

		else {
			Transcript temp[] = t;
			t = new Transcript[t.length + 1];
			for (int i = 0; i < temp.length; i++) {
				t[i] = temp[i];
			}
			t[t.length - 1] = transcript;
		}
	}

	public int getMarks(String studentName, String className) {
		int marks = -1;
		if (t.length > 0) {

			for (int i = 0; i < t.length; i++) {

				if (t[i].getStudentName().equals(studentName)) {
					marks = t[i].getMarks(className);
					break;

				}

			}
		}
		return marks;
	}

}
