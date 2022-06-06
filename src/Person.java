
public class Person {
	private String ID;
	private String Email;
	private String Password;
	private String name;
	private String gender;
	private int age;
	private String role;

	public Person(String iD, String email, String password, String name, String gender, int age, String role) {
		super();
		ID = iD;
		Email = email;
		Password = password;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.role = role;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
