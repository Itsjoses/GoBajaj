
public class User extends Person{
	String membership;

	public User(String iD, String email, String password, String name, String gender, int age, String role,
			String membership) {
		super(iD, email, password, name, gender, age, role);
		this.membership = membership;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	
	public void view() {
		System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Email: " + getEmail());
        System.out.println("Password: " + getPassword());
        System.out.println("Membership: " + getMembership());
	}
	
	
}
