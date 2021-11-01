package model;

public class Blueprint {
	private int floors = 0;
	private int floorsUsed = 0;
	private String status = "";
	private Floor[] floor = new Floor[0];
	double percent=getPercentUsed();

	public Blueprint(int floors) {
		this.floors = floors;

	}

	public Blueprint(Blueprint bp1) {
		this.floor=bp1.floor;
		
	this.floor=bp1.floor;
	this.floors=bp1.floors;
	this.percent=bp1.percent;
	
	
	bp1.floor=new Floor[0];
	for(int i =0;i<this.floor.length;i++) {
		Floor f=new Floor(this.floor[i]);
		bp1.addFloorPlan(f);
	}

	
	
	
	}
		
	

	public String toString() {
		status = String.format("%.1f", getPercentUsed()) + " percents of building blueprint completed ("
				+ this.floor.length + " out of " + this.floors + " floors)";
		// "0.0 percents of building blueprint completed (0 out of 7 floors)"
		return status;
	}

	public double getPercentUsed() {
		return ((double)this.floor.length / this.floors)*100;

	}

	public void addFloorPlan(Floor f1) {

		if (floor.length == 0) {
			floor = new Floor[1];
			floor[0] = f1;
			
			
		} else {
			Floor []temp=this.floor;
			 floor = new Floor[floor.length+1];
			 
			 for(int i=0; i <temp.length;i++) {
				 floor[i]=temp[i];
			 }
			 floor[floor.length-1]=f1;
			 
			
			}
		

	}

	public Floor[] getFloors() {
		for(int i =0;i<floor.length;i++) {
			Floor f=new Floor(floor[i]);
			floor[i]=f;
		}
		return floor;
	}
	
	

}
