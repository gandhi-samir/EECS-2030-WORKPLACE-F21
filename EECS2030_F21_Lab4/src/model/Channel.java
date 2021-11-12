package model;

public class Channel {

	private String name = "";
	private int maxFollowers;
	private int maxVideos;
	private String status = "";
	private int nOF = 0;
	private int nOV = 0;
	private String[] videos = new String[10000];
	private Follower[] followers = new Follower[10000];
	private Follower[] followerArrayList = new Follower[0];
	private String[] videoListArray = new String[0];

	private String videoList = "";
	private String followerList = "";
	
	private int views=0;
	private int watchTime = 0;
	private int maxWatch=0;

	public Channel(String name, int maxFollowers, int maxVideos) {
		this.name = name;
		this.maxFollowers = maxFollowers;
		this.maxVideos = maxVideos;

	}
	
	public Channel(Channel c1) {
		this.name=c1.name;
		this.maxFollowers=c1.maxFollowers;
		this.maxVideos=c1.maxVideos;
		this.videoListArray=c1.videoListArray;
		this.followerArrayList=c1.followerArrayList;
		this.videos=c1.videos;
		this.views=c1.views;
		this.followerArrayList=c1.followerArrayList;
		

		
		
	
		
		
		
	}

	public void releaseANewVideo(String videoName) {
		this.videos[this.nOV] = videoName;
		this.nOV++;

		videoListArray = new String[this.maxVideos];

		for (int i = 0; i < this.nOV; i++) {
			videoListArray[i] = this.videos[i];
		
		}
		
		for(int j =0; j <nOF;j++) {
			if(followerArrayList[j] instanceof Subscriber) {
		((Subscriber)followerArrayList[j]).addReccomended(videoName);
		}
		}
		

		videoList = "";

		for (int i = 0; i < this.nOV; i++) {

			videoList += videoListArray[i];

			if (videoListArray[i + 1] != null) {
				videoList += ", ";
			}

		}

	}

	public String toString() {

		if (nOF == 0 && nOV == 0) {
			status = this.name + " released no videos and has no followers.";
		}
		if (nOF > 0 && nOV == 0) {
			status = this.name + " released no videos and is followed by [" + followerList + "].";
		}
		if (nOF == 0 && nOV > 0) {
			status = this.name + " released <" + videoList + "> and has no followers.";
		}
		if (nOF > 0 && nOV > 0) {
			status = this.name + " released <" + videoList + "> and is followed by [" + followerList + "].";
		}

		return status;

	}

	public void follow(Follower f1) {
		this.followers[nOF] = f1;
		nOF++;

		followerArrayList = new Follower[maxFollowers];

		for (int i = 0; i < this.nOF; i++) {
			followerArrayList[i] = this.followers[i];
		}
		if (f1 instanceof Subscriber) {
			((Subscriber) f1).addChannel(this);

		} else {
			((Monitor) f1).addChannel(this);

		}
		followerList = "";

		for (int i = 0; i < this.nOF; i++) {

			if (followerArrayList[i] instanceof Subscriber) {

				followerList += ((Subscriber) this.followerArrayList[i]).getType() + " "
						+ ((Subscriber) this.followerArrayList[i]).getName();
			} else {
				followerList += ((Monitor) this.followerArrayList[i]).getType() + " "
						+ ((Monitor) this.followerArrayList[i]).getName();
			}

			if (i+1!=nOF&&followerArrayList[i + 1] != null) {
				followerList += ", ";
			}

		}

	}

	public String getName() {
		return this.name;
	}

	public void unfollow(Follower f1) {
		boolean isFollowing=false;
		int index = 0;
		for (int i = 0; i < nOF; i++) {
			if (followers[i] == f1) {
				isFollowing=true;
				index = i;
				break;
			}

		}
		if(isFollowing) {
		
		followerArrayList = new Follower[maxFollowers];

		for (int j = 0; j < index; j++) {
			followerArrayList[j] = this.followers[j];
		}

		for (int k = index + 1; k < nOF; k++) {
			followerArrayList[k - 1] = this.followers[k];

		}
		nOF--;
		if (f1 instanceof Subscriber) {
			((Subscriber) f1).removeChannel(this);

		} else {
			((Monitor) f1).removeChannel(this);

		}
		followerList = "";

		for (int i = 0; i < this.nOF; i++) {

			if (followerArrayList[i] instanceof Subscriber) {

				followerList += ((Subscriber) this.followerArrayList[i]).getType() + " "
						+ ((Subscriber) this.followerArrayList[i]).getName();
			} else {
				followerList += ((Monitor) this.followerArrayList[i]).getType() + " "
						+ ((Monitor) this.followerArrayList[i]).getName();
			}

			if (i+1!=nOF&&followerArrayList[i + 1] != null) {
				followerList += ", ";
			}

		}

	}
	}
	
	public void updateStats(int time) {
		this.watchTime+=time;
		
		this.views++;
		
		if(time>this.maxWatch) {
			this.maxWatch=time;
		}
		
	}
	
	public double getTime() {
		return (double)this.watchTime/this.views;
		
	}
	public int getViews() {
		return this.views;
		
	}
	public int getMaxTime() {
		return this.maxWatch;
		
	}
	
	public String[] getVideos() {
		return videoListArray;
	}
	
	public int getNOV() {
		return this.nOV;
	}
	
	public Follower []getFollower() {
		return followerArrayList;
	}

}
