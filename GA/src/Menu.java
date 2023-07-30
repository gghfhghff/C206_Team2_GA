/**
 * 
 */

/**
 * @author 22026038
 *
 */
public class Menu {
	private int menu_id;
	private String menu_name;
	private String menu_status;
	private String vendor_name;

	
	
	public Menu(int menu_id, String menu_name, String menu_status, String vendor_name) {
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_status = menu_status;
		this.vendor_name = vendor_name;
	}

	public Menu(int menu_id) {
		this.menu_id = menu_id;
	}



	public String toString() {
		return String.format("%-10d %-10s %-15s %-10s", getMenu_id(), getMenu_name(), getMenu_status(), getVendor_name());
		
	}
	
	


	
	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
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
	
	

}