import java.util.ArrayList;

public class main {

	private static final int ADMIN_DELETE_SCHOOL = 2;
	private static final int ADMIN_SEARCH_ORDER = 9;
	private static final int DELETE_VENDOR = 3;
	private static final int DELETE_PARENT = 1;
	private static final int DELETE_USERS = 8;
	private static final int GENERATE_REPORTS = 7;
	private static final int SEARCH_USER_BY_SCHOOL = 6;
	private static final int BACK_TO_ADMIN_MENU = 4;
	private static final int VIEW_VENDORS = 2;
	private static final int VIEW_SCHOOLS = 3;
	private static final int VIEW_PARENTS = 1;
	private static final int VIEW_USERS = 5;
	private static final int VIEW_ALL_ORDERS = 4;
	private static final int ADD_VENDOR = 3;
	private static final int DELETE_SCHOOL = 2;
	private static final int EDIT_SCHOOL_ID = 1;
	private static final int EDIT_SCHOOL = 2;
	private static final int ADD_SCHOOL = 1;
	private static final int ADMIN_TO_USERS = 10;
	private static final int VENDOR_USERS = 5;
	private static final int SEARCH_ORDER = 4;
	private static final int MANAGE_DETAILS = 3;
	private static final int EDIT_TO_VENDOR = 3;
	private static final int DELETE_MENU = 2;
	private static final int MENU_TO_EDIT = 1;
	private static final int EDIT_MENU = 2;
	private static final int ADD_MENU = 1;
	private static final int VENDOR_TO_USERS = 5;
	private static final int PARENT_TO_USERS = 9;
	private static final int VIEW_PAYMENT_METHOD = 8;
	private static final int DELETE_PAYMENT = 7;
	private static final int ADD_PAYMENT = 6;
	private static final int VIEW_ORDERS = 5;
	private static final int CANCEL_ORDER = 4;
	private static final int PLACE_ORDER = 3;
	private static final int VIEW_MENU = 2;
	private static final int ADD_USER = 1;
	private static final int CHOOSE_ADMIN = 3;
	private static final int CHOOSE_VENDOR = 2;
	private static final int CHOOSE_PARENT = 1;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<School> schoolList = new ArrayList<School>();
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		ArrayList<Item> itemList = new ArrayList<Item>();

		// TEST OBJECTS
//		OrderStatus os1 = new OrderStatus(1, "Pending");
//		orderStatusList.add(os1);

		Payment p1 = new Payment("Matt", "1234 5678 1239 9239", 999, "29/2/2000");
		paymentList.add(p1);

		Vendor v1 = new Vendor(1, "MACDONALds", "1233 5123", "ABC");
		vendorList.add(v1);

		Menu m1 = new Menu(1, "name", "status", "vendor name");
		menuList.add(m1);

		Item i1 = new Item(1, 1, "name", "desc", 5.0);
		itemList.add(i1);

		School s1 = new School(1, "name", "address", 123);
		schoolList.add(s1);

//		User u1 = new User("name", 1, "contact number", "role");
//		userList.add(u1);

		int option = 0;

