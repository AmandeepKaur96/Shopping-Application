package shopping.Models;

public class Product {
	private String name;
	private String category;
	private String description;
	private Integer price;
	private Integer quantity;
	
	public Product(String name, String category, String description, Integer price, Integer quantity) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getPriceString() {
		return this.price.toString() + "$";
	}
	
	public String getQuantityString() {
		return this.quantity.toString();
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getPrice() {
		return this.price;
	}
}
