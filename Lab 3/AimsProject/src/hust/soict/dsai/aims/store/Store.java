package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
//	private int id = 0;
	
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
	
	public void print() {
		System.out.println("All product in the store:");
		for (Media item: itemsInStore) {
			System.out.println(item.toString());
		}
	}
	
	public Media search(String title) {
		for (Media item: itemsInStore) {
			if (item.isMatch(title)) {
				return item;
			}
		}
		return null;
	}

	public ArrayList<Media> getItemsInStore() {
		return (ArrayList<Media>)itemsInStore;
	} 
	

}
