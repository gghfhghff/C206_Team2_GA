
public class Vendor {

	private int id;
	private String name;
	private int contactNo;
	private String address;
	public Vendor(int id, String name, int contactNo, String address) {
		
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
	}
	public String toString() {
		return String.format("%-10s %-30s %-10s %-10s",getId(), getName(), getContactNo(),getAddress());
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
