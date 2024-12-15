package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class AddItemStoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	private Store itemStorage;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		smUpdateStore.add(addBook);
		addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Store bookStorage = new Store();

            	Book book1 = new Book("The Hobbit", "Fantasy", 13.99f);
            	bookStorage.addMedia(book1);

            	Book book2 = new Book("Brave New World", "Dystopian", 11.50f);
            	bookStorage.addMedia(book2);

            	Book book3 = new Book("Educated", "Memoir", 16.99f);
            	bookStorage.addMedia(book3);

            	Book book4 = new Book("Moby Dick", "Classic", 14.99f);
            	bookStorage.addMedia(book4);

            	Book book5 = new Book("Pride and Prejudice", "Romance", 7.99f);
            	bookStorage.addMedia(book5);

            	Book book6 = new Book("The Silent Patient", "Thriller", 18.50f);
            	bookStorage.addMedia(book6);

            	Book book7 = new Book("The Picture of Dorian Gray", "Gothic", 10.99f);
            	bookStorage.addMedia(book7);

            	Book book8 = new Book("The Diary of a Young Girl", "Biography", 9.99f);
            	bookStorage.addMedia(book8);

            	Book book9 = new Book("The Godfather", "Crime", 14.25f);
            	bookStorage.addMedia(book9);

                new AddBookStoreScreen(store, bookStorage, cart);
                dispose();
            }
        });
		JMenuItem addCD = new JMenuItem("Add CD");
		smUpdateStore.add(addCD);
		addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Store cdStorage = new Store();

            	CompactDisc cd1 = new CompactDisc("Classical Elegance", 
            	        "Music", "Ludwig van Beethoven", 75, 18.50f);
            	cdStorage.addMedia(cd1);

            	CompactDisc cd2 = new CompactDisc("Space Odyssey", 
            	        "Sci-Fi", "Stanley Kubrick", 140, 21.99f);
            	cdStorage.addMedia(cd2);

            	CompactDisc cd3 = new CompactDisc("Horror Nights", 
            	        "Horror", "Stephen King", 90, 16.75f);
            	cdStorage.addMedia(cd3);

            	CompactDisc cd4 = new CompactDisc("Tech Revolution", 
            	        "Documentary", "Elon Musk", 60, 14.99f);
            	cdStorage.addMedia(cd4);

            	CompactDisc cd5 = new CompactDisc("Jazz Legends", 
            	        "Music", "Ella Fitzgerald", 85, 17.00f);
            	cdStorage.addMedia(cd5);

            	CompactDisc cd6 = new CompactDisc("World Cuisine", 
            	        "Lifestyle", "Anthony Bourdain", 55, 13.50f);
            	cdStorage.addMedia(cd6);

            	CompactDisc cd7 = new CompactDisc("Mythical Tales", 
            	        "Fantasy", "Guillermo del Toro", 125, 19.99f);
            	cdStorage.addMedia(cd7);

            	CompactDisc cd8 = new CompactDisc("Comedy Gold", 
            	        "Comedy", "Eddie Murphy", 70, 10.99f);
            	cdStorage.addMedia(cd8);

            	CompactDisc cd9 = new CompactDisc("Ocean Wonders", 
            	        "Nature", "Jacques Cousteau", 50, 15.75f);
            	cdStorage.addMedia(cd9);

                new AddCompactDiscStoreScreen(store, cdStorage, cart);
                dispose();
            }
        });
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVD);
		addDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Store dvdStorage = new Store();

            	DigitalVideoDisc dvd1 = new DigitalVideoDisc("Titanic", 
            	        "Romance", 21.99f);
            	dvdStorage.addMedia(dvd1);

            	DigitalVideoDisc dvd2 = new DigitalVideoDisc("Shrek", 
            	        "Comedy", 14.49f);
            	dvdStorage.addMedia(dvd2);

            	DigitalVideoDisc dvd3 = new DigitalVideoDisc("Jurassic Park", 
            	        "Adventure", 19.75f);
            	dvdStorage.addMedia(dvd3);

            	DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", 
            	        "Science Fiction", 24.50f);
            	dvdStorage.addMedia(dvd4);

            	DigitalVideoDisc dvd5 = new DigitalVideoDisc("Forrest Gump", 
            	        "Drama", 18.25f);
            	dvdStorage.addMedia(dvd5);

            	DigitalVideoDisc dvd6 = new DigitalVideoDisc("Coco", 
            	        "Animation", 16.49f);
            	dvdStorage.addMedia(dvd6);

            	DigitalVideoDisc dvd7 = new DigitalVideoDisc("Gladiator", 
            	        "Historical", 22.00f);
            	dvdStorage.addMedia(dvd7);

            	DigitalVideoDisc dvd8 = new DigitalVideoDisc("Black Panther", 
            	        "Superhero", 20.75f);
            	dvdStorage.addMedia(dvd8);

            	DigitalVideoDisc dvd9 = new DigitalVideoDisc("The Godfather", 
            	        "Crime", 25.99f);
            	dvdStorage.addMedia(dvd9);

                new AddDigitalVideoDiscStoreScreen(store, dvdStorage, cart);
                dispose();
            }
        });
		
		menu.add(smUpdateStore);
		JMenuItem menuViewStore = new JMenuItem("View store");
		menuViewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store, cart);
                dispose();
            }
        });
		menu.add(menuViewStore);
		JMenuItem menuViewCart = new JMenuItem("View cart");
		menuViewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(store, cart);
                dispose();
            }
        });
		menu.add(menuViewCart);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	
	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		JButton btnViewStore = new JButton("View store");
		btnViewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store, cart);
                dispose();
            }
        });
		btnViewStore.setPreferredSize(new Dimension(100, 50));
		btnViewStore.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnViewStore);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(0, 3, 2, 2));
		
		ArrayList<Media> mediaInStorage = itemStorage.getItemsInStore();
		for (int i=0; i<mediaInStorage.size(); i++) {
			MediaStorage cell = new MediaStorage(mediaInStorage.get(i), store);
			center.add(cell);
		}
		
		return center;
	}
	
	public AddItemStoreScreen(Store store, Store itemStorage, Cart cart) {
		this.store = store;
		this.itemStorage = itemStorage;
		this.cart = cart;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1024, 768);
	}
}
