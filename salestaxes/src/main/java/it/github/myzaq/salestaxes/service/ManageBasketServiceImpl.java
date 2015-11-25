package it.github.myzaq.salestaxes.service;

import it.github.myzaq.salestaxes.bean.Product;
import it.github.myzaq.salestaxes.bean.ShoppingBasket;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementation of a ShoppingBasketService:<br>
 * the class implements all the methods necessary to manage the Shopping Cart
 * 
 * @author Thomas Bartlett
 *
 */

public class ManageBasketServiceImpl implements ManageBasketService{
	
	private static final BigDecimal BASIC_TAX  = new BigDecimal("0.10");
	private static final BigDecimal IMPORT_TAX = new BigDecimal("0.05");
	
	public void printInput(ShoppingBasket shoppingBasket) {
		System.out.println("Input " + shoppingBasket.getId());
		// Print all the products from the input list
		for(Product product: shoppingBasket.getProducts()){
			System.out.println("1 " + (product.isImported()?"imported ":"") + product.getDescription() + " at " + product.getPrice());
		}
		System.out.println();
	}
	
	public void printOutput(ShoppingBasket shoppingBasket) {
		
		BigDecimal salesTaxes = new BigDecimal("0.00");
		BigDecimal total 	  = new BigDecimal("0.00");
		
		System.out.println("Ouput " + shoppingBasket.getId());
		// Print all the products with taxed price from the list
		for(Product product: shoppingBasket.getProducts()){
			// get the tax amount for the product
			BigDecimal taxAmount = getTaxAmount(product);
			// calculate the taxed price
			BigDecimal taxedPrice = product.getPrice().add(taxAmount);
			// increase the total of sales taxes
			salesTaxes = salesTaxes.add(taxAmount);
			// increase the total cost of the list
			total = total.add(taxedPrice);
			// print the product
			System.out.println("1 " + (product.isImported()?"imported ":"") + product.getDescription() + ": " + taxedPrice);
		}

		System.out.println("Sales Taxes: " + salesTaxes);
		System.out.println("Total: " + total);
		System.out.println();
	}
	
	/**
	 * Private method to calculate the Tax Amount rounded up to the nearest 0.05
	 * The Tax Amount depends from:
	 * 	1) import tax of 10%
	 * 	2) basic tax of 5% (all the product types but Books, Food and Medical)
	 * @param product
	 * @return
	 */
	private BigDecimal getTaxAmount(Product product){
		BigDecimal taxAmount = new BigDecimal("0.00");
		
		// if the product is imported there is an import tax
		if(product.isImported()){
			taxAmount = taxAmount.add(product.getPrice().multiply(IMPORT_TAX));
		}
		
		// all the product types but book, food and medical have a basic tax
		switch(product.getType()){
			case Book:
				break;
			case Food:
				break;
			case Medical:
				break;
			default:
				taxAmount = taxAmount.add(product.getPrice().multiply(BASIC_TAX));
				break;
		}
		
		//rounded up to the nearest 0.05
		BigDecimal roundedTaxAmount = new BigDecimal(Math.ceil(taxAmount.doubleValue() * 20) / 20);
		
		return roundedTaxAmount.setScale(2, RoundingMode.HALF_UP);
		
	}
}