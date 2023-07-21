import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<School> schoolList = new ArrayList<School>();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		
		

		
		
		int option = 0;
		
		while (option !=4) {
			startMenu();
			
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				parentMenu();
				
				int parentOption = 0;
				while (parentOption != 6 ) {
					if (parentOption == 1) {
						
					}else if (parentOption == 2) {
						//view
					}
					else if (parentOption == 3) {
						//view status of order
					}else if (parentOption == 4) {
						//add payment
					}else if (parentOption == 5) {
						//edit payment
					}else if (parentOption == 6) {
						System.out.println("Goodbye!");
					}else {
						System.out.println("Invalid option!");
					}
				}
				
			}else if (option == 2) {
				vendorMenu();
				
				int vendorOption = 0;
				
				while (vendorOption != 4) {
					if (vendorOption == 1) {
						//Add menu
					}else if (vendorOption == 2) {
						//edit menu
					}else if (vendorOption == 3) {
						//manage details
					}else if (vendorOption == 4) {
						System.out.println("Goodbye!");
					}else {
						System.out.println("Invalid option!");
					}
				}
						
				
			}else if (option == 3) {
				adminMenu();
				
				int adminOption = 0;
				
				while (adminOption != 7) {
					adminOption = Helper.readInt("Enter option> ");
					if (adminOption == 1) {
						//add school
					}else if (adminOption == 2) {
						//edit school
					}else if (adminOption == 3) {
						//view order status
					}else if (adminOption == 4) {
						//view all users
						int userOption = 0;
						viewAllMenu();
						while (userOption != 4) {
							userOption = Helper.readInt("Enter option >");
							if (userOption == 1) {
								//parent
							}else if (userOption == 2) {
								//school
							}else if (userOption == 3) {
								//vendor
							}else if (userOption == 4) {
								System.out.println("Goodbye");
							}else {
								System.out.println("Invalid Option");
							}
						}
					}
				}
			}else if (option == 4) {
				System.out.println("Goodbye!");
			}else {
				System.out.println("Invalid option!");
			}
		}
	}

	private static void startMenu() {
		main.setHeader("Choose your user");
		System.out.println("1. Parent/Guardian");
		System.out.println("2. Vendor");
		System.out.println("3. Administrator");
		System.out.println("4. Quit");
	}
	
	private static void parentMenu() {
		main.setHeader("Parent/guardian menu");
		System.out.println("1. Create new account");
		System.out.println("2. View menu");
		System.out.println("3. View status of orders ");
		System.out.println("4. Add payment method");
		System.out.println("5. Edit payment method");
		System.out.println("6. Quit");
	}
	
	private static void vendorMenu() {
		main.setHeader("Vendor menu");
		System.out.println("1. Add menu");
		System.out.println("2. Edit menu");
		System.out.println("3. Manage Details");
		System.out.println("4. Quit");
	}
	private static void adminMenu() {
		main.setHeader("Admin menu");
		System.out.println("1. Add school");
		System.out.println("2. Edit school");
		System.out.println("3. View order status");
		System.out.println("4. View all users");
		System.out.println("5. Generate montly reports");
		System.out.println("6. Delete user accounts");
		System.out.println("7. Quit");
	}
	private static void viewAllMenu() {
		main.setHeader("Choose which user you want to view");
		System.out.println("1. Parent/Guardian");
		System.out.println("2. School");
		System.out.println("3. Vendor");
		System.out.println("4. Quit");
	}
	
	 private static void setHeader(String string) { 
		  // TODO Auto-generated method stub 
		  Helper.line(50, "-"); 
		  System.out.println(string); 
		  Helper.line(50, "-"); 
		 }
	

}
