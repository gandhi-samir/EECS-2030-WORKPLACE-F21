package model;

public class SeqOperation {

	public String arrayString1(int[] seq1) {
		String seq1string = "[";

		for (int i = 0; i < seq1.length; i++) {
			seq1string += seq1[i];

			if (i + 1 != seq1.length) {
				seq1string += ", ";
			}
		}
		seq1string += "]";

		return seq1string;

	}
	
	

}
