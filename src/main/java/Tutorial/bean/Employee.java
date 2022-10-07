package Tutorial.bean;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	
	public Employee() {
		id = -1;
		firstName = "";
		lastName = "";
	}
	
	public Employee(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(Employee e) {
		this.id = e.id;
		this.firstName = e.firstName;
		this.lastName = e.lastName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String toString() {
		return "[ " + id + " ]: " + firstName + ", " + lastName;
	}
}
