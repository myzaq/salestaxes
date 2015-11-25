package it.github.myzaq.salestaxes.domain;

/**
 * Define all the product types
 * 
 * @author Thomas Bartlett
 *
 */

public enum ProductType {
	
	Book(1, "Books"),
	Food(2, "Food"),
	Medical(3, "Medical"),
	Other(4, "Other");
	
	private int			code;
	private String		description;
	
	ProductType(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
}