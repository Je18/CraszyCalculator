package application;

public class Option {
	private float price;
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public Option(float price) {
		this.price = price;
	}
	
	public String toString() {
		return this.price + "€";
	}
	
}
