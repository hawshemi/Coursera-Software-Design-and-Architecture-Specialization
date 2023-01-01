
// By https://hawshemi.com on 01-Jan-2022


public class Follower implements Observer {

	private String followerName;

	public Follower(String followerName) {
		this.followerName = followerName;
	}

	public String getFollowerName() {
		return followerName;
	}

	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}

	public void update(String status) {
		//send message to followers that Channel is live.
	}
	
	public void play() {
		//play channel
	}

}
