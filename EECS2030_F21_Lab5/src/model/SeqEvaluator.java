package model;

public class SeqEvaluator extends SeqOperation {


	protected int countIncompatible = 0;
	protected boolean setTrue = true;

	public void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException {

		if (operation != "op:occursWithin" && operation != "op:projection" && operation != "op:sumsOfPrefixes") {
			throw new IllegalOperationException();
		}

		if (operation.equals("op:occursWithin")) {
			if(this instanceof ConcatAll) {
			countIncompatible++;
	
			}
			if(this instanceof FilterAll) {
				BinarySeqOperation binOp = new OccursWithin(seq1, seq2);
				((FilterAll)this).add(binOp);
			}
		}

		if (operation.equals("op:projection") ) {

			
			if(this instanceof ConcatAll) {
			BinarySeqOperation binOp = new Projection(seq1, seq2);
			((ConcatAll)this).concat(binOp);

		}
			if(this instanceof FilterAll) {
				countIncompatible++;
			}
		}

		if (operation.equals("op:sumsOfPrefixes")) {
			if(this instanceof ConcatAll) {
			BinarySeqOperation binOp = new SumsOfPrefixes(seq1);
			((ConcatAll)this).concat(binOp);


		}
			if(this instanceof FilterAll) {
				countIncompatible++;
			}
		}

	}

	
	
	public String toString() {
		
		
		
		
	return null;
	
}
}
