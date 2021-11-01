package model;

public class Floor {
	private int maxSqft = 0;
	private int usedSqft = 0;
	private String status = "";
	private Unit [] unit= new Unit[0];
	

	public Floor(int maxSqft) {
		this.maxSqft=maxSqft;
	
	}

	public Floor(Floor floor) {
		this.unit=floor.unit;
		this.maxSqft=floor.maxSqft;
		this.usedSqft=floor.usedSqft;

	}

	public String toString() {
		
		String tempStatus="";
		for(int i=0; i <unit.length;i++) {
			tempStatus+=unit[i].getRoom()+": "+unit[i].getSqft()+" sq ft ("+unit[i].getWidth()+"' by "+unit[i].getLength()+"')";
			if(i<unit.length-1) {
				tempStatus+=", ";
			}
		}
		status="Floor's utilized space is "+usedSqft+" sq ft ("+(this.maxSqft-this.usedSqft)+" sq ft remaining): ["+tempStatus+"]";
				//[Master Bedroom: 144 sq ft (18' by 8'), Office: 126 sq ft (18' by 7')]"
		return status;
	}

	public void addUnit(String room, int width, int length) throws InsufficientFloorSpaceException{
		Unit u1 = new Unit(room,width,length);
		
		if(this.usedSqft+u1.getSqft()<=this.maxSqft&&this.unit.length<21) {
		
		if(unit.length==0) {
		unit= new Unit[1];
		unit[0]=u1;
		this.usedSqft+=u1.getSqft();
		}
		else {
		Unit []temp=unit;
		 unit = new Unit[unit.length+1];
		 
		 for(int i=0; i <temp.length;i++) {
			 unit[i]=temp[i];
		 }
		 unit[unit.length-1]=u1;
		 this.usedSqft+=u1.getSqft();
		
		}
		
	}else {
		throw new InsufficientFloorSpaceException("");
	}
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		Floor other = (Floor) obj;
		boolean equal = false;
		
		if(this.maxSqft==other.maxSqft&&this.unit.length==0&&other.unit.length==0) {
			return true;
		}
		
		if(this.unit.length!=other.unit.length) {
			return false;
		}
		else if(this.maxSqft==other.maxSqft) {
			if(this.unit.length==other.unit.length) {
				for(int i =0;i<this.unit.length;i++) {
					for(int j =0; j<this.unit.length;j++) {
						if(this.unit[i].equals(other.unit[j])) {
							equal=true;
							break;
						}else {equal=false;
						
						}
						
					}
					if(equal==false) {
						return false;
					}
				}
			}
			
		}
		//if(this.room.equals(other.room)&&this.getSqft()==other.getSqft()) {
			//equal = true;
			
			//} 
		
		return equal;
	}
}
