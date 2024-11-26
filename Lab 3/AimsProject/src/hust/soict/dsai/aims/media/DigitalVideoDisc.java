package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{
	private int id;
	private static int nbDigitalVideoDiscs = 0; 
	
	public DigitalVideoDisc(String title) {
		super(title);
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs ++;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, int cost) {
		super(title, category, length , director, cost);
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs ++;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs ++;
	}

	public int getnb() {
		return nbDigitalVideoDiscs;
	}
	public String toString() {
		String str = this.id + ". " + "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost();
		return str;
	}
	public boolean isMatch(String title) {
		return this.getTitle() == title;
	}
	public boolean isMatch(int Id) {
		return this.id == Id;
	}
}
