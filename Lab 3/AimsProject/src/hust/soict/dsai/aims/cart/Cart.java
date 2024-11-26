package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 
	private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
                System.out.println("The cart is almost full");
            }
        } else {
            System.out.println("The cart is full.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED - dvdList.length) {
	    	for (int x = 0; x <= dvdList.length; x ++ ) {
	    			itemsOrdered[qtyOrdered] = dvdList[x];
	    			qtyOrdered++;
	            }
	    	System.out.println("The disc has been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
                System.out.println("The cart is almost full");}
	    }
		else {
			System.out.println("Can not add all dvd in the list");
		}
    }
    
//    public void addDigitalVideoDisc(DigitalVideoDisc... newDvds) {
//    	for (DigitalVideoDisc dvd: newDvds) {
//    		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//                itemsOrdered[qtyOrdered] = dvd;
//                qtyOrdered++;
//                System.out.println("All disc have been added.");
//    		}
//    		else {
//                System.out.println("The cart is full.");
//    		}
//    	}
//    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	if (qtyOrdered < MAX_NUMBERS_ORDERED-1) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("Two discs have been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
                System.out.println("The cart is almost full");
            }
        }
		else {
            System.out.println("Can not add two discs.");
		}
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not found in the cart.");
        }
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost(); 
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
