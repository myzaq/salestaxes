package it.github.myzaq.salestaxes.service;

import it.github.myzaq.salestaxes.bean.ShoppingBasket;

/**
 * Interface to define the methods to manage a Shopping Basket
 * @author Thomas Bartlett
 *
 */

public interface ManageBasketService{
	
	/**
	 * Print all the products from the input list:<br>
	 * The list shows the products <i>untaxed</i> prices
	 */
	public void printInput(ShoppingBasket shoppingBasket);
	
	/**
	 * Print all the products to the output list:<br>
	 * for each product is shown the taxed price.<br>
	 * At the bottom of the list, the amount of Sales Taxes and the Total cost
	 */
	public void printOutput(ShoppingBasket shoppingBasket);
	
}