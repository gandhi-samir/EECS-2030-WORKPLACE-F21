package model;

public class BinarySeqOperation extends SeqOperation {

	public int[] getResult() {
		int[] result = new int[0];
		if (this instanceof Projection) {
			result = ((Projection) this).projectedSequence;
		}
		if (this instanceof SumsOfPrefixes) {
			result = ((SumsOfPrefixes) this).result;
		}

		if (this instanceof OccursWithin) {
			result = new int[1];
			if (((OccursWithin) this).isTrue == true) {
				result[0] = 1;
			} else {
				result[0] = 0;
			}

		}
		return result;
	}

}
