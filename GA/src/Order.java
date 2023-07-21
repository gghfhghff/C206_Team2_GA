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
	
	public Order(int order_id, int noOfItems) {
		this.order_id = order_id;
		this.noOfItems = noOfItems;
	}
	
	public String toString() {
		
		return String.format("%-10d %-10d ", getOrder_id(), getNoOfItems());

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
	
	
	
	
	
	
}
