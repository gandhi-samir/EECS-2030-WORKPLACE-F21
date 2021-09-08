package model;

public class Product {
	
	private String model;
	private String finish;
	private int storage;
	private boolean hasCellularConnectivity;
	private double originalPrice;
	private double discountValue;

	
	public Product() {
		
	}
	
	public Product(String model, double originalPrice) {
		this.model=model;
		this.originalPrice=originalPrice;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model=model;  
		
	}
	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public boolean hasCellularConnectivity() {
		return hasCellularConnectivity;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
	public double getPrice() {
		double price =0.0;
		price=this.originalPrice-this.discountValue;
		return price;
	}
	
	public String toString() {
		String s="";
		
		StringBuilder sb = new StringBuilder();
		sb.append(model+" "+finish+" "+storage+"GB "+ "(Cellular connectivty: "+hasCellularConnectivity+"): $("+String.format("%.2f", originalPrice)+" - "+String.format("%.2f", discountValue)+")"); 
		s=sb.toString(); 
		
		return s;
	}
	
	
	
	
	
}
