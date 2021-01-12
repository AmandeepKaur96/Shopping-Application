package shopping.Models;

import java.util.ArrayList;

public class Cart {
	private static ArrayList<Product> productsList;
	private Integer totalPrice;
	
	public Cart() {
		this.productsList = new ArrayList();
	}
	
	public void addToList(Product product) {
		this.productsList.add(product);
		this.totalPrice = new Integer(0);
	}
	
	public String[][] getProductListArray(){
		String[][] productListArray = new String[this.productsList.size()][];
		Product product;
		
		for(int i = 0; i < this.productsList.size(); i++) {
			product = this.productsList.get(i);			
			productListArray[i] = new String[5];
			
        	productListArray[i][0] = product.getName();
        	productListArray[i][1] = product.getCategory();
        	productListArray[i][2] = product.getDescription();
        	productListArray[i][3] = product.getPriceString();
        	productListArray[i][4] = product.getQuantityString();
		}
		
		return productListArray;
	}
	
	public void emptyCart() {
		this.productsList = new ArrayList();
	}
	
	public Integer getTotalPrice() {
		for(int i = 0; i < this.productsList.size(); i++) {
			this.totalPrice += (this.productsList.get(i).getPrice() * this.productsList.get(i).getQuantity());
		}
		
		return this.totalPrice;
	}
}
