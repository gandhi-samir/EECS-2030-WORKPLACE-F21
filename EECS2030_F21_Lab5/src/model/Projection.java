package model;

public class Projection extends BinarySeqOperation {
	protected int projectedSequence[] = new int[0];
	private int seq1[];
	private int seq2[];

	public Projection(int[] seq1a, int[] seq2) {
		this.seq1 = seq1a;
		this.seq2 = seq2;

		if (seq1.length == 0 && seq2.length == 0) {

		}

		else if (seq1.length > 0 && seq2.length == 0) {

		} else {

			for (int j = 0; j < seq2.length; j++) {
				for (int i = 0; i < seq1a.length; i++) {
					if (seq1a[i] == seq2[j]) {
						int temp[] = projectedSequence;
						projectedSequence = new int[projectedSequence.length + 1];
						for (int k = 0; k < temp.length; k++) {
							projectedSequence[k] = temp[k];
						}
						projectedSequence[projectedSequence.length - 1] = seq2[j];
						break;
					}

				}
			}

		}
	}

	public String toString() {
		// Projecting [1, 3, 5] to [2, 1, 6, 3, 1, 4, 5, 3] results in: [1, 3, 1, 5, 3]

		String status = "Projecting " + arrayString1(seq1) + " to " + arrayString1(seq2) + " results in: "
				+ arrayString1(projectedSequence);

		return status;

	}

}