		while (option != OPTION_QUIT) {
			startMenu();

			option = Helper.readInt("Enter an option > ");

			if (option == CHOOSE_PARENT) {
				parentMenu();

				int parentOption = 0;
				while (parentOption != 9) {

					parentOption = Helper.readInt("Enter Option > ");

					if (parentOption == ADD_USER) {

						User u1 = inputUser(userList);
						addUser(userList, u1);

					} else if (parentOption == VIEW_MENU) {
						// view
						retrieveAllMenus(menuList);
						viewAllMenus(menuList);
						parentMenu();

					} else if (parentOption == PLACE_ORDER) {
						// place order

						addOrder(orderList, menuList, itemList, paymentList);

					} else if (parentOption == CANCEL_ORDER) {
						// cancel order

						deleteOrder(orderList);
						parentMenu();

					} else if (parentOption == VIEW_ORDERS) {
						// view order
						retrieveAllOrders(orderList);
						viewAllOrders(orderList);
						parentMenu();

					} else if (parentOption == ADD_PAYMENT) {
						// add payment

						Payment payment1 = inputPayment(paymentList);
						addPayment(paymentList, payment1);

					} else if (parentOption == DELETE_PAYMENT) {
						// delete payment
						deletePayment(paymentList);
						parentMenu();

					} else if (parentOption == VIEW_PAYMENT_METHOD) {
						// view payment

						retrieveAllPayments(paymentList);
						viewAllPayment(paymentList);
						parentMenu();

					}

					else if (parentOption == PARENT_TO_USERS) {
						System.out.println("Returning to menu...");
						break;

					} else {
						System.out.println("Invalid option!");
						parentMenu();
					}
				}

			} else if (option == CHOOSE_VENDOR) {
				vendorMenu();

				int vendorOption = 0;

				while (vendorOption != VENDOR_TO_USERS) {

					vendorOption = Helper.readInt("Enter option > ");

					if (vendorOption == ADD_MENU) {
						// Add menu

						Menu menu1 = inputMenu(menuList);
						addMenu(menuList, menu1);

						char con = 'Y';

						while (con == 'Y' || con == 'y') {

							Item item1 = inputItem(itemList, menu1);
							addItem(itemList, item1);
							String menu_name = menu1.getMenu_name();

							con = Helper.readChar("Continue Adding Items to " + menu_name + " (Y/N) > ");

							if (con == 'N' || con == 'n') {
								vendorMenu();
							} else {
								System.out.println("Invalid Option");
								vendorMenu();
							}
						}

					} else if (vendorOption == EDIT_MENU) {
						// edit menu
						editMenuMenu();
						int checkItem = 0;
						int checkMenu = 0;

						option = Helper.readInt("Enter an option > ");

						if (option == MENU_TO_EDIT) {

							int editMenu = Helper.readInt("Enter Menu ID To Be Edited > ");

							for (int i = 0; i < menuList.size(); i++) {
								int menu_id = menuList.get(i).getMenu_id();

								if (editMenu == menu_id) {
									int editItem = Helper.readInt("Enter Item ID To Be Edited > ");
									Helper.line(50, "-");
									checkMenu++;

									for (int m = 0; m < itemList.size(); m++) {
										int item_id = itemList.get(m).getItem_id();

										if (editItem == item_id) {
											String item_name = itemList.get(m).getItem_name();
											String item_description = itemList.get(m).getItem_description();
											double item_price = itemList.get(m).getItem_price();

											System.out.println(String.format(
													"Item ID: %d \nItem Name: %s \nItem Description: %s \nItem Price: %.2f",
													item_id, item_name, item_description, item_price));
											String newName = Helper.readString("Enter Item's Updated Name > ");
											String newDesc = Helper.readString("Enter Item's Updated Description > ");
											double newPrice = Helper.readDouble("Enter Item's Updated Price > ");

											itemList.get(m).setItem_name(newName);
											itemList.get(m).setItem_description(newDesc);
											itemList.get(m).setItem_price(newPrice);
											checkItem++;
											System.out.println("Item Updated Successfully");
											break;

										}
									}
									if (checkItem == 0) {
										System.out.println("Item Not Found");
									}
								}
							}
							if (checkMenu == 0) {
								System.out.println("Menu Not Found");
							}
						} else if (option == DELETE_MENU) {
							deleteMenu(menuList);
						} else if (option == EDIT_TO_VENDOR) {
							System.out.println("Goodbye!");
						} else {
							System.out.println("Invalid Option");
						}
						vendorMenu();

					} else if (vendorOption == MANAGE_DETAILS) {
						// manage details
						int check = 0;
						main.setHeader("Edit Vendor Details");

						int vendorId = Helper.readInt("Enter Vendor ID > ");
						for (int i = 0; i < vendorList.size(); i++) {
							int id = vendorList.get(i).getId();

							if (vendorId == id) {
								String vendor_name = vendorList.get(i).getName();
								String vendor_contact = vendorList.get(i).getContactNo();
								String vendor_address = vendorList.get(i).getAddress();

								System.out.println(String.format(
										"Vendor ID: %d \nVendor Name: %s \nVendor Contact Number: %s \nVendor Address: %s",
										id, vendor_name, vendor_contact, vendor_address));
								String newNum = Helper.readString("Enter Vendor's Updated Contact Number > ");
								String newAddress = Helper.readString("Enter Vendor's Updated Address > ");
								vendorList.get(i).setContactNo(newNum);
								vendorList.get(i).setAddress(newAddress);
								check++;
								System.out.println("Updated Successfully");
								break;
							}
						}
						if (check == 0) {
							System.out.println("Vendor Not Found");
						}
						vendorMenu();
					} else if (vendorOption == SEARCH_ORDER) {
						main.setHeader("Search Order");

						int orderID = Helper.readInt("Enter order ID> ");
						System.out.println(String.format("%-10d %-15d %-15.2f %-15s %s", "Order ID", "No.of Items",
								"Total Cost", "Vendor Name", "Order Status"));
						for (Order o : orderList) {
							int order_id = o.getOrder_id();

							if (orderID == order_id) {
								System.out.println(o.toString());
							} else {
								System.out.println("Order not found!");
							}

						}
						vendorMenu();

					} else if (vendorOption == VENDOR_USERS) {
						System.out.println("Returning to Menu...");
					} else {
						System.out.println("Invalid option!");
						vendorMenu();
					}

				}
			} else if (option == CHOOSE_ADMIN) {
				adminMenu();

				int adminOption = 0;

				while (adminOption != ADMIN_TO_USERS) {
					adminOption = Helper.readInt("Enter option > ");
					if (adminOption == ADD_SCHOOL) {
						// add school

						School school1 = inputSchool(schoolList);
						addSchool(schoolList, school1);

					} else if (adminOption == EDIT_SCHOOL) {
						// edit school
						editSchoolMenu();
						int check = 0;

						option = Helper.readInt("Enter an option > ");

						if (option == EDIT_SCHOOL_ID) {
							int schoolId = Helper.readInt("Enter School ID > ");
							for (int i = 0; i < schoolList.size(); i++) {

								int school_id = schoolList.get(i).getSchool_id();

								if (schoolId == school_id) {
									String school_name = schoolList.get(i).getName();
									String school_address = schoolList.get(i).getAddress();
									int noOfOrders = schoolList.get(i).getNoOfOrders();

									System.out.println(String.format(
											"School ID: %d \nSchool Name: %s \nSchool Address: %s \nSchool No. of Orders: %d",
											school_id, school_name, school_address, noOfOrders));
									String newAddress = Helper.readString("Enter School's Updated Address > ");
									schoolList.get(i).setAddress(newAddress);
									check++;
									System.out.println("Updated Successfully");
									break;
								}
							}

							if (check == 0) {
								System.out.println("School Not Found");
							}
						}

						else if (option == DELETE_SCHOOL) {
							deleteSchool(schoolList);
						}
						adminMenu();

					} else if (adminOption == ADD_VENDOR) {

						Vendor vendor1 = inputVendor(vendorList);
						addVendor(vendorList, vendor1);

					} else if (adminOption == VIEW_ALL_ORDERS) {
						// view all orders
						retrieveAllOrders(orderList);
						viewAllOrders(orderList);
						adminMenu();
					} else if (adminOption == VIEW_USERS) {
						// view all users
						int userOption = 0;
						viewAllMenu();
						while (userOption != 4) {
							userOption = Helper.readInt("Enter option > ");
							if (userOption == VIEW_PARENTS) {
								// parent

								retrieveAllUsers(userList);
								viewAllUsers(userList);
								viewAllMenu();
							} else if (userOption == VIEW_VENDORS) {
								retrieveAllVendors(vendorList);
								viewAllVendor(vendorList);
								viewAllMenu();
							} else if (userOption == VIEW_SCHOOLS) {

								retrieveAllSchools(schoolList);
								viewAllSchools(schoolList);
								viewAllMenu();

							} else if (userOption == BACK_TO_ADMIN_MENU) {
								System.out.println("Goodbye");
								adminMenu();
							} else {
								System.out.println("Invalid Option");
							}
						}
					} else if (adminOption == SEARCH_USER_BY_SCHOOL) {

						main.setHeader("SEARCH USER BY SCHOOL");

						String school = Helper.readString("Enter School to serach user > ");

						boolean userFound = false;

						String output = String.format("%-10s %-10s %-10s\n", "User ID", "Name", "Contact Number");

						for (int i = 0; i < userList.size(); i++) {

							String search_school = userList.get(i).getSchool();

							if (search_school.equalsIgnoreCase(school)) {

								userFound = true;

								int user_id = userList.get(i).getId();
								String user_name = userList.get(i).getName();
								String user_contact = userList.get(i).getContactNum();

								output += String.format("%-10s %-10s %-10s", user_id, user_name, user_contact);

							}
						}

						if (userFound == false) {

							System.out.println("User not found!");

						}

						System.out.println(output);
						adminMenu();

					} else if (adminOption == GENERATE_REPORTS) {
						// generate reports
						main.setHeader("REPORT");
						System.out.println("Total Number of Users: " + userList.size());
						System.out.println("Total Number of Schools: " + schoolList.size());
						System.out.println("Total Number of Vendors: " + vendorList.size());
						adminMenu();
					} else if (adminOption == DELETE_USERS) {
						// delete user accounts
						int deleteOption = 0;
						deleteMenu();

						deleteOption = Helper.readInt("Enter option > ");
						if (deleteOption == DELETE_PARENT) {
							// TODO ABCDEDFFFED
							// parent
							deleteUser(userList);
							adminMenu();
						} else if (deleteOption == ADMIN_DELETE_SCHOOL) {
							deleteSchool(schoolList);
							adminMenu();
						} else if (deleteOption == DELETE_VENDOR) {
							// vendor
							deleteVendor(vendorList);
							adminMenu();
						} else if (deleteOption == 4) {
							System.out.println("Return");
							adminMenu();
						}

					} else if (adminOption == ADMIN_SEARCH_ORDER) {
						main.setHeader("Search Order");

						int orderID = Helper.readInt("Enter order ID> ");
						System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "Order ID", "No.of Items",
								"Total Cost", "Vendor Name", "Order Status"));
						for (Order o : orderList) {
							if (orderID == o.getOrder_id()) {
								System.out.println(o.toString());
							} else {
								System.out.println("Order not found!");
							}

						}
						adminMenu();
					} else if (adminOption == ADMIN_TO_USERS) {
						System.out.println("Returning to Menu...");
					} else {
						System.out.println("Invalid option!");
						adminMenu();
					}
				}
			} else if (option == OPTION_QUIT) {
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
		System.out.println("3. Place order");
		System.out.println("4. Cancel Order");
		System.out.println("5. View status of orders ");
		System.out.println("6. Add payment method");
		System.out.println("7. Delete payment method");
		System.out.println("8. View payment method");
		System.out.println("9. Return to user selection");
	}

	private static void vendorMenu() {
		main.setHeader("Vendor Menu");
		System.out.println("1. Add menu");
		System.out.println("2. Edit menu");
		System.out.println("3. Manage Details");
		System.out.println("4. Search order");
		System.out.println("5. Return to user selection");
	}

	private static void adminMenu() {
		main.setHeader("Admin Menu");
		System.out.println("1. Add school");
		System.out.println("2. Edit school");
		System.out.println("3. Add vendor");
		System.out.println("4. View all Orders");
		System.out.println("5. View all users");
		System.out.println("6. Search user by school");
		System.out.println("7. Generate reports");
		System.out.println("8. Delete user accounts");
		System.out.println("9. Search Order");
		System.out.println("10. Return to user selection");
	}

	private static void viewAllMenu() {
		main.setHeader("View User Selection");
		System.out.println("1. Parent/Guardian");
		System.out.println("2. Vendor");
		System.out.println("3. School");
		System.out.println("4. Quit");
	}

	private static void deleteMenu() {
		main.setHeader("Delete User Selection");
		System.out.println("1. Parent/Guardian");
		System.out.println("2. School");
		System.out.println("3. Vendor");
		System.out.println("4. Return to Admin Menu");
	}

	private static void setHeader(String string) {
		Helper.line(50, "-");
		System.out.println(string);
		Helper.line(50, "-");
	}

	private static void editMenuMenu() {
		main.setHeader("Edit Menu");
		System.out.println("1. Edit Menu");
		System.out.println("2. Delete Menu");
		System.out.println("3. Return to Vendor Menu");
	}

	private static void editSchoolMenu() {
		main.setHeader("Edit School");
		System.out.println("1. Edit School");
		System.out.println("2. Delete School");
		System.out.println("3. Return to Admin Menu");
	}

	private static User inputUser(ArrayList<User> userList) {

		main.setHeader("Account Creation");

		String name = Helper.readString("Enter Your Name > ");
		int id = userList.size() + 1;
		String contactNum = Helper.readString("Enter Your Contact Number > ");
		String role = Helper.readString("Are You A Parent / Guardian ? > ");
		String school = Helper.readString("Enter School Name > ");

		User u1 = new User(name, id, contactNum, role, school);

		return u1;
	}

	// ========================================add
	// users==================================
	static void addUser(ArrayList<User> userList, User u1) {

		boolean userFound = false;

		for (int i = 0; i < userList.size(); i++) {

			if (userList.get(i).getName().equalsIgnoreCase(u1.getName())
					&& userList.get(i).getContactNum().equals(u1.getContactNum())) { // To find if
				// user already
				// exists

				userFound = true;

				System.out.println("User already has an existing account !");

				break;

			}
		}

		if (userFound == false) {

			if (!u1.getName().isEmpty() && !u1.getContactNum().isEmpty()) {

				if (u1.getRole().equalsIgnoreCase("Parent") || u1.getRole().equalsIgnoreCase("Guardian")) {

					userList.add(u1);

					System.out.println("Account Successfully Created !");

				} else {

					System.out.println("Invalid Input fOR 'Parent / Guardian' !");
				}

			} else {

				System.out.println("Information provided is incomplete !");

			}

		}

		parentMenu();

	}

	private static School inputSchool(ArrayList<School> schoolList) {

		main.setHeader("Add School");

		int id = schoolList.size() + 1;
		String name = Helper.readString("Enter School Name > ");
		String add = Helper.readString("Enter School's Address > ");

		School school1 = new School(id, name, add);

		return school1;
	}

	public static boolean addSchool(ArrayList<School> schoolList, School school1) {

		boolean schFound = false;
		boolean isAdded = false;
		for (int i = 0; i < schoolList.size(); i++) {

			if (schoolList.get(i).getName().equalsIgnoreCase(school1.getName())
					&& schoolList.get(i).getAddress().equalsIgnoreCase(school1.getAddress())) {

				schFound = true;

				System.out.println("School Already Exists !");

				break;

			}
			

		}

		if (schFound == false) {

			if (!school1.getName().isEmpty() && !school1.getAddress().isEmpty()) {

				schoolList.add(school1);

				System.out.println("School Successfully Added !");

			} else {

				System.out.println("Information Entered Is Incompelte !");

			}

		}

		adminMenu();
		return isAdded;
	}

	private static Item inputItem(ArrayList<Item> itemList, Menu menu1) {

		int itemId = itemList.size() + 1;
		String itemName = Helper.readString("Enter Item Name > ");
		String itemDesc = Helper.readString("Enter Item Description > ");
		Double itemPrice = Helper.readDouble("Enter Price > ");

		Item item1 = new Item(menu1.getMenu_id(), itemId, itemName, itemDesc, itemPrice);

		return item1;

	}

	private static void addItem(ArrayList<Item> itemList, Item item1) {

		boolean itemFound = false;

		for (int i = 0; i < itemList.size(); i++) {

			if (itemList.get(i).getItem_name().equals(item1.getItem_name())
					&& itemList.get(i).getItem_description().equals(item1.getItem_description())
					&& itemList.get(i).getItem_price() == item1.getItem_price()) {

				System.out.println("Item Already Exists In Menu !");

				itemFound = true;

				break;

			}

		}

		if (itemFound == false) {

			if (!item1.getItem_name().isEmpty() && !item1.getItem_description().isEmpty()
					&& item1.getItem_price() != 0) {

				itemList.add(new Item(item1.getMenu_id(), item1.getItem_id(), item1.getItem_name(),
						item1.getItem_description(), item1.getItem_price()));
				System.out.println("Items Successfully Added!");

			} else {

				System.out.println("Information Entered Is Incomplete !");

			}

		}

	}

	private static Menu inputMenu(ArrayList<Menu> menuList) {

		int menuId = menuList.size() + 1;
		String menuName = Helper.readString("Enter Menu Name / Title > ");
		String status = Helper.readString("Enter Menu Status > ");
		String vendorName = Helper.readString("Enter Vendor's Name > ");

		Menu menu1 = new Menu(menuId, menuName, status, vendorName);

		return menu1;

	}

	public static void addMenu(ArrayList<Menu> menuList, Menu menu1) {

		boolean menuFound = false;

		for (int i = 0; i < menuList.size(); i++) {

			if (menuList.get(i).getMenu_name().equals(menu1.getMenu_name())
					&& menuList.get(i).getMenu_status().equals(menu1.getMenu_status())) {

				System.out.println("Menu Already Exists !");

				menuFound = true;

				break;

			}
		}

		if (menuFound == false) {

			if (!menu1.getMenu_name().isEmpty() && !menu1.getMenu_status().isEmpty()) {

				menuList.add(menu1);

				System.out.println("Menu Successfully Added !");

			} else {

				System.out.println("Information Entered Is Incomplete !");

			}

		}

	}

	public static void addOrder(ArrayList<Order> orderList, ArrayList<Menu> menuList, ArrayList<Item> itemList,
			ArrayList<Payment> paymentList) {

		char con = 'Y';
		int totalqty = 0;
		double grandTotal = 0;

		while (con == 'Y' || con == 'y') {
			main.setHeader("List of Menus");

			System.out
					.println(String.format("%-10s %-10s %-15s %-10s", "Menu ID", "Menu Name", "Menu status", "Vendor"));

			for (Menu m : menuList) {

				System.out.println(m.toString());

			}

			int menuID = Helper.readInt("Enter Menu ID To View > ");

			boolean menuFound = true;

			for (int i = 0; i < menuList.size(); i++) {

				if (menuID != menuList.get(i).getMenu_id()) {

					System.out.println("Invalid Menu ID Entered !");
					break;

				}

			}

			if (menuFound == true) {

				main.setHeader("Menu ID : " + menuID + " Item List");

				String output = String.format("%-10s %-10s %-15s %-10s\n", "Item ID", "Item Name", "Item Description",
						"Item Price");
				for (int i = 0; i < itemList.size(); i++) {

					if (menuID == itemList.get(i).getMenu_id()) {

						output += String.format("%-10s %-10s %-15s $%-10s", itemList.get(i).getItem_id(),
								itemList.get(i).getItem_name(), itemList.get(i).getItem_description(),
								itemList.get(i).getItem_price());

					}
				}

				System.out.println(output);
				int itemID = Helper.readInt("Enter Item ID you would like to order > ");

				//

				boolean itemFound = false;

				for (int i = 0; i < itemList.size(); i++) {
					if (itemID == itemList.get(i).getItem_id()) {
						itemFound = true;

						String vendorName = itemList.get(i).getVendor_name();
						String itemName = itemList.get(i).getItem_name();
						double itemPrice = itemList.get(i).getItem_price();

						int qty = Helper.readInt("Enter No. Of Items > ");
						totalqty += qty;

						System.out.println("Item Name: " + itemName);
						System.out.println("Item Price: " + itemPrice);

						double totalPrice = itemPrice * qty;
						grandTotal += totalPrice;
						System.out.println("Total Price = " + totalPrice);

						con = Helper.readChar("Would You Like To Place Another Order? (Y/N) > ");

						if (con == 'N' || con == 'n') {

							System.out.println(String.format("%-10s %-10s %-25s %-10s %-10s", "No.", "Name",
									"Card Number", "CVC / CVV", "Expiry Date"));

							int number = 1;

							for (int j = 0; j < paymentList.size(); j++) {
								System.out.print(String.format("%-10s", number));
								System.out.println(paymentList.get(j).toString());
								number++;
							}

							int choice = Helper.readInt("Enter Method Payment Number > ");

							if (choice >= 1 && choice <= paymentList.size()) {

								System.out.println("Order Successfully placed !");
								orderList.add(new Order(orderList.size() + 1, totalqty, grandTotal, vendorName));
								parentMenu();

							} else {

								System.out.println("Invalid Number Entered !");
								parentMenu();

							}
						} else {
							System.out.println("Invalid Option");
							parentMenu();
						}
						break; // Exit the loop since the item is found
					}
				}

				if (!itemFound) {
					System.out.println("Invalid Item ID Entered !");
				}
			}
		}
	}

	private static Payment inputPayment(ArrayList<Payment> paymentList) {

		main.setHeader("Add Payment Method");

		String name = Helper.readString("Enter Name Displayed On The Card > ");
		String cardNo = Helper.readString("Enter Card Number > ");
		int cvc = Helper.readInt("Enter CVC / CVV > ");
		String exp = Helper.readString("Enter Expiration Date Of Card > ");

		Payment payment1 = new Payment(name, cardNo, cvc, exp);

		return payment1;

	}

	public static void addPayment(ArrayList<Payment> paymentList, Payment payment1) {

		boolean payFound = false;

		for (int i = 0; i < paymentList.size(); i++) {

			if (paymentList.get(i).getCardNo().equals(payment1.getCardNo())
					&& paymentList.get(i).getCvc() == payment1.getCvc()
					&& paymentList.get(i).getExpDate().equals(payment1.getExpDate())) {

				payFound = true;

				System.out.println("Current Payment Method Already Exists !");

				break;
			}

		}

		if (payFound == false) {

			if (!payment1.getName().isEmpty() && !payment1.getCardNo().isEmpty() && payment1.getCvc() != 0
					&& !payment1.getExpDate().isEmpty()) {

				if (payment1.getCvc() >= 100) {

					if (payment1.getCardNo().length() == 19) {

						paymentList.add(payment1);

						System.out.println("New Payment Successfully Added !");

					} else {

						System.out.println("Card Number Entered Does Not Meet The Requirements !");

					}

				} else {

					System.out.println("CVC Entered Does Not Meet The Requirements !");

				}

			} else {

				System.out.println("Information entered is incomplete !");

			}

		}

		parentMenu();
	}

	private static Vendor inputVendor(ArrayList<Vendor> vendorList) {

		main.setHeader("Add Vendor");

		int id = vendorList.size() + 1;
		String name = Helper.readString("Enter Vendor's Name > ");
		String contact = Helper.readString("Enter Vendor's Contact Number > ");
		String add = Helper.readString("Enter Vendor's Address > ");

		Vendor vendor1 = new Vendor(id, name, contact, add);

		return vendor1;

	}

	public static void addVendor(ArrayList<Vendor> vendorList, Vendor vendor1) {

		boolean vendFound = false;

		for (int i = 0; i < vendorList.size(); i++) {

			if (vendorList.get(i).getName().equalsIgnoreCase(vendor1.getName())

					&& vendorList.get(i).getAddress().equalsIgnoreCase(vendor1.getAddress())
					&& vendorList.get(i).getContactNo().equalsIgnoreCase(vendor1.getContactNo())) {

				vendFound = true;

				System.out.println("School Already Exists !");

				break;

			}

		}

		if (vendFound == false) {

			if (!vendor1.getName().isEmpty() && !vendor1.getAddress().isEmpty() && !vendor1.getContactNo().isEmpty()) {

				vendorList.add(vendor1);

				System.out.println("Vendor Successfully Added !");

			} else {

				System.out.println("Information Entered Is Incompelte !");

			}

		}

		adminMenu();
	}

	// =====================================view
	// users=====================================
	public static String retrieveAllUsers(ArrayList<User> userList) {

		String output = "";

		for (int i = 0; i < userList.size(); i++) {

			output += String.format(userList.get(i).toString());

		}

		return output;
	}

	public static String retrieveAllSchools(ArrayList<School> schoolList) {
		String output = "";

		for (int i = 0; i < schoolList.size(); i++) {

			output += String.format(schoolList.get(i).toString());

		}

		return output;
	}

	public static String retrieveAllMenus(ArrayList<Menu> menuList) {
		String output = "";

		for (int i = 0; i < menuList.size(); i++) {

			output += String.format("%-20s\n", menuList.get(i).toString());

		}

		return output;
	}

	public static String retrieveAllOrders(ArrayList<Order> orderList) {
		String output = "";

		for (int i = 0; i < orderList.size(); i++) {

			output += String.format("%-20s\n", orderList.get(i).toString());

		}

		return output;
	}

	public static String retrieveAllPayments(ArrayList<Payment> paymentList) {
		String output = "";

		for (int i = 0; i < paymentList.size(); i++) {

			output += String.format(paymentList.get(i).toString());

		}

		return output;
	}

	public static String retrieveAllVendors(ArrayList<Vendor> vendorList) {
		String output = "";

		for (int i = 0; i < vendorList.size(); i++) {

			output += String.format("%-20s\n", vendorList.get(i).toString());

		}

		return output;
	}

	public static void viewAllVendor(ArrayList<Vendor> vendorList) {

		main.setHeader("View All Vendors");
		String output = String.format("%-10s %-15s %-15s %-15s\n", "ID", "Name", "Contact No.", "Address");

		output += retrieveAllVendors(vendorList);

		System.out.println(output);

	}

	public static void viewAllUsers(ArrayList<User> userList) {

		main.setHeader("View All Parents/Guardians");
		String output = String.format("%-10s %-15s %-15s %-15s\n", "Name", "ID", "Contact No.", "Role", "School");

		output += retrieveAllUsers(userList);

		System.out.println(output);

	}

	public static void viewAllSchools(ArrayList<School> schoolList) {

		main.setHeader("View All Schools");
		String output = String.format("%-10s %-15s %-15s %-15s\n", "ID", "Name", "Address", "No. of orders");

		output += retrieveAllSchools(schoolList);

		System.out.println(output);

	}

	public static void viewAllMenus(ArrayList<Menu> menuList) {

		main.setHeader("View All Menus");
		String output = String.format("%-10s %-15s %-15s %-15s\n", "ID", "Name", "status", "Vendor Name");

		output += retrieveAllMenus(menuList);

		System.out.println(output);

	}

	public static void viewAllOrders(ArrayList<Order> orderList) {

		main.setHeader("View All Orders");
		String output = String.format("%-10s %-15s %-15s %-15s\n", "ID", "No. of items", "total cost", "Vendor Name");

		output += retrieveAllOrders(orderList);

		System.out.println(output);

	}

	public static void viewAllPayment(ArrayList<Payment> paymentList) {

		main.setHeader("View All Payments");
		String output = String.format("%-10s %-25s %-15s %-15s\n", "Name", "Card No.", "CVC", "Exp date");

		output += retrieveAllPayments(paymentList);

		System.out.println(output);

	}

	// ==================================delete users=============================

	// TODO ASJDADJDS
	public static boolean doDeleteUser(ArrayList<User> userList, int inputId) {
		boolean isDeleted = false;

		if (inputId == 0) {
			return false;
		}

		for (int i = 0; i < userList.size(); i++) {

			int id = userList.get(i).getId();

			if (id == inputId) {
				userList.remove(i);
				isDeleted = true;

			}
		}
		return isDeleted;

	}

	public static void deleteUser(ArrayList<User> userList) {
		main.viewAllUsers(userList);
		int id = Helper.readInt("Enter id > ");

		char yn = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");

		if (yn == 'Y' || yn == 'y') {

			Boolean isDeleted = doDeleteUser(userList, id);

			if (isDeleted == false) {
				System.out.println("Invalid id");
			} else {
				System.out.println("User ID : " + id + " deleted");
			}
		}

	}

	public static boolean doDeleteSchool(ArrayList<School> schoolList, int inputId) {
		boolean isDeleted = false;

		if (inputId == 0) {
			return false;
		}

		for (int i = 0; i < schoolList.size(); i++) {

			int id = schoolList.get(i).getSchool_id();

			if (id == inputId) {
				schoolList.remove(i);
				isDeleted = true;

			}
		}
		return isDeleted;

	}

	public static void deleteSchool(ArrayList<School> schoolList) {

		// parent
		main.viewAllSchools(schoolList);
		int id = Helper.readInt("Enter id > ");

		char yn = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");

		if (yn == 'Y' || yn == 'y') {

			Boolean isDeleted = doDeleteSchool(schoolList, id);

			if (isDeleted == false) {
				System.out.println("Invalid id");
			} else {
				System.out.println("School ID : " + id + " deleted");
			}
		}
	}

	public static boolean doDeleteMenu(ArrayList<Menu> menuList, int inputId) {
		boolean isDeleted = false;

		if (inputId == 0) {
			return false;
		}

		for (int i = 0; i < menuList.size(); i++) {

			int id = menuList.get(i).getMenu_id();

			if (id == inputId) {
				menuList.remove(i);
				isDeleted = true;

			}
		}
		return isDeleted;

	}

	public static void deleteMenu(ArrayList<Menu> menuList) {

		main.viewAllMenu();
		int id = Helper.readInt("Enter id > ");

		char yn = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");

		if (yn == 'Y' || yn == 'y') {

			Boolean isDeleted = doDeleteMenu(menuList, id);

			if (isDeleted == false) {
				System.out.println("Invalid id");
			} else {
				System.out.println("Menu ID : " + id + " deleted");
			}
		}
	}

	public static boolean doDeleteOrder(ArrayList<Order> orderList, int inputId) {
		boolean isDeleted = false;

		if (inputId == 0) {
			return false;
		}

		for (int i = 0; i < orderList.size(); i++) {

			int id = orderList.get(i).getOrder_id();

			if (id == inputId) {
				orderList.remove(i);
				isDeleted = true;

			}
		}
		return isDeleted;

	}

	public static void deleteOrder(ArrayList<Order> orderList) {

		// parent
		main.viewAllOrders(orderList);
		int id = Helper.readInt("Enter id > ");

		char yn = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");

		if (yn == 'Y' || yn == 'y') {

			Boolean isDeleted = doDeleteOrder(orderList, id);

			if (isDeleted == false) {
				System.out.println("Invalid id");
			} else {
				System.out.println("Order ID : " + id + " deleted");
			}
		}
	}

	public static boolean doDeletePayment(ArrayList<Payment> paymentList, String name) {
		boolean isDeleted = false;

		if (name.isEmpty()) {
			return false;
		}

		for (int i = 0; i < paymentList.size(); i++) {

			String name2 = paymentList.get(i).getName();

			if (name == name2) {
				paymentList.remove(i);
				isDeleted = true;

			}
		}
		return isDeleted;

	}

	public static void deletePayment(ArrayList<Payment> paymentList) {

		// parent
		main.viewAllPayment(paymentList);
		String name = Helper.readString("Enter Name > ");

		char yn = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");

		if (yn == 'Y' || yn == 'y') {

			Boolean isDeleted = doDeletePayment(paymentList, name);

			if (isDeleted == false) {
				System.out.println("Invalid name");
			} else {
				System.out.println("Payment method belonging to : " + name + " deleted");
			}
		}

	}

	public static boolean doDeleteVendor(ArrayList<Vendor> vendorList, int inputId) {
		boolean isDeleted = false;

		if (inputId == 0) {
			return false;
		}

		for (int i = 0; i < vendorList.size(); i++) {

			int id = vendorList.get(i).getId();

			if (id == inputId) {
				vendorList.remove(i);
				isDeleted = true;

			}
		}
		return isDeleted;

	}

	public static void deleteVendor(ArrayList<Vendor> vendorList) {

		main.viewAllVendor(vendorList);
		int id = Helper.readInt("Enter id > ");

		char yn = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");

		if (yn == 'Y' || yn == 'y') {

			Boolean isDeleted = doDeleteVendor(vendorList, id);

			if (isDeleted == false) {
				System.out.println("Invalid id");
			} else {
				System.out.println("Vendor ID : " + id + " deleted");
			}
		}
	}
}