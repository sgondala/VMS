package beans;

public class Passenger extends User {

	public Passenger(){
		this.setType("Passenger");
	}
	
	public Passenger(String userId, String password, String name, String type, int age, char gender, String mailId) {
		super(userId, password, name, type, age, gender, mailId);
		this.setType("Passenger");
	}
	
}
