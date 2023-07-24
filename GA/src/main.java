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
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		ArrayList<Item> itemList = new ArrayList<Item>();

		
		// TEST OBJECTS
		OrderStatus os1 = new OrderStatus(1, "Pending");
		orderStatusList.add(os1);
		
		Payment p1 = new Payment("Bob","1234 5678 1239 9239", 999, "29/2/2000");
		paymentList.add(p1);
		
		Vendor v1 = new Vendor(1, "MACDONALds", "1233 5123", "ABC" );
		vendorList.add(v1);
		
		Menu m1 = new Menu(1,"name","status");
		menuList.add(m1);
		
		Item i1 = new Item(1,1,"name","desc",0.0);
		itemList.add(i1);
		
		School s1 = new School(1,"name","address",123);
		schoolList.add(s1);
		
		Order o1 = new Order(1,10,0.0,"name");
		orderList.add(o1);
		
		User u1 = new User("name",1,"contact number","role");
		userList.add(u1);
		
		int option = 0;

		while (option != 4) {
			startMenu();

			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				parentMenu();

				int parentOption = 0;
				while (parentOption != 6) {

					parentOption = Helper.readInt("Enter Option > ");
					if (parentOption == 1) {

						Helper.line(50, "-");
						System.out.println("Account Creation");
						Helper.line(50, "-");

						String name = Helper.readString("Enter Your Name > ");
						int id = userList.size() + 1;
						String contactNum = Helper.readString("Enter Your Contact Number > ");
						String role = Helper.readString("Are You A Parent / Guardian ? > ");

						userList.add(new User(name, id, contactNum, role));

					} else if (parentOption == 2) {
						// view
						for (Menu m : menuList) {
							main.setHeader("View Menu");
							System.out.println(String.format("%-10s %-10s %10s", "Menu ID", "Menu Name", "Menu status"));

							System.out.println(m.toString());
							break;
						}
					} else if (parentOption == 3) {
						// view status of order

						for (OrderStatus o : orderStatusList) {
							main.setHeader("View Order status");
							System.out.println(String.format("%-10s %-30s", "Order ID", "Order Status"));

							System.out.println(o.toString());

						}

					} else if (parentOption == 4) {
						// add payment

						Helper.line(50, "-");
						System.out.println("Add a new payment method");
						Helper.line(50, "-");

						String name = Helper.readString("Enter Name Displayed On The Card > ");
						String cardNo = Helper.readString("Enter Card Number > ");
						int cvc = Helper.readInt("Enter CVC / CVV > ");
						String exp = Helper.readString("Enter Expiration Date Of Card");

						paymentList.add(new Payment(name, cardNo, cvc, exp));

					} else if (parentOption == 5) {
						// edit payment
					} else if (parentOption == 6) {
						System.out.println("Goodbye!");
					} else {
						System.out.println("Invalid option!");
					}
				}

			} else if (option == 2) {
				vendorMenu();

				int vendorOption = 0;

				while (vendorOption != 4) {

					vendorOption = Helper.readInt("Enter option > ");

					if (vendorOption == 1) {
						// Add menu

						int menuId = menuList.size() + 1;
						String menuName = Helper.readString("Enter Menu Name / Title > ");
						String status = Helper.readString("Enter Menu Status > ");

						char con = 'Y';

						while (con == 'Y' || con == 'y') {

							int itemId = itemList.size() + 1;
							String itemName = Helper.readString("Enter Item Name > ");
							String itemDesc = Helper.readString("Enter Item Description > ");
							Double itemPrice = Helper.readDouble("Enter Price > ");

							itemList.add(new Item(menuId, itemId, itemName, itemDesc, itemPrice));
							con = Helper.readChar("Continue Adding Items to " + menuName + " (Y/N) > ");

							if (con == 'N' || con == 'n') {
								System.out.println("Menu and Items Successfully Added!");
								vendorMenu();
							}
						}

						menuList.add(new Menu(menuId, menuName, status));

					} else if (vendorOption == 2) {
						// edit menu
					} else if (vendorOption == 3) {
						// manage details
					} else if (vendorOption == 4) {
						System.out.println("Goodbye!");
					} else {
						System.out.println("Invalid option!");
					}

				}
			} else if (option == 3) {
				adminMenu();

				int adminOption = 0;

				while (adminOption != 7) {
					adminOption = Helper.readInt("Enter option > ");
					if (adminOption == 1) {
						// add school

						int id = schoolList.size() + 1;
						String name = Helper.readString("Enter School Name > ");
						String add = Helper.readString("Enter School's Address > ");

						schoolList.add(new School(id, name, add));

					} else if (adminOption == 2) {
						// edit school

					} else if (adminOption == 3) {
						// view all orders
		
						for (Order o : orderList) {
							main.setHeader("View all orders");
							System.out.println(String.format("%-10s %-15s %10s %15s", "Order ID", "No. of items",
									"Total cost", "Vendor Name"));

							System.out.println(o.toString());
						}
					} else if (adminOption == 4) {
						// View all order status
						for (OrderStatus os : orderStatusList) {
							main.setHeader("View All Order Statuses");
							System.out.println(String.format("%-10s %-15s", "Order ID", "Status"));

							System.out.println(os.toString());
						}
					} else if (adminOption == 5) {
						// view all users
						int userOption = 0;
						viewAllMenu();
						while (userOption != 4) {
							userOption = Helper.readInt("Enter option > ");
							if (userOption == 1) {
								// parent

								for (User u : userList) {
									main.setHeader("View All Parents/Guardians");

									System.out.println(String.format("%-10s %-15s %10s %15s", "Name", "ID",
											"Contact No.", "Role"));

									System.out.println(u.toString());
								}
							} else if (userOption == 2) {
								// school
								
								for (School s : schoolList) {
									main.setHeader("View All Schools");
									System.out.println(String.format("%-10s %-15s %10s %15s", "School ID", "Name",
											"Address", "No. of orders"));

									System.out.println(s.toString());
								}
							} else if (userOption == 3) {
								// vendor
							
								for (Vendor v : vendorList) {
									main.setHeader("View All Vendors");
									System.out.println(String.format("%-10s %-15s %10s %15s", "ID", "Name",
											"Contact No.", "Address"));
									
									System.out.println(v.toString());
								}
							} else if (userOption == 4) {
								System.out.println("Goodbye");
							} else {
								System.out.println("Invalid Option");
							}
						}
					} else if (adminOption == 6) {
						// generate monthly reports
					} else if (adminOption == 7) {
						// delete user accounts
						int deleteOption = 0;
						deleteMenu();
						while (deleteOption != 4) {
							deleteOption = Helper.readInt("Enter option > ");
							if (deleteOption == 1) {
								// parent
							} else if (deleteOption == 2) {
								// school
							} else if (deleteOption == 3) {
								// vendor
							} else if (deleteOption == 4) {
								System.out.println("Goodbye");
							} else {
								System.out.println("Invalid Option");
							}
						}
					} else if (adminOption == 8) {
						System.out.println("Goodbye");
					}
				}
			} else if (option == 4) {
				System.out.println("Goodbye!");
			} else {
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
