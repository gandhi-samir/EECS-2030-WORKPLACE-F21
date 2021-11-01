package composition;



public class Line {
	Point p1;
	Point p2;

	public Line(Point p1, Point p2) {
		this.p1=p1;
		this.p2=p2;
	}

	public Line(Line l1) {
		this.p1=l1.p1;
		this.p2=l1.p2;
	}

	public Point getStart() {
		Point p5=new Point(this.p1);
		return p5;
	}

	public Point getEnd() {
		Point p6=new Point(this.p2);
		return p6;
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		Line other = (Line) obj;
		boolean equal = false;
		if(this.p1.equals(other.p1)&&this.p2.equals(other.p2)) {
			equal = true;
			
			} 
		
		return equal;
	}
	
	

}
