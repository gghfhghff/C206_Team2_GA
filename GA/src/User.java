
public class User {

	private String name;
	private int id;
	private String contactNum;
	private String Role;

	
	
	public User(String name, int id, String contactNum, String role) {
		this.name = name;
		this.id = id;
		this.contactNum = contactNum;
		Role = role;
	}
	
	public String toString() {
		return String.format("%-10s %-10d, %-10s %-10s", getName(), getId(), getContactNum(), getRole());
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}


	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	
}
