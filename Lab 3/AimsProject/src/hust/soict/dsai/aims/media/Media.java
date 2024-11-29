package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media implements Comparable<Media> {
	private int id;
	private String title;
	private String category;
	private float cost;
	private int nbMedia = 0;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media(String title) {
		this.title = title;
		this.nbMedia += 1;
		this.id = nbMedia;
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.nbMedia += 1;
		this.id = nbMedia;
	}
	
	public Media(String title, String category, float cost, int id) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public boolean isMatch(int id) {
		if(this.getId() == id) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isMatch(String title) {
		if(this.getTitle() == title) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		String string = this.getId() + "." + this.getTitle() + "-" + this.getCategory() + "-" + this.getCost();
		return string;
 	}
	public boolean equals(Media otherItem) {
		if (this.getTitle().equals(otherItem.getTitle())) {
			return true;
		}
		return false;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media other = (Media) obj;
        return this.getTitle().equals(other.getTitle());
    }

	
	@Override
	public int compareTo(Media other) {
	    int titleComparison = this.getTitle().compareToIgnoreCase(other.getTitle());
	    if (titleComparison != 0) {
	        return titleComparison;
	    }
	    return Double.compare(other.getCost(), this.getCost());
	}
}
