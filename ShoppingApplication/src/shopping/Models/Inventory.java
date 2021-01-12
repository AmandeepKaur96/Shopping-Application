package shopping.Models;

import java.util.ArrayList;

public class Inventory {
	private static ArrayList<Product> productsList;
	
	public Inventory() {
		this.productsList = new ArrayList();
	}
	
	public void addToList(Product product) {
		this.productsList.add(product);
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
	
	public Product getProductAtIndex(int index) {
		return this.productsList.get(index);
	}
}
