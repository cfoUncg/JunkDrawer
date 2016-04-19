package PracticeProgramDraft;


public class User {

	private String username;
	private String password;
	private double payRate;
	private double hours;
	private String firstName;
	private String lastName;
	private String address;
	private boolean isManager;
	
	//Constructor
	public User(String username, String password, double payRate, double hours, String firstName, String lastName,
			String address, boolean isManager) {
		super();
		this.username = username;
		this.password = password;
		this.payRate = payRate;
		this.hours = hours;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.isManager = isManager;
	}
	
	//Getter and Setter Methods
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getPayRate() {
		return payRate;
	}
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//other methods
	public double calculatePayCheck(){
		return (hours * payRate);
	}
}
