/**
 * 
 */

/**
 * @author 22026038
 *
 */
public class Order {
	private int order_id;
	private int noOfItems;
	private double orderTotalCost;
	private String vendorName;
	
	public Order(int order_id, int noOfItems, double orderTotalCost, String vendorName) {
		this.order_id = order_id;
		this.noOfItems = noOfItems;
		this.orderTotalCost = orderTotalCost;
		this.vendorName = vendorName;
	}
	
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String toString() {
		
		return String.format("%-10d %-15d %-15.2f %-15s", getOrder_id(), getNoOfItems(), getOrderTotalCost(),getVendorName() );

	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public double getOrderTotalCost() {
		return orderTotalCost;
	}

	public void setOrderTotalCost(double orderTotalCost) {
		this.orderTotalCost = orderTotalCost;
	}
	
	
	
	
	
	
	
	
}
