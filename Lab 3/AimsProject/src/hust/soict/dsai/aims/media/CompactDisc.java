package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, float cost, String director, int length, String artist, List<Track> tracks) {
		super(title, category, cost, director,length);
		this.artist = artist;
		this.tracks = tracks;
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
}