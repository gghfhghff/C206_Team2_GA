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

	
	
	public Menu(int menu_id, String menu_name, String menu_status) {
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_status = menu_status;
	}

	public Menu(int menu_id) {
		this.menu_id = menu_id;
	}



	public String toString() {
		return String.format("%-10d %-10s %-10s", getMenu_id(), getMenu_name(), getMenu_status());
		
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