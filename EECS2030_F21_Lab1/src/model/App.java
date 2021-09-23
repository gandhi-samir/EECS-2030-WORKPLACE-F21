package model;


public class App {
	
	String name="";
	int MaxNumberOfRatings=0;
	int numberOfRatings=0;
	Log  history[] = new Log[0];
	int [] ratings = {0,0,0,0,0};

	public App(String name, int MaxNumberOfRatings) {
		this.name=name;
		this.MaxNumberOfRatings=MaxNumberOfRatings;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getWhatIsNew() {
		String fixes="";
		if(history.length==0) {
			return"n/a";
		}
		else{
			if(history[history.length-1].getFixes()==null) {
				fixes="[]";
			}
			else {
				fixes= history[history.length-1].getFixes();
			}
		
		return "Version "+history[history.length-1].getVersion()+" contains "+history[history.length-1].getNumberOfFixes()+" fixes "+fixes;
	}
	}

	public Log[] getUpdateHistory() {
		
		return history;
	}

	public Log getVersionInfo(String inputVersion) {
		Log[] log2= new Log[1];
		
		if(history.length==0) {
			log2[0]=null;
		}
		else {
		
		for(int i =0; i <history.length;i++) {
			if(history[i].getVersion().equals(inputVersion)) {
				log2[0]=history[i];
				break;
			}
			else if(history[i].getVersion()!=(inputVersion)) {
				log2[0]=null;
			}
		
		}
		
		
			
	
	
	}
		return log2[0];	
	}

	public String getRatingReport() {
		
		String rating="";
		if(numberOfRatings==0) {
			rating="No ratings submitted so far!";
		}
		else {
			double average=((ratings[0]*1)+(ratings[1]*2)+(ratings[2]*3)+(ratings[3]*4)+(ratings[4]*5))/(double)numberOfRatings;
			rating = "Average of "+numberOfRatings+" ratings: "+String.format("%.1f", average)+" (Score 5: "+ratings[4]+", Score 4: "+ratings[3] +", Score 3: "+ratings[2]+", Score 2: "+ratings[1]+", Score 1: "+ratings[0]+")"; 
					//"Average of 1 ratings: 3.0 (Score 5: 0, Score 4: 0, Score 3: 1, Score 2: 0, Score 1: 0)"
		}
		return rating;
		
	}
	
	public String toString() {
		if(numberOfRatings==0) {
			
			return name+" (Current Version: "+getWhatIsNew()+"; Average Rating: n/a)";
		}
		else {
		
			double average=((ratings[0]*1)+(ratings[1]*2)+(ratings[2]*3)+(ratings[3]*4)+(ratings[4]*5))/(double)numberOfRatings;
		return name+" (Current Version: "+getWhatIsNew()+"; Average Rating: "+String.format("%.1f", average)+")";
	}
	}

	public void releaseUpdate(String version) {
		if(history.length<20) {
		Log log = new Log(version);
		
		Log[] temp = history;
		history = new Log[history.length+1];
		for(int i =0; i <temp.length;i++) {
			history[i] = temp[i];
		}
		history[history.length-1]=log;
		
	
		
	}
	}

	public void submitRating(int rate) {
		if(numberOfRatings<MaxNumberOfRatings) {
			if(ratings.length>=1) {
				ratings[rate-1]++;	
				numberOfRatings++;
	}
}
}
	
	
}