package it.github.myzaq.salestaxes.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean used to store all the informations of a Shopping Cart
 * 
 * @author Thomas Bartlett
 *
 */
public class ShoppingBasket {
	
	private List<Product> products;
	private String id;
	
	public ShoppingBasket(String id) {
		this.id = id;
		this.products = new ArrayList<Product>();
	}
	
	/**
	 * Add a product to the Shopping Basket
	 * @param product
	 */
	public void addProduct(Product product){
		products.add(product);
	}
	
	/**
	 * Get the List of Products of this Shopping Basket 
	 * @return
	 */
	public List<Product> getProducts() {
		List<Product> clonedProducts = new ArrayList<Product>();
		for(Product product: products){
			clonedProducts.add(new Product(product.getType(), product.getDescription(), product.getPrice(), product.isImported()));
		}
		return clonedProducts;
	}

	/**
	 * Get the ID of this Shopping Basket
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	
}
