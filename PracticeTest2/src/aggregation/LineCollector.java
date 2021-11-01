package aggregation;



public class LineCollector {
	
	private Line []line=new Line[0];
	

	public LineCollector(LineCollector lc1) {
		this.line=lc1.line;
	}

	public LineCollector() {
		// TODO Auto-generated constructor stub
	}

	public void addLine(Line l1) {
	
		
		if(line.length==0) {
			line = new Line[1];
			line[0]=l1;
		}
		
		else {
			Line []temp = line;
			line = new Line[line.length+1];
			
			for(int i =0; i <temp.length;i++) {
				line[i]=temp[i];
			}
			
			line[line.length-1]=l1;
		}
		
	}

	public Line getLineAt(int i) {
		
		return line[i];
	}

	public Line[] getLines() {
		// TODO Auto-generated method stub
		return line;
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		LineCollector other = (LineCollector) obj;
		boolean equal = false;
		
		if(this.line.length!=other.line.length) {
			return false;
			
		}
		if(this.line.equals(other.line)) {
			equal = true;
			
			} 
		
		return equal;
	}

}
