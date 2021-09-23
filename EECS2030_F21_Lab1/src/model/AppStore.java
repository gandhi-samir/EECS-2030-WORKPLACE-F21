package model;

public class AppStore {
String branch="";
int maxApps=0;
int numOfApps=0;
App app[] = new App[0];
	public AppStore(String branch, int maxApps) {
		this.branch=branch;
		this.maxApps=maxApps;
	}

	public void addApp(App app1) {
		if(numOfApps<maxApps) {
			App temp[]=app;
			app=new App[app.length+1];
			for(int i =0; i<temp.length;i++) {
				app[i]=temp[i];
			}
			app[app.length-1]=app1;
				
		}
		
	}

	public String getBranch() {
		
		return branch;
	}

	public App getApp(String appName) {
		App temp[]= new App[1];
		if(app.length==0) {
			temp[0]=null;
		}
		else {
			for(int i =0; i <app.length;i++) {
				if(app[i].getName().equals(appName)) {
					temp[0]=app[i];
					break;
				}
				else if(app[i].getName()!=appName) {
					temp[0]=null;
				}
			}
		}
		
		return temp[0];
	}

	public String[] getStableApps(int updates) {
		String appStable[] = new String[0];
		for(int i=0;i<app.length;i++) {
			if(app[i].getUpdateHistory().length>=2) {
				if(appStable.length>=1) {
					String temp[]=appStable;
					appStable = new String[appStable.length+1];
					for(int j=0; j <temp.length;j++) {
						appStable[j]=temp[j];
					}
					appStable[appStable.length-1]=app[i].getName()+" ("+app[i].getUpdateHistory().length+" versions;"+" Current Version: "+app[i].getWhatIsNew()+")";
				}
				else {
					appStable= new String[1];
					appStable[0]=app[i].getName()+" ("+app[i].getUpdateHistory().length+" versions;"+" Current Version: "+app[i].getWhatIsNew()+")";
				}
				
			}
		}
		return appStable;
	}

}
