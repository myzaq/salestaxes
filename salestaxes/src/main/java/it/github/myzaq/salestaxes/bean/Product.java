package it.github.myzaq.salestaxes.bean;

import it.github.myzaq.salestaxes.domain.ProductType;

import java.math.BigDecimal;

/**
 * Bean used to store all the informations of Goods
 * 
 * @author Thomas Bartlett
 * 
 */
public class Product {

	private ProductType type;
	private String 		description;
	private boolean 	imported;
	private BigDecimal 	price;

	public Product(ProductType type, String description, BigDecimal price, boolean imported) {
		this.type = type;
		this.description = description;
		this.price = price;
		this.imported = imported;
	}

	public ProductType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public boolean isImported() {
		return imported;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "1 " + (imported?" imported ":" ") + description + " at " + price;
	}

}
