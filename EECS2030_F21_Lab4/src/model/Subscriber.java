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
		String followList="";
		if(getChannels().length>0) {
		
		
		for(int i =0; i <getChannels().length;i++) {

	if(getChannels()[i]!=null) {
			followList+=getChannels()[i].getName();
			
			if(i<getChannels().length-1&&getChannels()[i+1]!=null) {
				
				followList+=", ";
			}
		}
		}
		}

		if (getNOC() > 0 && nOR == 0) {
			status = "Subscriber " + this.name + " follows [" + followList + "] and has no recommended videos.";
		}
		if (getNOC() == 0 && nOR == 0) {
			status = "Subscriber " + this.name + " follows no channels and has no recommended videos.";
		}
		if (getNOC() > 0 && nOR > 0) {
			status = "Subscriber " + this.name + " follows [" + followList + "] and is recommended <"
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
		removeChannel(ch1, maxChannels);

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
			if (j+1!=nOR&&reccomendationsArrayList[j + 1] != null) {
				reccomendationList += ", ";
			}
		}

	}


}
