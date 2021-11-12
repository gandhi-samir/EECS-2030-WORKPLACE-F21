package model;

public class Monitor extends Follower {
	private String status = "";
	private String name = "";
	private int maxChannels;
	private Channel[] channel = new Channel[1000];
	Channel[] channelArrayList = new Channel[0];
	

	private int nOC = 0;
	private String type = "Monitor";
	private String followList = "";

	public Monitor(String name, int maxChannels) {
		this.name = name;
		this.maxChannels = maxChannels;

	}

	
	public String toString() {
		String followList="";
		if(getChannels().length>0) {
		
		
		for(int i =0; i <getChannels().length;i++) {
			if(getChannels()[i]!=null) {
			
	
			followList+=getChannels()[i].getName();
		
			if(getChannels()[i].getViews()>0) {
			
				followList +=" {#views: "+getChannels()[i].getViews()+", max watch time: "+getChannels()[i].getMaxTime()+", avg watch time: "+String.format("%.2f",getChannels()[i].getTime())+"}";
			}
			
			if(i<getChannels().length-1&&getChannels()[i+1]!=null) {
				followList+=", ";
			}
		}
		}
		}
		if (getNOC() > 0) {
			status = "Monitor " + this.name + " follows [" + followList + "].";
		}
		if (getNOC() == 0) {
			status = "Monitor " + this.name + " follows no channels.";
		}
		return this.status;
	}

	public void addChannel(Channel ch1) {	
Channel c1 = new Channel(ch1);
	
		addChannel(c1,maxChannels);

	}

	public String getType() {
		return type;
	}

	public String getName() {
		return this.name;
	}

	public void removeChannel(Channel ch1) {
		removeChannel(ch1, maxChannels);

	}
	

	public void watch(String videoName, int watchTime) {

	
		}
	
	

}
