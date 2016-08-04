package beans;

public class User {
	private String userId;
	private String password;
	private String name;
	private String type;
	private int age;
	private char gender;
	private String mailId;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	public User(String userId, String password, String name, String type, int age, char gender, String mailId) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.type = type;
		this.age = age;
		this.gender = gender;
		this.mailId = mailId;
	}
	
	public User(){}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", type=" + type + ", age="
				+ age + ", gender=" + gender + ", mailId=" + mailId + "]";
	};
	
	
	
}
