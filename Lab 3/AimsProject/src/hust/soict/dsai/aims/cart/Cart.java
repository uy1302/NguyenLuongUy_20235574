package hust.soict.dsai.aims.cart;

import java.util.Collections;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList(); 
	private int MAX_NUMBERS_ORDERED = 20;
	public Cart() {};
	public void addMedia(Media item) throws LimitExceededException{
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if (itemsOrdered.contains(item)==false) {
				itemsOrdered.add(item);
				System.out.println("Item added successfully!");
			}else {
				System.out.println("This item is already in the cart.");
			}
		}else {
			throw new LimitExceededException("ERROR: The number of "
					+ "media has reached its limit");
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
		itemsOrdered.clear();;
	}
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
