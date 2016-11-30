package model;

import java.util.ArrayList;

public class Store {
	ArrayList<Receipt> receipts;
	ArrayList<Watch> watchs;
	ArrayList<Costumer> costumers;
	ArrayList<String> brands;
	public Store(){
		watchs = new ArrayList<>();
		receipts = new ArrayList<>();
		costumers = new ArrayList<>();
		brands = new ArrayList<>();
		
		brands.add("Lorus");
		brands.add("CAT");
		brands.add("DOG");
		
		watchs.add(new Watch("Black", brands.get(0), 250));
		watchs.add(new Watch("White", brands.get(0), 200));
		watchs.add(new Watch("Green", brands.get(1), 300));
		watchs.add(new Watch("X", brands.get(2), 1000));
		watchs.add(new Watch("P", brands.get(2), 500));
		watchs.add(new Watch("T", brands.get(0), (float) 249.99));
		watchs.add(new Watch("O", brands.get(0), 654.3f));
		
		
	}
	public ArrayList<Receipt> getReceipts() {
		return receipts;
	}
	public void setReceipts(ArrayList<Receipt> receipts) {
		this.receipts = receipts;
	}
	public ArrayList<Watch> getWatchs() {
		return watchs;
	}
	public void setWatchs(ArrayList<Watch> watchs) {
		this.watchs = watchs;
	}
	public ArrayList<Costumer> getCostumers() {
		return costumers;
	}
	public void setCostumers(ArrayList<Costumer> costumers) {
		this.costumers = costumers;
	}
	public ArrayList<String> getBrands() {
		return brands;
	}
	public void setBrands(ArrayList<String> brands) {
		this.brands = brands;
	}
	
	
}
