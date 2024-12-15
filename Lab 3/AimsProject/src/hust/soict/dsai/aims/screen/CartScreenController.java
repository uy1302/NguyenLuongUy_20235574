package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CartScreenController {
	
	private Cart cart;
	
	private Store store;
	
    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private RadioButton radioBtnFilterId;
    
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private Label lbtotalCost;

    @FXML
    private MenuItem menuViewStore;
    
    @FXML
    private MenuItem menuViewCart;
    
    @FXML
    private MenuItem menuAddBook;
    
    @FXML
    private MenuItem menuAddCD;
    
    @FXML
    private MenuItem menuAddDVD;
    

    public CartScreenController(Store store, Cart cart) {
		// TODO Auto-generated constructor stub
    	super();
    	this.cart = cart;
    	this.store = store;
	}

	@FXML
    private void initialize() {
    	
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	btnPlay.setVisible(true);
    	btnRemove.setVisible(true);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>(){
    				
    			@Override
    			public void changed(ObservableValue<? extends Media> observable, Media oldValue,
    					Media newValue) {
    				if (newValue!=null) {
    					updateButtonBar(newValue);
    				}
    				updateTotalCost();
    			}
    			});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override 
    		public void changed(ObservableValue<? extends String> observable, String oldValue,
    				String newValue) {
    			showFilteredMedia(newValue);
    		}
    	});
    	
    	if (cart.getItemsOrdered().size()==0) {
    		lbtotalCost.setText("0 $");
    	}else {
    		updateTotalCost();
    	}
    	
    }
    
    void showFilteredMedia(String newValue) {
    	FilteredList<Media> filteredMedia = new FilteredList<>(cart.getItemsOrdered(), m -> true);
		if (radioBtnFilterTitle.isSelected()) {
			filteredMedia.setPredicate(media -> {
			    if (tfFilter.getText() == null || tfFilter.getText().isEmpty()) {
			        return true; 
			    }
			    String filterText = tfFilter.getText().toLowerCase();
			    return media.getTitle().toLowerCase().contains(filterText);
			});
			tblMedia.setItems(filteredMedia);
		}else {
			filteredMedia.setPredicate(media -> {
			    if (tfFilter.getText() == null || tfFilter.getText().isEmpty()) {
			        return true; 
			    }
			    String filterText = tfFilter.getText().toLowerCase();
			    int intText = Integer.parseInt(filterText);
			    return media.getId() == intText;
			});
			tblMedia.setItems(filteredMedia);
		}
	}

	void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}else {
    		btnPlay.setVisible(false);
    	}
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateTotalCost();
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	this.cart.empty();
    	System.out.println("An order is created!");
    	placeOrderDialog();
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	updateTotalCost();
    }
    
    void placeOrderDialog() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);

        VBox vbox = new VBox(new Text("An order is created!"), new Button("Ok."));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        Button okButton = (Button) vbox.getChildren().get(1); 

        okButton.setOnAction(event -> {
            dialogStage.close(); 
        });

        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	try {
			playDialog(media);
		} catch (PlayerException e) {
			Stage dialogStage = new Stage();
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        
	        VBox vbox = new VBox(new Text(e.getMessage()), new Button("Ok."));
	        vbox.setAlignment(Pos.CENTER);
	        vbox.setPadding(new Insets(15));

	        Button okButton = (Button) vbox.getChildren().get(1); 

	        okButton.setOnAction(event1 -> {
	            dialogStage.close(); 
	        });

	        dialogStage.setScene(new Scene(vbox));
	        dialogStage.show();
		}
    }
    
    void playDialog (Media media) throws PlayerException{
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        
        String playText = "";
        if (media instanceof DigitalVideoDisc) {
        	DigitalVideoDisc dvd = (DigitalVideoDisc) media;
        	if (dvd.getLength() > 0) {
        		playText = "Playing DVD: " + dvd.getTitle() + "\nDVD length: " + dvd.getLength();
        	}else {
        		throw new PlayerException("ERROR: DVD length is non-positive");
        	}
        }else {
        	CompactDisc cd = (CompactDisc) media;
        	if (cd.getLength() > 0) {
        		for (Track track: cd.getTracks()) {
        			if (track.getLength() > 0) {
        				playText += "\nPlaying Track: " + track.getTitle() + 
        						"\nTrack length: " + track.getLength();
        			}else {
        				throw new PlayerException("ERROR: Track length is non-positive");
        			}
        		}
        	}else {
        		throw new PlayerException("ERROR: CD length is non-positive");
        	}
        }
        VBox vbox = new VBox(new Text(playText), new Button("Ok."));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        Button okButton = (Button) vbox.getChildren().get(1); 

        okButton.setOnAction(event -> {
            dialogStage.close(); 
        });

        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }
    
    void updateTotalCost() {
    	float totalFloat = cart.totalCost();
    	String totalString = String.format("%.2f", totalFloat) + " $";
    	lbtotalCost.setText(totalString);
    }
    
    @FXML
    void addBook(ActionEvent event) {
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
    }

    @FXML
    void addCD(ActionEvent event) {
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
    }

    @FXML
    void addDVD(ActionEvent event) {
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
    }

    @FXML
    void viewStore(ActionEvent event) {
        
    	new StoreScreen(store, cart);
    }

    @FXML
    void viewCart(ActionEvent event) {

    	new CartScreen(store, cart);
    }
    
}