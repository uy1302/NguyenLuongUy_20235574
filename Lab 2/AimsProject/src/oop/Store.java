package oop;

public class Store {
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[1000];
	private int id = 0;
	
	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore[id] = dvd;
		id++;
		System.out.println("The disc has been added.");
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < id; i++) {
            if (itemsInStore[i].equals(dvd)) {
                found = true;
                for (int j = i; j < id - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[id - 1] = null;
                id--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not found in the cart.");
        }
	}
		
	
}
