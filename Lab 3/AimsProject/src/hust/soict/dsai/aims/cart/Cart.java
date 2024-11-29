package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	private List<Media> itemsOrdered = new ArrayList<Media>(); 
	
	public void addMedia(Media item) {
		if (itemsOrdered.contains(item)) {
			System.out.println("Already in Cart");
		}
		else {
			itemsOrdered.add(item);
			System.out.println("Successfullly add the item");
		}
	}
	public void removeMedia(Media item) {
		if (itemsOrdered.contains(item) == false) {
			System.out.println("Item is not in the cart");
		}
		else {
			itemsOrdered.remove(item);
			System.out.println("Successfully remove the item");
		}
	}
	
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered ) {
            total += media.getCost(); 
        }
        return total;
    }
    public void getAllTitles() {
		for (Media item: itemsOrdered) {
			System.out.println(item.getTitle());
		}
	}
    public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: ");
		for (Media item: itemsOrdered) {
			System.out.println(item.toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}

    public void search(int id) {
		boolean found = false;
		for (Media item: itemsOrdered) {
			if (item.isMatch(id)) {
				System.out.println(item.toString());
				found = true;
			}
		}
		if (found == false) {
			System.out.println("No match is found");
		}
	}
    public void search(String title) {
		boolean found = false;
		for (Media item: itemsOrdered) {
			if (item.isMatch(title)) {
				System.out.println(item.toString());
				found = true;
			}
		}
		if (found == false) {
			System.out.println("No match is found");
		}
	}
    public void sortByTitleCost() {
		Collections.sort(itemsOrdered);
	}
    public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
    public int getNumberOfMedia() {
		return itemsOrdered.size();
	}
	
	public void empty() {
		itemsOrdered = new ArrayList<Media>();
	}
}
