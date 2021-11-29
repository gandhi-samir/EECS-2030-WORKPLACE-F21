package model;

public class SumsOfPrefixes extends BinarySeqOperation {
	private int[] seq1;
	protected int[] result;
	private int count = 0;

	public SumsOfPrefixes(int[] seq1) {
		this.seq1 = seq1;

		
		
		if(seq1.length>0) {
		count++;
		int[] result = new int[seq1.length + 1];
		result[0] = 0;
		for (int i = 0; i < seq1.length; i++) {

			result[count] = result[count - 1] + seq1[i];
			count++;

		}
		this.result = result;
		}
		
		else {
			result = new int [0];
		}
	}

	public String toString() {

		String status = "Sums of prefixes of " + arrayString1(seq1) + " is: " + arrayString1(result);
		return status;

	}

}
