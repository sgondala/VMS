package beans;

public class Bus {
	private String busNumber;
	private String registrationNumber;
	private String model;
	private int seatingCapacity;
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	
	public Bus(){}
	
	public Bus(String busNumber, String registrationNumber, String model, int seatingCapacity) {
		super();
		this.busNumber = busNumber;
		this.registrationNumber = registrationNumber;
		this.model = model;
		this.seatingCapacity = seatingCapacity;
	}
	
	
}	
