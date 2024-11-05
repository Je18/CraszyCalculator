package application;

public class Personnalisation extends Option {
	private String person;
	
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Personnalisation(String person, float price) {
		super(price);
		this.person = person;
		
	}

}
