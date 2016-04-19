package PracticeProgramDraft;

import java.text.DecimalFormat;

public class Item {
	
	private String name;
	private double price;
	private int inStock;
	private int maxStock;
	private Supplier supplier;
	private double orderPrice;
	DecimalFormat df = new DecimalFormat("0.00");
	
	//Constructor Method
	public Item(String n, double p, int is, int ms, Supplier s, double op){
		name = n;
		price = p;
		inStock = is;
		maxStock = ms;
		supplier = s;
		orderPrice = op;
	}
	
	//Get Methods
	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	public int getInStock(){
		return inStock;
	}
	public int getMaxStock(){
		return maxStock;
	}
	public String getSupplierName(){
		return supplier.getName();
	}
	public double getOrderPrice(){
		return orderPrice;
	}
	
	//Modifier Methods
	public void setprice(double p){
		price = p;
	}
	public void setInStock(int s){
		inStock = s;
	}
	public void setMaxStock(int s){
		maxStock = s;
	}
	public void decStock(){
		inStock--;
	}
	public void incStock(){
		inStock++;
	}

	@Override
	public String toString() {
		return "" + name + "-------" + "$" + df.format(price);
	}

	
	
	
}
