package model;

public class Follower {

private String followList="";

private int nOC=0;
private Channel[] channel = new Channel[1000];
Channel[] channelArrayList = new Channel[0];


public Follower(){
	
}

public void addChannel(Channel ch1, int maxChannels) {
	channel[nOC] = ch1;
	nOC++;

	channelArrayList = new Channel[maxChannels];
	for (int i = 0; i < nOC; i++) {
		channelArrayList[i] = channel[i];
	}
	followList = "";
	
	

	for (int j = 0; j < nOC; j++) {
		followList += channelArrayList[j].getName();
		if(this instanceof Monitor) {
			
			if(channelArrayList[j].getViews()>0) {
				followList+=" {#views: "+channelArrayList[j].getViews()+", max watch time: "+channelArrayList[j].getMaxTime()+", avg watch time: "+String.format("%.2f", channelArrayList[j].getTime())+"}";
			}
		}
		
		if (channelArrayList[j + 1] != null&&j+1!=nOC) {
			
			
			followList += ", ";
		}
	}
}


public void removeChannel1(Channel ch1, int maxChannels) {
	boolean isFollowing = false;
	
	int index = 0;
	for (int i = 0; i < nOC; i++) {
		if (channel[i] == ch1) {
			isFollowing = true;
			index = i;
			break;
		}
	}

		channelArrayList = new Channel[maxChannels];

		for (int j = 0; j < index; j++) {
			channelArrayList[j] = channel[j];

		}

		for (int k = index + 1; k < nOC; k++) {
			channelArrayList[k - 1] = channel[k];
		}
		nOC--;

		followList = "";

		for (int j = 0; j < nOC; j++) {
			followList += channelArrayList[j].getName();
			if (channelArrayList[j + 1] != null&&j+1!=nOC) {
				followList += ", ";
			}
		}
	
}

public String getFollowList() {
	return followList;
}

public int getNOC() {
	return nOC;
}

public void updateWatch(String videoName, int time) {
	for(int i =0; i <nOC;i++) {
		if(channelArrayList[i].getName().equals(videoName)){
			channelArrayList[i].updateStats(time);
			break;
			
		}
	}
}




}
