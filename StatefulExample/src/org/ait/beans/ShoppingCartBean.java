package org.ait.beans;

import java.util.HashMap;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/** * Session Bean implementation class ShopingCartBean */
@Stateful
@LocalBean
public class ShoppingCartBean implements ShoppingCartBeanLocal {
	private HashMap<String, Integer> cart = new HashMap<String, Integer>();

	public ShoppingCartBean() {
	}

	@Override
	public void buy(String product, int quality) {
		if (cart.containsKey(product)) {
			int currqt = cart.get(product);
			currqt += quality;
			cart.put(product, currqt);
		} else {
			cart.put(product, quality);
		}
	}

	@Override
	public HashMap<String, Integer> getCartContent() {
		return cart;
	}

	@Remove
	public void checkout() {
		System.out.println("To be implemented");
	}
}