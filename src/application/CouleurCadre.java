package application;

import javafx.scene.paint.Color;

public class CouleurCadre extends Option {
	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public CouleurCadre(String color, float price) {
		super(price);
		this.color = color;
		
	}

}
