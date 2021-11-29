package model;

public class OccursWithin extends BinarySeqOperation {
	private int[] seq1;
	private int[] seq2;

	protected boolean isTrue = false;

	public OccursWithin(int[] seq1a, int[] seq2) {
		this.seq1 = seq1a;
		this.seq2 = seq2;

		if (seq1a.length == 0 && seq2.length == 0) {
			isTrue = true;
		} else if (seq1a.length == 0 && seq2.length > 0) {
			isTrue = true;
		} else if (seq1a.length > seq2.length) {
			isTrue = false;

		} else {

			for (int i = 0; i < seq2.length; i++) {

				if (seq2[i] == seq1a[0]) {
					isTrue = true;
					if (i + seq1a.length <= seq2.length) {
						for (int j = 0; j < seq1a.length; j++) {
							if (seq2[i + j] == seq1a[j]) {
								isTrue = true & isTrue;
							} else {
								isTrue = false;
								break;
							}
						}
						break;

					}

				} else {
					isTrue = false;
				}

			}
		}

	}

	public String toString() {
		String status = "false";
//[1, 6, 1] does not occur within [2, 1, 6, 3, 1, 4, 5, 3]
		if (isTrue == true) {
			status = arrayString1(seq1) + " occurs within " + arrayString1(seq2);

		}

		else {
			status = arrayString1(seq1) + " does not occur within " + arrayString1(seq2);
		}
		return status;

	}

}
