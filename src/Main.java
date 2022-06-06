import java.util.*;

class Main {

	Scanner sc = new Scanner(System.in);
	Vector<Person> person = new Vector<>();
	Random rand = new Random();

	int scan(int opt) {
		try {
			opt = sc.nextInt();
		} catch (Exception e) {
			return -1;
		} finally {
			sc.nextLine();
		}
		return opt;
	}

	void reg_user() {
		String Email, membership;
		String name, password;
		String gender;
		int age = 0;
		String role;
		Boolean cek = false;

		do {
			System.out.print("Input name [5-20 char]: ");
			name = sc.nextLine();
		} while (name.length() < 5 || name.length() > 20);

		do {
			System.out.print("Input email [ends with @gmail.com]: ");
			Email = sc.next();
			if (Email.endsWith("@gmail.com")) {
				cek = true;
			}
		} while (!cek);

		do {
			System.out.print("Input password [7-20 char]: ");
			password = sc.next();
		} while (password.length() < 7 || password.length() > 20);

		cek = false;
		do {
			System.out.print("Input gender [Male | Female]: ");
			gender = sc.next();
			if (gender.equals("Male") || gender.equals("Female")) {
				cek = true;
			}
		} while (!cek);

		do {
			System.out.print("Input age [12-70]: ");
			age = scan(age);
		} while (age < 12 || age > 70);
		cek = false;
		do {
			System.out.print("Input membership [Bronze | Silver | Gold]: ");
			membership = sc.next();
			if (membership.equals("Bronze") || membership.equals("Silver") || membership.equals("Gold")) {
				cek = true;
			}
		} while (!cek);
		role = "User";

		final String id = UUID.randomUUID().toString();

		person.add(new User(id, Email, password, name, gender, age, role, membership));
		menu();
	}

	void reg_driver() {
		//add driver
		String Email, license;
		String name, password;
		String gender;
		int age = 0;
		String role;
		Boolean cek = false;

		do {
			System.out.println("Input name [5-20 char]: ");
			name = sc.nextLine();
		} while (name.length() < 5 || name.length() > 20);

		do {
			System.out.println("Input email [ends with @gmail.com]: ");
			Email = sc.next();
			if (Email.endsWith("@gmail.com")) {
				cek = true;
			}
		} while (!cek);

		do {
			System.out.println("Input password [7-20 char]: ");
			password = sc.next();
		} while (password.length() < 7 || password.length() > 20);

		cek = false;
		do {
			System.out.print("Input gender [Male | Female]: ");
			gender = sc.next();
			if (gender.equals("Male") || gender.equals("Female")) {
				cek = true;
			}
		} while (!cek);

		do {
			System.out.print("Input age [12-70]: ");
			age = scan(age);
		} while (age < 12 || age > 70);

		int x = (int) (100 + Math.random() * 899);
		String s = "";
		String s2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 3; i++) {
			int y = (int) (Math.random() * s2.length());
			s += s2.charAt(y);
		}
		license = s + x;
		role = "Driver";

