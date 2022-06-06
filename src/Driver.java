
public class Driver extends Person{
	String driverlicense;

	public Driver(String iD, String email, String password, String name, String gender, int age, String role,
			String driverlicense) {
		super(iD, email, password, name, gender, age, role);
		this.driverlicense = driverlicense;
	}

	public String getDriverlicense() {
		return driverlicense;
	}

	public void setDriverlicense(String driverlicense) {
		this.driverlicense = driverlicense;
	}

	public void view() {
		System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Email: " + getEmail());
        System.out.println("Password: " + getPassword());
        System.out.println("Membership: " + getDriverlicense());
	}
	
}
