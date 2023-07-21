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
	
	public Order(int order_id, int noOfItems, double orderTotalCost) {
		this.order_id = order_id;
		this.noOfItems = noOfItems;
		this.orderTotalCost = orderTotalCost;
	}
	
	public String toString() {
		
		return String.format("%-10d %-10d %.2f", getOrder_id(), getNoOfItems(), getOrderTotalCost() );

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
