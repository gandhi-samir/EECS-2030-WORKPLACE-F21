package composition;



public class Point {
	int x;
	int y;
	

	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public Point(Point p3) {
	this.x=p3.x;
	this.y=p3.y;
	}

	
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		Point other = (Point) obj;
		boolean equal = false;
		if(this.x==other.x&&this.y==other.y) {
			equal = true;
			
			} 
		
		return equal;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return  this.x;
	}

	public void setX(int i) {
		this.x=i;
		
	}
}
