
public class User {

	private int id;
	private String Role;
	
	public User(int id, String role) {
		
		this.id = id;
		Role = role;
	}
	public String toString() {
		return String.format("%-10s %-30s", getId(), getRole());
		
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
