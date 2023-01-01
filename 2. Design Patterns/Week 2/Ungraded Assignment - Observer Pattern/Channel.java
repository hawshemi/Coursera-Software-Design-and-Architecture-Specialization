
// By https://hawshemi.com on 01-Jan-2022


public class Channel implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String channelName;
	private String status;

	public Channel(String channelName, String status) {
		this.channelName = channelName;
		this.status = status;
	}
	
	public String getChannelName() {
		return channelName;
	}
	
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	public string getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		notifyObservers();
	}

	public void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(this.status);
		}
	}
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
}
