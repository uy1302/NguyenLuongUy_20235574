
package hust.soict.dsai.aims;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;


public class Aims {

	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers",87, (int) 19.95f);
		store.addMedia(dvd1);
				
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);

        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Mr.M");
        
        Book book = new Book("Calculus3", "Math", 12.5f, authors);
		store.addMedia(book);
		}
	
		public static void showMenu() {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
		}
		
		public static void storeMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
		}
		
		public static void mediaDetailsMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		
		public static void updateStoreMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add a Media");
			System.out.println("2. Remove a Media");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		
		public static void cartMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
		
		public static void filterMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter by id");
			System.out.println("2. Filter by title");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		
		public static void sortMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Sort by cost");
			System.out.println("2. Sort by title");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		
		public static void selectTypeMenu() {
			System.out.println("Choose one of the following media: ");
			System.out.println("--------------------------------");
			System.out.println("1. DVD");
			System.out.println("2. Book");
			System.out.println("3. CD");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
		}
	}


