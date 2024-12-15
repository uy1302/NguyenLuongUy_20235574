package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, float cost, String director, int length, String artist, List<Track> tracks) {
		super(title, category, cost, director,length);
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(String title, String category, String director, int length, float cost) {
		// TODO Auto-generated constructor stub
		super(title,category,cost,director,length);
	}
	public CompactDisc(String title) {
		// TODO Auto-generated constructor stub
		super(title);
	}
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track newtrack) {
		boolean valid = false;
		for (Track track: tracks) {
			if (track.equals(newtrack)) {
				valid = true;
			}
		}
		if (valid == false) {
			tracks.add(newtrack);
		}
	}
	public void removeTrack(Track deltrack) {
		boolean valid = false;
		for (Track track: tracks) {
			if (track.equals(deltrack)) {
				valid = true;
			}
		}
		if (valid == true) {
			tracks.remove(deltrack);
		}
	}
	public int getLength() {
		int sum = 0;
		for(Track track:tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("This CD cannot be played.");
		}else {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			for (Track track: tracks) {
				track.play();
			}
		}
	}
	
	@Override
	public String toString() {
		String string = this.getId() + "." + "CD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getArtist() + " - " + this.getLength() + ": " + this.getCost();
		return string;
	}
	public Track[] getTracks() {
		// TODO Auto-generated method stub
		return null;
	}
	
}