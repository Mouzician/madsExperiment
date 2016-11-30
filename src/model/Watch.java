package model;

public class Watch {
	String model, brand;
	float price;//EUR
	
	public Watch(String model, String brand, float price){
		this.model=model;
		this.brand=brand;
		this.price=price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
