package Structural.CompositePattern.Assignment;

import java.util.ArrayList;


// By https://hawshemi.com on 01-Jan-2023


public class Playlist implements IComponent {

	public String playlistName;
	public ArrayList<IComponent> playlist = new ArrayList();

	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}

	public void add(IComponent component) {
   		 playlist.add(component);
    }

	public void remove(IComponent component) {
		playlist.remove(component);
	}
	
	public void play(){
		for(IComponent component : playlist) {
			component.play();
	    	}
	}

	public void setPlaybackSpeed(float speed) {
	      for(IComponent component : this.playlist){
		component.setPlaybackSpeed(speed);
	    }
	}

	public String getName() {
	    return this.playlistName;
	}
}
