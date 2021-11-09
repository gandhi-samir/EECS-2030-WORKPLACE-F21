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
		if (getNOC() > 0) {
			status = "Monitor " + this.name + " follows [" + getFollowList() + "].";
		}
		if (getNOC() == 0) {
			status = "Monitor " + this.name + " follows no channels.";
		}
		return this.status;
	}

	public void addChannel(Channel ch1) {
		addChannel(ch1, maxChannels);

	}

	public String getType() {
		return type;
	}

	public String getName() {
		return this.name;
	}

	public void removeChannel(Channel ch1) {
		removeChannel1(ch1, maxChannels);

	}

}
