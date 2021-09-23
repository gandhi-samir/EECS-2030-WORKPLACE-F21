package model;

public class Log {
	
	String version="";
	
	String [] logFixes = new String[0];
	public Log(String version) {
		this.version=version;
	}

	public String getVersion() {
		return version;
	}

	public int getNumberOfFixes() {
		// TODO Auto-generated method stub
		return logFixes.length;
	}

	public String getFixes() {
		
		if(logFixes.length==0) {
			return "[]";
			}
		else {
		String fixes="[";
		for(int i =0; i <logFixes.length;i++) {
			if(i!=0) {
				fixes+=", ";
			}
			fixes+=logFixes[i];
			}
			
				fixes+="]";
				return fixes;
			}
		
		
	
	
	}
	
	public String toString() {
		
		return ("Version "+version+" contains "+logFixes.length+" fixes "+getFixes());
	}

	public void addFix(String fixDescription) {
		if(logFixes.length<10) {
		String [] temp = logFixes;
		logFixes = new String [temp.length+1];
		for(int i =0; i <temp.length;i++) {
			logFixes[i]=temp[i];
		}
		logFixes[logFixes.length-1]=fixDescription;
			}
		
	}
	
	public void updateVersion(String version) {
		this.version=version;
	}
	}



