package beans;

public class Clerk extends Employee {
	public Clerk(){
		this.setType("Clerk");
	}

	public Clerk(String userId, String password, String name, String type, int age, char gender, String mailId) {
		super(userId, password, name, type, age, gender, mailId);
		this.setType("Clerk");
	}
	
	public Clerk(String userId, String password, String name, String type, int age, char gender, String mailId,
			int salary, String employeeId) {
		super(userId, password, name, type, age, gender, mailId, salary, employeeId);
		this.setType("Clerk");
	}
	
}
