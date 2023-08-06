
public class Vendor {

	private int id;
	private String name;
	private String contactNo;
	private String address;
	
	public Vendor(int id, String name, String contactNo, String address) {
		
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
	}
	public String toString() {
		return String.format("%-10d %-30s %-10s %-10s\n",getId(), getName(), getContactNo(),getAddress());
		
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
