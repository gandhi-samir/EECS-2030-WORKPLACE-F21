package model;

public class Follower {


	private int nOC = 0;
	private Channel[] channel = new Channel[1000];
	private Channel[] channelArrayList = new Channel[0];

	public Follower() {

	}

	public void addChannel(Channel ch1, int maxChannels) {
		//Channel c1 = new Channel(ch1);
		channel[nOC] = ch1;
		nOC++;

		channelArrayList = new Channel[maxChannels];
		for (int i = 0; i < nOC; i++) {
			channelArrayList[i] = channel[i];
		}
	}

	public void removeChannel(Channel ch1, int maxChannels) {

		int index = 0;
		for (int i = 0; i < nOC; i++) {
			if (channel[i].getName().equals(ch1.getName())) {

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

	}

	public Channel[] getChannels() {
		return channelArrayList;
	}

	public int getNOC() {
		return nOC;
	}

	public void updateWatch(String videoName, int time) {

	}

	public void watch(String videoName, int watchTime) {

		for(int i =0; i <channelArrayList.length;i++) {
	
			if(channelArrayList[i]!=null) {
				
				for(int j =0;j<channelArrayList[i].getVideos().length;j++) {
			
					if(channelArrayList[i].getVideos()[j]!=null) {
					
						if(channelArrayList[i].getVideos()[j].equals(videoName)) {
							
							for(int k=0; k <channelArrayList[i].getFollower().length;k++) {
							if(channelArrayList[i].getFollower()[k]  instanceof Monitor) {
								for(int l =0; l <channelArrayList[i].getFollower()[k].getChannels().length;l++) {
									if(channelArrayList[i].getFollower()[k].getChannels()[l]!=null) {
									if(channelArrayList[i].getFollower()[k].getChannels()[l].getName().equals(channelArrayList[i].getName())) {
										channelArrayList[i].getFollower()[k].getChannels()[l].updateStats(watchTime);
									}
								}
								}
							}
					
							}	
							
						}
					}
				}
			}
		
	}
}
	
	public int getViews(int i) {
		return channelArrayList[i].getViews();
	}
}
