package application;

public class Taille extends Option{
	private String size;
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public Taille(String size, float price) {
		super(price);
		this.size = size;
	}


}
