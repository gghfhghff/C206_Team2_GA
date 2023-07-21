import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<School> schoolList = new ArrayList<School>();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Vendor> camcorderList = new ArrayList<Vendor>();
		
		

		
		
		int option = 0;
		
		while (option !=4) {
			startMenu();
			
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				
			}else if (option == 2) {
				
			}else if (option == 3) {
				
			}else if (option == 4) {
				System.out.println("Goodbye!");
			}else {
				System.out.println("Invalid option!");
			}
		}
	}

	private static void startMenu() {
		main.setHeader("");
		System.out.println("1. Parent/Guardian");
		System.out.println("2. Vendor");
		System.out.println("3. Administrator");
		System.out.println("4. Quit");
	}

	private static void setHeader(String string) {
		// TODO Auto-generated method stub
		Helper.line(50, "-");
		System.out.println("choose your user");
		Helper.line(50, "-");
	}

}
