package composition;



public class LineCollector {
	Line [] line = new Line[0];

	public LineCollector(LineCollector lc1) {
		
		
		
		
		this.line=lc1.line;
		
		lc1.line = new Line[0];
		
		for(int i =0;i <line.length;i++) {
			Line l = new Line(line[i]);
			lc1.addLine(l);
		}
		
	}

	public LineCollector() {
		// TODO Auto-generated constructor stub
	}

	public void addLine(Line l1) {
		Line l2 = new Line(l1);
		
		if(line.length==0) {
			line = new Line[1];
			line[0]=l2;
			
		}else {
			Line []temp =line;
			line = new Line[line.length+1];
			
			for(int i =0; i <temp.length;i++) {
				line[i]=temp[i];
			}
			line[line.length-1]=l2;
		}
		
	}

	public Line getLineAt(int i) {
		// TODO Auto-generated method stub
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
		boolean equal = true;
		
		if(this.line.length!=other.line.length) {
			return false;
			
		}
		for(int i =0; i <line.length;i++) {
			
		if((this.line[i].p1!=other.line[i].p1)&&(this.line[i].p2!=other.line[i].p2)) {
			equal = false;
			break;
			
			} 
		
		
	}
		return equal;

}
}
