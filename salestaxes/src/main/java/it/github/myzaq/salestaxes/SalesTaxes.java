/**
 * 
 */
package it.github.myzaq.salestaxes;

import it.github.myzaq.salestaxes.bean.Product;
import it.github.myzaq.salestaxes.bean.ShoppingBasket;
import it.github.myzaq.salestaxes.domain.ProductType;
import it.github.myzaq.salestaxes.service.ManageBasketService;
import it.github.myzaq.salestaxes.service.ManageBasketServiceImpl;

import java.math.BigDecimal;

/**
 * Main class of the Sales Taxes interview excercise
 * 
 * Run this class to see the rusults...
 * 
 * @author Thomas Bartlett
 */
public class SalesTaxes {
	
	private static ManageBasketService manageBasketService;
	
	public static void main(String[] args) {
		
		manageBasketService = new ManageBasketServiceImpl();

		// First Cart
		ShoppingBasket shoppingBasket1 = new ShoppingBasket("1");
		shoppingBasket1.addProduct(new Product(ProductType.Book, "book", new BigDecimal("12.49"), false));
		shoppingBasket1.addProduct(new Product(ProductType.Other, "music CD", new BigDecimal("14.99"), false));
		shoppingBasket1.addProduct(new Product(ProductType.Food, "chocolate bar", new BigDecimal("0.85"), false));

		// Second Cart
		ShoppingBasket shoppingBasket2 = new ShoppingBasket("2");
		shoppingBasket2.addProduct(new Product(ProductType.Food, "box of chocolates", new BigDecimal("10.00"), true));
		shoppingBasket2.addProduct(new Product(ProductType.Other, "bottle of perfume", new BigDecimal("47.50"), true));
		
		// Third Cart
		ShoppingBasket shoppingBasket3 = new ShoppingBasket("3");
		shoppingBasket3.addProduct(new Product(ProductType.Other, "bottle of perfume", new BigDecimal("27.99"), true));
		shoppingBasket3.addProduct(new Product(ProductType.Other, "bottle of perfume", new BigDecimal("18.99"), false));
		shoppingBasket3.addProduct(new Product(ProductType.Medical, "packet of headache pills", new BigDecimal("9.75"), false));
		shoppingBasket3.addProduct(new Product(ProductType.Food, "box of chocolates", new BigDecimal("11.25"), true));
		
		// Print the input lists
		manageBasketService.printInput(shoppingBasket1);
		manageBasketService.printInput(shoppingBasket2);
		manageBasketService.printInput(shoppingBasket3);
		System.out.println();
		
		// Print the output lists
		manageBasketService.printOutput(shoppingBasket1);
		manageBasketService.printOutput(shoppingBasket2);
		manageBasketService.printOutput(shoppingBasket3);

	}

}
