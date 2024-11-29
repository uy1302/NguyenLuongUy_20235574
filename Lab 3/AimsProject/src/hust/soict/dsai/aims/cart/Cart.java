package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(); 
    
    
	
	
	
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
    
    public String toString(DigitalVideoDisc dvd) {
        String title = dvd.getTitle() != null ? dvd.getTitle() : "N/A";
        String category = dvd.getCategory() != null ? dvd.getCategory() : "N/A";
        String director = dvd.getDirector() != null ? dvd.getDirector() : "N/A";
        String length = dvd.getLength() > 0 ? String.valueOf(dvd.getLength()) : "N/A"; 
        String cost = dvd.getCost() > 0 ? String.valueOf(dvd.getCost()) : "N/A";
    	return "DVD" +"-"+ title + "-" + category + "-"+ director +"-" + length + ":"+ cost +"$";
    }
    
    public void print() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	int count = 1;
    	for (DigitalVideoDisc dvd: itemsOrdered) {
    		if (dvd != null) {
    		System.out.println(count + ". " + toString(dvd));
    		count++;
    		}
    	}
    	System.out.println("Total cost: " + String.valueOf(totalCost()));
    	System.out.println("***************************************************");
    }
    
    public void search_id(int id) {
    	boolean x = true;
    	for(DigitalVideoDisc dvd:itemsOrdered) {
    		if (dvd.getId() == id ) {
    			System.out.println(toString(dvd));
    			x = false;
    			break;
    		}
    	}
    	if (x) {
    	System.out.println("No match is found.");
    	}
    }
    public void search_title(String title) {
    	boolean x = true;
    	for(DigitalVideoDisc dvd:itemsOrdered) {
    		if (dvd.getTitle() == title ) {
    			System.out.println(toString(dvd));
    			x = false;
    			break;
    		}
    	}
    	if (x) {
    	System.out.println("No match is found.");
    	}
    }
}
