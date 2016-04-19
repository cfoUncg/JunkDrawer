package PracticeProgramDraft;

import java.util.ArrayList;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.math.BigInteger;

public class Transaction {

	final double taxRate = .0725;
	private double subTotal;
	private double total;
	private double tax;
	private int itemCount;
	private String transactionID;
	private ArrayList<Item> productsPurchased;
	private SecureRandom random = new SecureRandom();
	DecimalFormat df = new DecimalFormat("0.00");

	public Transaction() {
		this.subTotal = 0;
		this.total = 0;
		this.tax = 0;
		this.itemCount = 0;
		this.transactionID = generateTID();
		this.productsPurchased = new ArrayList<Item>();
		this.random = new SecureRandom();
	}

	public Transaction(double subTotal, double total, double tax, int itemCount, ArrayList<Item> productsPurchased) {
		super();
		this.subTotal = subTotal;
		this.total = total;
		this.tax = tax;
		this.itemCount = itemCount;
		this.transactionID = generateTID();
		this.productsPurchased = productsPurchased;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTax() {
		return tax;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public double getSubTotal() {
		return subTotal;
	}
	
	public String viewSubTotal(){
		return df.format(subTotal);
	}
	
	public String viewTax(){
		return df.format(tax);
	}
	
	public String viewTotal(){
		return df.format(total);
	}

	public String getTransactionID() {
		return transactionID;
	}

	public ArrayList<Item> getProductsPurchased() {
		return productsPurchased;
	}

	public void addItem(Item P) {
		subTotal += P.getPrice();
		total= subTotal + (subTotal * taxRate);
		tax = taxRate * subTotal;
		itemCount++;
		productsPurchased.add(P);
	}

	public void removeItem(Item P) {
		if (itemCount > 0) {
			if (productsPurchased.contains(P)) {
				itemCount--;
				productsPurchased.remove(P);
			}
		}
	}

	public double calculateTotal() {
		tax = subTotal * taxRate;
		total = tax + subTotal;
		return total;
	}

	@Override

	public String toString() {
		return "Transaction [taxRate=" + taxRate + ", subTotal=" + subTotal + ", total=" + total + ", tax=" + tax
				+ ", itemCount=" + itemCount + ", transactionID= " + transactionID + ", productsPurchased="
				+ productsPurchased + "]";
	}

	public String generateTID() {
		return new BigInteger(130, random).toString(32);
	}

}
