
public class School {
	
	private int school_id;
	private String name;
	private String address;
	private int noOfOrders;
	
	
	public School(int school_id, String name, String address, int noOfOrders) {
		this.school_id = school_id;
		this.name = name;
		this.address = address;
		this.noOfOrders = noOfOrders;
	}
	
	
	
	public int getSchool_id() {
		return school_id;
	}
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	
	

}
