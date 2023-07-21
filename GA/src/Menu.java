/**
 * 
 */

/**
 * @author 22026038
 *
 */
public class Menu {
	private String menu_id;
	private String menu_name;
	private String menu_status;
	private String item_id;
	private String item_name;
	private String item_description;
	private double item_price;
	
	public Menu(String menu_id, String menu_name, String menu_status) {
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_status = menu_status;
	}

	public Menu(String item_id, String item_name, String item_description, double item_price) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_price = item_price;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_status() {
		return menu_status;
	}

	public void setMenu_status(String menu_status) {
		this.menu_status = menu_status;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
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
