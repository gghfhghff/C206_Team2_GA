
public class Payment {
	
	private String Name;
	private int id;
	
	public String toString() {
		
		return String.format("%-10s %-10d ",getName(), getId());

	}
	
	
	
	public Payment(String name, int id) {
		Name = name;
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public int getId() {
		return id;
	}
	


	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
