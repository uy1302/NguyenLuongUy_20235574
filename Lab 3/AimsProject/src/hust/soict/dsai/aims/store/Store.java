package hust.soict.dsai.aims.store;

import java.util.ArrayList;

//import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private int id = 0;
	
	public void addMedia(Media item) {
		if (itemsInStore.contains(item)) {
			System.out.println("Already in the store");
		}
		else {
			itemsInStore.add(item);
			System.out.println("Successfully add to the store");
		}
	}
	
	public void removeMedia(Media item) {
		if (itemsInStore.contains(item) == false) {
			System.out.println("Item is not in the store");
		}
		else {
			itemsInStore.remove(item);
			System.out.println("Successfully remove from the store");
		}
	}
}
