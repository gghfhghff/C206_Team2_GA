
public class OrderStatus {

	private int orderID;
	private String status;
	public OrderStatus(int orderID, String status) {

		this.orderID = orderID;
		this.status = status;
	}
	public String toString() {
		return String.format("%-10s %-30s", getOrderID(), getStatus());
		
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
