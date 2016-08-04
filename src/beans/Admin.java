package beans;

public class Admin extends Employee {

	public Admin() {
		super();
		this.setType("Admin");
	}

	public Admin(String userId, String password, String name, String type, int age, char gender, String mailId,
			int salary, String employeeId) {
		super(userId, password, name, type, age, gender, mailId, salary, employeeId);
		this.setType("Admin");
	}

	public Admin(String userId, String password, String name, String type, int age, char gender, String mailId) {
		super(userId, password, name, type, age, gender, mailId);
		this.setType("Admin");
	}
	
}
