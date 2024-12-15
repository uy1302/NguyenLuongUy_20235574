package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category, float cost, List<String> authors) {
		super(title,category,cost);
		this.authors = authors;
	}
	
	public Book(String title, String category, float cost) {
		super(title,category,cost);
	}
	public List<String> getAuthors() {
		return authors;
	} 
	public void addAuthor(String authorName) {
		boolean valid = false;
		for (String author: authors) {
			if (authorName.equals(author)) {
				valid = true;
			}
		}
		if (valid == false) {
			authors.add(authorName);
		}
	}
	public void remove(String authorName) {
		boolean valid = false;
		for (String author: authors) {
			if (authorName.equals(author)) {
				valid = true;
			}
		}
		if (valid == true) {
			authors.remove(authorName);
		}
	}
	@Override
	public String toString() {
		String string = this.getId() + "." + "Book" + " - " + 
				 this.getTitle() + " - " + 
				 this.getCategory() + " - " +
				 this.getAuthors() + ": " +
				 this.getCost();
		return string;
	}
}
