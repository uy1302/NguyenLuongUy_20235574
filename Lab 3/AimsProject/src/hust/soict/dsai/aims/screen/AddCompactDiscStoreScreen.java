package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscStoreScreen extends AddItemStoreScreen{

	public AddCompactDiscStoreScreen(Store store, Store itemStorage, Cart cart) {
		super(store, itemStorage, cart);
		setTitle("CD Storage");
	}

}