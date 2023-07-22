import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<School> schoolList = new ArrayList<School>();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		
		
		OrderStatus o1 = new OrderStatus(1,"Pending");
		orderStatusList.add(o1);
		
		int option = 0;
		
		while (option !=4) {
			startMenu();
			
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				parentMenu();
				
				int parentOption = 0;
				while (parentOption != 6 ) {
					parentOption = Helper.readInt("Enter Option> ");
					if (parentOption == 1) {
						
					}else if (parentOption == 2) {
						//view
						for (Menu m : menuList) {
							main.setHeader("View Menu");
						
						System.out.println(m);
						break;
						}
					}
					else if (parentOption == 3) {
						//view status of order
						
						System.out.println(String.format("%-10s %-30s", "Order ID", "Order Status"));
						for (OrderStatus o : orderStatusList) {
							main.setHeader("View Order status");
							
							System.out.println(o.toString());
							
						}
					
						
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
					vendorOption = Helper.readInt("Enter option> ");
					if (vendorOption == 1) {
						//Add menu
					}else if (vendorOption == 2) {
						//edit menu
					}else if (vendorOption == 3) {
						//manage details
					}else if (vendorOption == 4) {
						System.out.println("Goodbye!");
					}
				} {
					System.out.println("Invalid option!");
				}
						
				
			}else if (option == 3) {
				adminMenu();
				
				int adminOption = 0;
				
				while (adminOption != 7) {
					adminOption = Helper.readInt("Enter option > ");
					if (adminOption == 1) {
						//add school
					}else if (adminOption == 2) {
						//edit school
						
					}else if (adminOption == 3) {
						//view all orders
						for (Order o : orderList) {
							main.setHeader("View all orders");
							
							System.out.println(o);
						}
					}else if (adminOption == 4) {
						//View all order status
						for (OrderStatus os : orderStatusList) {
							main.setHeader("View All Order Statuses");
							
							System.out.println(os);
						}
					}else if (adminOption == 4) {
						//view all users
						int userOption = 0;
						viewAllMenu();
						while (userOption != 4) {
							userOption = Helper.readInt("Enter option > ");
							if (userOption == 1) {
								//parent
								for (User u: userList) {
								main.setHeader("View All Parents/Guardians");
									
									System.out.println(u);
								}
							}else if (userOption == 2) {
								//school
								for (School s: schoolList) {
									main.setHeader("View All Schools");
									
									System.out.println(s);
								}
							}else if (userOption == 3) {
								//vendor
								for (Vendor v: vendorList) {
									main.setHeader("View All Vendors");
									System.out.println(v);
								}
							}else if (userOption == 4) {
								System.out.println("Goodbye");
							}else {
								System.out.println("Invalid Option");
							}
						}
					}else if (adminOption == 5) {
						//generate monthly reports
					}else if (adminOption == 6) {
						//delete user accounts
						int deleteOption = 0;
						deleteMenu();
						while (deleteOption != 4) {
							deleteOption = Helper.readInt("Enter option > ");
							if (deleteOption == 1) {
								//parent
							}else if (deleteOption == 2) {
								//school
							}else if (deleteOption == 3) {
								//vendor
							}else if (deleteOption == 4) {
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
		main.setHeader("User Selection");
		System.out.println("1. Parent/Guardian");
		System.out.println("2. Vendor");
		System.out.println("3. Administrator");
		System.out.println("4. Quit");
	}
	
	private static void parentMenu() {
		main.setHeader("Parent/Guardian Menu");
		System.out.println("1. Create new account");
		System.out.println("2. View menu");
		System.out.println("3. View status of orders ");
		System.out.println("4. Add payment method");
		System.out.println("5. Edit payment method");
		System.out.println("6. Quit");
	}
	
	private static void vendorMenu() {
		main.setHeader("Vendor Menu");
		System.out.println("1. Add menu");
		System.out.println("2. Edit menu");
		System.out.println("3. Manage Details");
		System.out.println("4. Quit");
	}
	private static void adminMenu() {
		main.setHeader("Admin Menu");
		System.out.println("1. Add school");
		System.out.println("2. Edit school");
		System.out.println("3. View all Orders");
		System.out.println("4. View order status");
		System.out.println("5. View all users");
		System.out.println("6. Generate montly reports");
		System.out.println("7. Delete user accounts");
		System.out.println("8. Quit");
	}
	private static void viewAllMenu() {
		main.setHeader("View User Selection");
		System.out.println("1. Parent/Guardian");
		System.out.println("2. School");
		System.out.println("3. Vendor");
		System.out.println("4. Quit");
	}
	private static void deleteMenu() {
		main.setHeader("Delete User Selection");
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
