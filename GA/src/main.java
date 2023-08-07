import java.util.ArrayList;

public class main {

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


//		User u1 = new User("name", 1, "contact number", "role");
//		userList.add(u1);

		int option = 0;

		while (option != 4) {
			startMenu();

			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				parentMenu();

				int parentOption = 0;
				while (parentOption != 9) {

					parentOption = Helper.readInt("Enter Option > ");

					if (parentOption == 1) {

						User u1 = inputUser(userList);
						addUser(userList, u1);

					} else if (parentOption == 2) {
						// view
						main.setHeader("View Menu");

						System.out.println(String.format("%-10s %-10s %-15s %-10s", "Menu ID", "Menu Name",
								"Menu status", "Vendor"));

						for (Menu m : menuList) {

							System.out.println(m.toString());

						}
						parentMenu();

					} else if (parentOption == 3) {
						// TODO

						addOrder(orderList, menuList, itemList, paymentList);

					} else if (parentOption == 4) {
						// cancel order

						int check = 0;

						Helper.line(50, "-");
						System.out.println("Cancel Order");
						Helper.line(50, "-");

						int delOrder = Helper.readInt("Enter Order ID for Cancellation > ");
						char delOrderCfm = Helper.readChar("Enter Cancellation Confirmation (Y/N) > ");
						if (delOrderCfm == 'Y' || delOrderCfm == 'y') {
							for (int i = 0; i < orderList.size(); i++) {
								if (delOrder == (orderList.get(i).getOrder_id())) {
									orderList.remove(i);
									System.out.println("Order Cancelled");
									check++;
									break;
								}
							}
							if (check == 0) {
								System.out.println("Order Not Found");
							}
						}
						parentMenu();

					} else if (parentOption == 5) {
						// view order
						main.setHeader("View Order");

						System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "Order ID", "No.of Items",
								"Total Cost", "Vendor Name", "Order Status"));

						for (Order o : orderList) {

							System.out.println(o.toString());
						}
						parentMenu();

					} else if (parentOption == 6) {
						// add payment

						Payment payment1 = inputPayment(paymentList);
						addPayment(paymentList, payment1);

					} else if (parentOption == 7) {
						// edit payment

						int check = 0;

						Helper.line(50, "-");
						System.out.println("Edit Payment Method");
						Helper.line(50, "-");

						String delCard = Helper.readString("Enter Card Number To Be Deleted > ");
						char delPayCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
						if (delPayCfm == 'Y' || delPayCfm == 'y') {
							for (int i = 0; i < paymentList.size(); i++) {
								if (delCard.equals(paymentList.get(i).getCardNo())) {
									paymentList.remove(i);
									System.out.println("Card Deleted From System");
									check++;
									break;
								}
							}
							if (check == 0) {
								System.out.println("Card Not Found");
							}
						}
						parentMenu();

					} else if (parentOption == 8) {
						// view payment

						retrieveAllPayments(paymentList);
						viewAllPayment(paymentList);
						parentMenu();
					
					}

