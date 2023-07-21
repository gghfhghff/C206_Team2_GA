
public class User {

	private String id;
	private String Role;
	
	public User(String id, String role) {
		
		this.id = id;
		Role = role;
	}
	public String toString() {
		return String.format("%-10s %-30s", getId(), getRole());
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	
}
