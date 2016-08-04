package beans;

public class Employee extends User {
	
	private int salary;
	private String employeeId;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Employee(String userId, String password, String name, String type, int age, char gender, String mailId) {
		super(userId, password, name, type, age, gender, mailId);
		// TODO Auto-generated constructor stub
	}

	public Employee(String userId, String password, String name, String type, int age, char gender, String mailId,
			int salary, String employeeId) {
		super(userId, password, name, type, age, gender, mailId);
		this.salary = salary;
		this.employeeId = employeeId;
	}
	
	public Employee(){}
	

}