		final String id = UUID.randomUUID().toString();
		person.add(new Driver(id, Email, password, name, gender, age, role, license));
		menu();
	}

	void register() {
		int opt = 0;
		System.out.println("Register");
		System.out.println("===========");
		System.out.println("1. User");
		System.out.println("2. Driver");
		System.out.println("3. Exit");
		do {
			System.out.print(">> ");
			opt = scan(opt);
		} while (opt < 1 || opt > 3);
		if (opt == 1) {
			reg_user();
		} else if (opt == 2) {
			reg_driver();
		} else if (opt == 3) {
			return;
		}
	}

	void delete(String x) {
		String id;
		boolean flagdelete = false;
		do {
			System.out.printf("Input Id %s: ", x);
			id = sc.nextLine();
			for (int i = 0; i < person.size(); i++) {
				if (id.equals(person.get(i).getID()) && person.get(i).getRole().equals(x)) {
					flagdelete = true;
					person.remove(i);
					break;
				}
			}
			System.out.println("User successfully deleted");
			System.out.println("Press enter to continue...");
			sc.nextLine();
		} while (flagdelete == false);
	}

	void manageDriver() {
		if (person.isEmpty()) {
			System.out.println("No users in the database!");
			System.out.print("Press enter to continue...");
		} else {
			for (Person persons : person) {
				if (persons instanceof Driver) {
					((Driver) persons).view();
				}
			}
			String flag = null;
			do {
				System.out.println("Would you like to delete a user? (Y/N)");
				flag = sc.nextLine();
			} while (!flag.equalsIgnoreCase("y") && !flag.equalsIgnoreCase("n"));

			if (flag.equalsIgnoreCase("y")) {
				delete("Driver");
			} else {
				return;
			}
		}
	}

	void AdminMenu() {
		int opt = 0;
		do {
			System.out.println("Hello, admin!");
			System.out.println("===========");
			System.out.println("1. Manage User List");
			System.out.println("2. Manage Driver List");
			System.out.println("3. Exit");
			System.out.print(">> ");
			opt = scan(opt);
			if (opt == 1) {
				manageUser();
			} else if (opt == 2) {
				manageDriver();
			}
		} while (opt != 3);
	}

	void manageUser() {
		if (person.isEmpty()) {
			System.out.println("No users in the database!");
			System.out.print("Press enter to continue...");
		} else {
			for (Person persons : person) {
				if (persons instanceof User) {
					((User) persons).view();
				}
			}

			String flag = "";
			do {
				System.out.println("Would you like to delete a user? (Y/N)");
				flag = sc.nextLine();
			} while (!flag.equalsIgnoreCase("y") && !flag.equalsIgnoreCase("n"));

			if (flag.equalsIgnoreCase("y")) {
				delete("User");
			} else {
				return;
			}
		}
	}

	void sleepthread(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	void GetDriver() {
		String Destination;
		System.out.print("Choose Destination: ");
		Destination = sc.nextLine();
		System.out.println("Getting Driver Wait for 3 Seconds");
		sleepthread(3000);
		System.out.println("Driver Didapatkan");
		int km = rand.nextInt(99);
		int total = km * 1000;
		int sleep = (km / 5) * 500;
		System.out.println("km: " + km);
		System.out.println("Price: " + total);
		System.out.print("Press Enter to continue...");
		sc.nextLine();
		System.out.printf("ON The Way, Wait for %d seconds\n", (sleep / 1000));
		sleepthread(sleep);
		System.out.println("Already Arrived in Destination");
		System.out.print("Press Enter to continue...");
		sc.nextLine();
	}

	void UserMenu() {
		int opt = 0;
		do {
			System.out.println("1. Order Driver");
			System.out.println("2. Exit");
			System.out.println(">> ");
			opt = scan(opt);
			if (opt == 1) {
				GetDriver();
			}
		} while (opt != 2);
	}

	void DriverMenu() {
		int opt = 0;
		do {
			System.out.println("1. Get Order");
			System.out.println("2. Exit");
			System.out.println(">> ");
			opt = scan(opt);
			if (opt == 1) {
				GetOrder();
			}
		} while (opt != 2);
	}

	void GetOrder() {
		Boolean cek = false;
		for (int i = 0; i < person.size(); i++) {
			if (person.get(i).getRole().equals("User")) {
				cek = true;
			}
		}
		if (cek) {
			System.out.println("Waiting for user.... Please wait for 3 Seconds");
			sleepthread(3000);
			int x = 0;
			cek = false;
			while (!cek) {
				x = rand.nextInt(person.size());
				if (person.get(x).getRole().equals("User")) {
					cek = true;
				}
			}
			System.out.println("User Found!");
			System.out.printf("Name : %s\n", person.get(x).getName());
			int km = rand.nextInt(99);
			int total = km * 1000;
			int sleep = (km / 5) * 500;
			System.out.println("km: " + km);
			System.out.println("Price: " + total);
			System.out.print("Press Enter to continue...");
			sc.nextLine();
			System.out.printf("ON The Way, Wait for %d seconds\n", (sleep / 1000));
			sleepthread(sleep);
			System.out.println("Already Arrived in Destination");
			System.out.print("Press Enter to continue...");
			sc.nextLine();
		} else {
			System.out.println("There are no user....");
		}
	}

	void login() {
		String email;
		String password;
		boolean flag = false;
		System.out.print("Input Email: ");
		email = sc.nextLine();
		System.out.print("Input Password: ");
		password = sc.nextLine();

		for (int i = 0; i < person.size(); i++) {
			if (email.equals(person.get(i).getEmail()) && password.equals(person.get(i).getPassword())) {
				flag = true;
				if (person.get(i).getRole().equals("Admin")) {
					AdminMenu();
				} else if (person.get(i).getRole().equals("User")) {
					UserMenu();
				} else {
					DriverMenu();
				}
				break;
			}
		}
		if (flag == false) {
			System.out.print("Email and Password Invalid");
			System.out.println("Press enter to continue...");
			sc.nextLine();
		}

	}

	void menu() {
		final String id = UUID.randomUUID().toString();
		person.add(new Admin(id, "admin@gmail.com", "admin1", "Admin", "Admin", 00, "Admin"));
		int opt = 0;
		do {
			System.out.println("Main Menu");
			System.out.println("===========");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			do {
				System.out.print(">> ");
				opt = scan(opt);
			} while (opt < 1 || opt > 3);
			if (opt == 1) {
				register();
			} else if (opt == 2) {
				login();
			}
		} while (opt != 3);
	}

	public Main() {
		menu();
	}

	public static void main(String[] args) {
		new Main();
	}

}