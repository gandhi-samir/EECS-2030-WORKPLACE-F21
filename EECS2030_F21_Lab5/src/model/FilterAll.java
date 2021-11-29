package model;

public class FilterAll extends SeqEvaluator {
	protected String[] results = new String[0];

	protected int count = 0;

	public FilterAll(int i) {
		results = new String[i];
	}

	public void add(BinarySeqOperation binOp) {
		if (binOp.getResult()[0] == 1) {
			results[count] = "true";
			count++;
		}
		if (binOp.getResult()[0] == 0) {
			results[count] = "_";
			count++;
		}

	}

	public String toString() {
		String status = "Filter result is: ";
		// "Filter result is: true, _, true"

		if (countIncompatible > 0) {
			status = "Filter cannot be evaluated due to " + countIncompatible + " incompatile operations.";
		} else {
			for (int i = 0; i < results.length; i++) {
				if (results[i] == null) {
					break;
				}
				status += results[i];

				if (results[i + 1] != null && i + 1 != results.length) {
					status += ", ";
				}
			}
		}
		return status;
	}

}
