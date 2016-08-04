package beans;

public class Driver extends Employee {
	
	private String drivingLicense;

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public Driver(){
		this.setType("Driver");
	};
	
	public Driver(String userId, String password, String name, String type, int age, char gender, String mailId,
			int salary, String employeeId) {
		super(userId, password, name, type, age, gender, mailId, salary, employeeId);
		this.setType("Driver");
	}
	
	public Driver(String userId, String password, String name, String type, int age, char gender, String mailId,
			String drivingLicense) {
		super(userId, password, name, type, age, gender, mailId);
		this.setType("Driver");
	}
	
}
