package model;

public class Subscriber extends Follower {
	private String name = "";
	private String status = "";
	private int maxChannels;
	private int maxReccomendations;
	private String type = "Subscriber";

	private String reccomendationList = "";
	private String[] reccomendations = new String[1000];
	private String[] reccomendationsArrayList = new String[0];

	


	private int nOR = 0;

	public Subscriber(String name, int maxChannels, int maxReccomendations) {
		this.name = name;
		this.maxChannels = maxChannels;
		this.maxReccomendations = maxReccomendations;

	}

	public String toString() {

		if (getNOC() > 0 && nOR == 0) {
			status = "Subscriber " + this.name + " follows [" + getFollowList() + "] and has no recommended videos.";
		}
		if (getNOC() == 0 && nOR == 0) {
			status = "Subscriber " + this.name + " follows no channels and has no recommended videos.";
		}
		if (getNOC() > 0 && nOR > 0) {
			status = "Subscriber " + this.name + " follows [" + getFollowList() + "] and is recommended <"
					+ reccomendationList + ">.";
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

	public void addReccomended(String videoName) {
		reccomendations[nOR] = videoName;
		nOR++;
		reccomendationsArrayList = new String[maxReccomendations];

		for (int i = 0; i < nOR; i++) {
			reccomendationsArrayList[i] = reccomendations[i];

		}

		reccomendationList = "";

		for (int j = 0; j < nOR; j++) {
			reccomendationList += reccomendationsArrayList[j];
			if (reccomendationsArrayList[j + 1] != null&&j+1!=nOR) {
				reccomendationList += ", ";
			}
		}

	}

	public void watch(String videoName, int watchTime) {
		updateWatch(videoName,watchTime);
		
		
		
	}
}