					else if (parentOption == 9) {
						System.out.println("Returning to menu...");
						break;

					} else {
						System.out.println("Invalid option!");
						parentMenu();
					}
				}

			} else if (option == 2) {
				vendorMenu();

				int vendorOption = 0;

				while (vendorOption != 5) {

					vendorOption = Helper.readInt("Enter option > ");

					if (vendorOption == 1) {
						// Add menu

						Menu menu1 = inputMenu(menuList);
						addMenu(menuList,menu1);

						char con = 'Y';

						while (con == 'Y' || con == 'y') {
							Item item1 = inputItem(itemList, menu1);
							addItem(itemList, item1);
							con = Helper.readChar("Continue Adding Items to " + menu1.getMenu_name() + " (Y/N) > ");

							if (con == 'N' || con == 'n') {
								vendorMenu();
							}
						}

					} else if (vendorOption == 2) {
						// edit menu
						editMenuMenu();
						int checkItem = 0;
						int checkMenu = 0;

						option = Helper.readInt("Enter an option > ");

						if (option == 1) {

							int editMenu = Helper.readInt("Enter Menu ID To Be Edited > ");

							for (int i = 0; i < menuList.size(); i++) {
								if (editMenu == (menuList.get(i).getMenu_id())) {
									int editItem = Helper.readInt("Enter Item ID To Be Edited > ");
									Helper.line(50, "-");
									checkMenu++;

									for (int m = 0; m < itemList.size(); m++) {
										if (editItem == (itemList.get(m).getItem_id())) {
											System.out.println(String.format(
													"Item ID: %d \nItem Name: %s \nItem Description: %s \nItem Price: %.2f",
													itemList.get(m).getItem_id(), itemList.get(m).getItem_name(),
													itemList.get(m).getItem_description(),
													itemList.get(m).getItem_price()));
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
						} else if (option == 2) {
							int check2 = 0;

							Helper.line(50, "-");
							System.out.println("Delete Menu");
							Helper.line(50, "-");

							int delMenu = Helper.readInt("Enter Menu ID To Be Deleted > ");
							char delMenuCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
							if (delMenuCfm == 'Y' || delMenuCfm == 'y') {
								for (int i = 0; i < menuList.size(); i++) {
									if (delMenu == (menuList.get(i).getMenu_id())) {
										menuList.remove(i);
										System.out.println("Menu Deleted From System");
										check2++;
										break;
									}
								}
								if (check2 == 0) {
									System.out.println("Menu Not Found");
								}
							}
						} else if (option == 3) {
							System.out.println("Goodbye!");
						} else {
							System.out.println("Invalid Option");
						}
						vendorMenu();

					} else if (vendorOption == 3) {
						// manage details
						int check = 0;
						main.setHeader("Edit Vendor Details");

						int vendorId = Helper.readInt("Enter Vendor ID > ");
						for (int i = 0; i < vendorList.size(); i++) {
							if (vendorId == (vendorList.get(i).getId())) {
								System.out.println(String.format(
										"Vendor ID: %d \nVendor Name: %s \nVendor Contact Number: %s \nVendor Address: %s",
										vendorList.get(i).getId(), vendorList.get(i).getName(),
										vendorList.get(i).getContactNo(), vendorList.get(i).getAddress()));
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
					} else if (vendorOption == 4) {
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
						vendorMenu();

					} else if (vendorOption == 5) {
						System.out.println("Returning to Menu...");
					} else {
						System.out.println("Invalid option!");
						vendorMenu();
					}

				}
			} else if (option == 3) {
				adminMenu();

				int adminOption = 0;

				while (adminOption != 9) {
					adminOption = Helper.readInt("Enter option > ");
					if (adminOption == 1) {
						// add school

						School school1 = inputSchool(schoolList);
						addSchool(schoolList, school1);

					} else if (adminOption == 2) {
						// edit school
						editSchoolMenu();
						int check = 0;

						option = Helper.readInt("Enter an option > ");

						if (option == 1) {
							int schoolId = Helper.readInt("Enter School ID > ");
							for (int i = 0; i < schoolList.size(); i++) {
								if (schoolId == (schoolList.get(i).getSchool_id())) {
									System.out.println(String.format(
											"School ID: %d \nSchool Name: %s \nSchool Address: %s \nSchool No. of Orders: %d",
											schoolList.get(i).getSchool_id(), schoolList.get(i).getName(),
											schoolList.get(i).getAddress(), schoolList.get(i).getNoOfOrders()));
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

						else if (option == 2) {
							int check2 = 0;

							Helper.line(50, "-");
							System.out.println("Delete School");
							Helper.line(50, "-");

							int delSchool = Helper.readInt("Enter School ID To Be Deleted > ");
							char delSchoolCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
							if (delSchoolCfm == 'Y' || delSchoolCfm == 'y') {
								for (int i = 0; i < schoolList.size(); i++) {
									if (delSchool == (schoolList.get(i).getSchool_id())) {
										schoolList.remove(i);
										System.out.println("School Deleted From System");
										check2++;
										break;
									}
								}
								if (check2 == 0) {
									System.out.println("School Not Found");
								}
							}
						}
						adminMenu();

					} else if (adminOption == 3) {

						Vendor vendor1 = inputVendor(vendorList);
						addVendor(vendorList, vendor1);

					} else if (adminOption == 4) {
						// view all orders
						main.setHeader("View all Orders");

						System.out.println(String.format("%-10s %-15s %-15s %-15s %s", "Order ID", "No. of items",
								"Total cost", "Vendor Name", "Order Status"));

						for (Order o : orderList) {

							System.out.println(o.toString());
						}
						adminMenu();
					} else if (adminOption == 5) {
						// view all users
						int userOption = 0;
						viewAllMenu();
						while (userOption != 4) {
							userOption = Helper.readInt("Enter option > ");
							if (userOption == 1) {
								// parent

								retrieveAllUsers(userList);
								viewAllUsers(userList);

							} else if (userOption == 2) {
								// school

								retrieveAllSchools(schoolList);
								viewAllSchools(schoolList);
								viewAllMenu();
							} else if (userOption == 3) {
								// vendor

								main.setHeader("View All Vendors");

								System.out.println(String.format("%-10s %-15s %-10s %-15s", "ID", "Name", "Contact No.",
										"Address"));

								for (Vendor v : vendorList) {

									System.out.println(v.toString());
								}
								viewAllMenu();
							} else if (userOption == 4) {
								System.out.println("Goodbye");
								adminMenu();
							} else {
								System.out.println("Invalid Option");
							}
						}
					} else if (adminOption == 6) {
						// generate reports
						main.setHeader("REPORT");
						System.out.println("Total Number of Users: " + userList.size());
						System.out.println("Total Number of Schools: " + schoolList.size());
						System.out.println("Total Number of Vendors: " + vendorList.size());
						adminMenu();
					} else if (adminOption == 7) {
						// delete user accounts
						int deleteOption = 0;
						deleteMenu();

						deleteOption = Helper.readInt("Enter option > ");
						if (deleteOption == 1) {
							// parent
							deleteUser(userList);
							adminMenu();
						} else if (deleteOption == 2) {
							// school
							int check = 0;
							int delID = Helper.readInt("Enter School ID > ");

							char delSchoolCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
							if (delSchoolCfm == 'Y' || delSchoolCfm == 'y') {
								for (int i = 0; i < schoolList.size(); i++) {
									if (delID == (schoolList.get(i).getSchool_id())) {
										schoolList.remove(i);
										System.out.println("School Deleted From System");
										check++;
										break;
									}
								}
								if (check == 0) {
									System.out.println("School Not Found");
								}
							}
							adminMenu();
						} else if (deleteOption == 3) {
							// vendor
							int check = 0;
							int delID = Helper.readInt("Enter Vendor ID > ");

							for (int i = 0; i < vendorList.size(); i++) {
								if (delID == (vendorList.get(i).getId())) {
									char delVendorCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");

									if (delVendorCfm == 'Y' || delVendorCfm == 'y') {
										vendorList.remove(i);
										System.out.println("Vendor Deleted From System");
										check++;
										adminMenu();
										break;

									} else if (delVendorCfm == 'N' || delVendorCfm == 'n') {
										System.out.println("vendor not deleted");
										adminMenu();
										break;
									} else {
										System.out.println("Invalid option!");
										adminMenu();
										break;
									}

								}
								if (check == 0) {
									System.out.println("Vendor Not Found");
								}
								adminMenu();
							}
						} else if (deleteOption == 4) {
							System.out.println("Return");
							adminMenu();
						}

					} else if (adminOption == 8) {
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
					} else if (adminOption == 9) {
						System.out.println("Returning to Menu...");
					} else {
						System.out.println("Invalid option!");
						adminMenu();
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
		System.out.println("3. Place order");
		System.out.println("4. Cancel Order");
		System.out.println("5. View status of orders ");
		System.out.println("6. Add payment method");
		System.out.println("7. Edit payment method");
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
		System.out.println("6. Generate reports");
		System.out.println("7. Delete user accounts");
		System.out.println("8. Search Order");
		System.out.println("9. Return to user selection");
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

		User u1 = new User(name, id, contactNum, role);

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

	public static void addSchool(ArrayList<School> schoolList, School school1) {

		boolean schFound = false;

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

						output += String.format("%-10s %-10s %-15s $%-10s\n", itemList.get(i).getItem_id(),
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

				vendorList.add(
						new Vendor(vendor1.getId(), vendor1.getName(), vendor1.getContactNo(), vendor1.getAddress()));

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

	public static void viewAllUsers(ArrayList<User> userList) {

		main.setHeader("View All Parents/Guardians");
		String output = String.format("%-10s %-15s %-15s %-15s", "Name", "ID", "Contact No.", "Role");

		output += retrieveAllUsers(userList);

		System.out.println(output);

	}

	public static void viewAllSchools(ArrayList<School> schoolList) {

		main.setHeader("View All Schools");
		String output = String.format("%-10s %-15s %-15s %-15s", "ID", "Name", "Address", "No. of orders");

		output += retrieveAllSchools(schoolList);

		System.out.println(output);

	}

	public static void viewAllMenus(ArrayList<Menu> menuList) {

		main.setHeader("View All Menus");
		String output = String.format("%-10s %-15s %-15s %-15s", "ID", "Name", "status", "Vendor Name");

		output += retrieveAllMenus(menuList);

		System.out.println(output);

	}

	public static void viewAllOrders(ArrayList<Order> orderList) {

		main.setHeader("View All Orders");
		String output = String.format("%-10s %-15s %-15s %-15s", "ID", "No. of items", "total cost", "Vendor Name");

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
	public static void deleteUser(ArrayList<User> userList) {

		// parent
		int check = 0;
		int delID = Helper.readInt("Enter Parent/Guardian ID > ");

		char delUserCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
		if (delUserCfm == 'Y' || delUserCfm == 'y') {
			for (int i = 0; i < userList.size(); i++) {
				if (delID == (userList.get(i).getId())) {
					userList.remove(i);
					System.out.println("User Deleted From System");
					check++;
					break;
				}
			}
			if (check == 0) {
				System.out.println("User Not Found");
			}
		}

	}

	public static void deleteSchool(ArrayList<School> schoolList) {

		// parent
		int check = 0;
		int delID = Helper.readInt("Enter Parent/Guardian ID > ");

		char delSchoolCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
		if (delSchoolCfm == 'Y' || delSchoolCfm == 'y') {
			for (int i = 0; i < schoolList.size(); i++) {
				if (delID == (schoolList.get(i).getSchool_id())) {
					schoolList.remove(i);
					System.out.println("SChool Deleted From System");
					check++;
					break;
				}
			}
			if (check == 0) {
				System.out.println("School Not Found");
			}
		}

	}

	public static void deleteMenu(ArrayList<Menu> menuList) {

		// parent
		int check = 0;
		int delID = Helper.readInt("Enter Parent/Guardian ID > ");

		char delMenuCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
		if (delMenuCfm == 'Y' || delMenuCfm == 'y') {
			for (int i = 0; i < menuList.size(); i++) {
				if (delID == (menuList.get(i).getMenu_id())) {
					menuList.remove(i);
					System.out.println("Menu Deleted From System");
					check++;
					break;
				}
			}
			if (check == 0) {
				System.out.println("Menu Not Found");
			}
		}

	}

	public static void deleteOrder(ArrayList<Order> orderList) {

		// parent
		int check = 0;
		int delID = Helper.readInt("Enter Parent/Guardian ID > ");

		char delOrderCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
		if (delOrderCfm == 'Y' || delOrderCfm == 'y') {
			for (int i = 0; i < orderList.size(); i++) {
				if (delID == (orderList.get(i).getOrder_id())) {
					orderList.remove(i);
					System.out.println("Order Deleted From System");
					check++;
					break;
				}
			}
			if (check == 0) {
				System.out.println("Order Not Found");
			}
		}

	}

	public static void deletePayment(ArrayList<Payment> paymentList) {

		// parent
		int check = 0;
		String delName = Helper.readString("Enter Parent/Guardian ID > ");

		char delPayCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
		if (delPayCfm == 'Y' || delPayCfm == 'y') {
			for (int i = 0; i < paymentList.size(); i++) {
				if (delName.equalsIgnoreCase(paymentList.get(i).getName())) {
					paymentList.remove(i);
					System.out.println("Payment Deleted From System");
					check++;
					break;
				}
			}
			if (check == 0) {
				System.out.println("Payment Not Found");
			}
		}

	}

	public static void deleteVendor(ArrayList<Vendor> vendorList) {

		// parent
		int check = 0;
		int delID = Helper.readInt("Enter Parent/Guardian ID > ");

		char delVendorCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
		if (delVendorCfm == 'Y' || delVendorCfm == 'y') {
			for (int i = 0; i < vendorList.size(); i++) {
				if (delID == (vendorList.get(i).getId())) {
					vendorList.remove(i);
					System.out.println("Vendor Deleted From System");
					check++;
					break;
				}
			}
			if (check == 0) {
				System.out.println("Vendor Not Found");
			}
		}

	}

}
