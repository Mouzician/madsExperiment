package model;

public class Receipt {
	Costumer costumer;
	Watch watch;

	public Receipt(Costumer costumer, Watch watch) {
		this.costumer = costumer;
		this.watch = watch;
	}

	public Costumer getCostumer() {
		return costumer;
	}

	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public static float convertPrice(float price ,String curr) {
		
		switch (curr) {
		case "USD":
			return (float) (price*1.06282);
		case "GBP":
			return (float) (price*0.851390052);
		default:
			return price;
		}
	}
}
