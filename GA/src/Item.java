
public class Item extends Menu{
	
	private int item_id;
	private String item_name;
	private String item_description;
	private double item_price;
	
	public Item(int menu_id, int item_id, String item_name,
			String item_description, double item_price) {
		
		super(menu_id);
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_price = item_price;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
	
	
	

}
