package application;

import java.util.ArrayList;
import java.util.List;

public class Velo {
	private String type;
	private String marque;
	private String lienPhoto;
	private float defaultPrice;
	private List<Option> options;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getLienPhoto() {
		return lienPhoto;
	}

	public void setLienPhoto(String lienPhoto) {
		this.lienPhoto = lienPhoto;
	}

	public float getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(float defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Velo(String type, String marque, String lienPhoto, float defaultPrice) {
		this.type = type;
		this.marque = marque;
		this.lienPhoto = lienPhoto;
		this.defaultPrice = defaultPrice;
		this.options = new ArrayList<>();
	}
	
	public void addOption(Option option) {
        options.add(option);
    }
	
	public void removeOption(Option option) {
        options.remove(option);
    }
	 
	public void clearOption() {
		options.clear();
	}
	
	public double calculPrix() {
        float totalPrice = this.defaultPrice;
        for (Option option : options) {
            this.defaultPrice += option.getPrice();
        }
        return totalPrice;
    }

}
