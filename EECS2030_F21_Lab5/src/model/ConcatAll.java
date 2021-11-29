package model;

public class ConcatAll extends SeqEvaluator {

	protected String[] operationsList = new String[0];
	protected int[] concat = new int[0];
	protected int count = 0;

	public ConcatAll(int i) {
		operationsList= new String[i];
	}

	

	public void concat(BinarySeqOperation binOp) {
		operationsList[count]=binOp.arrayString1(binOp.getResult());
		count++;
	
		int[] temp = concat;
		concat = new int[concat.length + binOp.getResult().length];

		for (int i = 0; i < temp.length; i++) {
			concat[i] = temp[i];
		}

		for (int k = 0; k < binOp.getResult().length; k++) {
			concat[temp.length + k] = binOp.getResult()[k];

		}

	}
	
	public String toString() {
		String status="";
		if(countIncompatible>0) {
			status="Concat cannot be evaluated due to "+countIncompatible+" incompatile operations.";
		}
		else {
			status="Concat(";
			//"Concat([1, 3, 1, 5, 3], [0, 1, 4, 9], []) = [1, 3, 1, 5, 3, 0, 1, 4, 9]"
		for(int i =0; i <operationsList.length;i++) {
			if(operationsList[i]==null) {
				break;
			}
			status+=operationsList[i];
			if(i+1!=operationsList.length&&operationsList[i+1]!=null) {
				status+=", ";
			}
		}
				
		status+=") = "+arrayString1(concat);
			
		}
	return status;
	}

}
