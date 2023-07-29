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
						
						
						for(int i = 0; i < userList.size(); i++) {
							
							if (userList.get(i).getName().equalsIgnoreCase(name) 
									&& userList.get(i).getContactNum().equalsIgnoreCase(contactNum)) {
								
								System.out.println("User already has an existing account !");
								
							}else if(role.equalsIgnoreCase("parent") == false || role.equalsIgnoreCase("guardian") == false) {
								
								System.out.println("Invalid input for 'Parent / Guardian !");
								
							}else {
								
								userList.add(new User(name, id, contactNum, role));

							}
							
						}
						parentMenu();

					} else if (parentOption == 2) {
						// view
						main.setHeader("View Menu");
						for (Menu m : menuList) {
							
							System.out.println(String.format("%-10s %-10s %10s", "Menu ID", "Menu Name", "Menu status"));

							System.out.println(m.toString());
							break;
						}
						parentMenu();
						
					} else if (parentOption == 3) {
						// view status of order
						main.setHeader("View Order status");
						for (OrderStatus o : orderStatusList) {
							
							System.out.println(String.format("%-10s %-30s", "Order ID", "Order Status"));

							System.out.println(o.toString());
						}
						parentMenu();

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
						parentMenu();

					} else if (parentOption == 5) {
						// edit payment
						
						int check = 0;
						
						Helper.line(50, "-");
						System.out.println("Edit Payment Method");
						Helper.line(50, "-");
						
						String delCard = Helper.readString("Enter Card Number To Be Deleted > ");
						char delPayCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
						if (delPayCfm == 'Y') {
							for(int i = 0; i < paymentList.size();i++) {
								if (delCard.equals(paymentList.get(i).getCardNo())){
									paymentList.remove(i);
									System.out.println("Card Deleted From System");
									check++;
									break;
								}
							}
							if(check == 0) {
								System.out.println("Card Not Found");
							}
						}
						parentMenu();
						
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
						editMenuMenu();
						int checkItem = 0;
						int checkMenu = 0;
						
						option = Helper.readInt("Enter an option > ");

						if (option == 1) {
							
							int editMenu = Helper.readInt("Enter Menu ID To Be Edited > ");
							
							for(int i = 0; i < menuList.size();i++) {
								if (editMenu == (menuList.get(i).getMenu_id())){
									int editItem = Helper.readInt("Enter Item ID To Be Edited > ");
									Helper.line(50,"-");
									checkMenu++;
									
									for(int m = 0; m < itemList.size();m++) {
										if (editItem == (itemList.get(m).getItem_id())){
											System.out.println(String.format("Item ID: %d \nItem Name: %s \nItem Description: %s \nItem Price: %.2f",itemList.get(m).getItem_id(),itemList.get(m).getItem_name(),itemList.get(m).getItem_description(),itemList.get(m).getItem_price()));
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
									if(checkItem == 0) {
										System.out.println("Item Not Found");
									}
								}
							}
							if(checkMenu == 0) {
								System.out.println("Menu Not Found");
							}
						}
						else if(option == 2){
							int check2 = 0;
							
							Helper.line(50, "-");
							System.out.println("Delete Menu");
							Helper.line(50, "-");
							
							int delMenu = Helper.readInt("Enter Menu ID To Be Deleted > ");
							char delMenuCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
							if (delMenuCfm == 'Y') {
								for(int i = 0; i < menuList.size();i++) {
									if (delMenu == (menuList.get(i).getMenu_id())){
										menuList.remove(i);
										System.out.println("Menu Deleted From System");
										check2++;
										break;
									}
								}
								if(check2 == 0) {
									System.out.println("Menu Not Found");
								}
							}
						}
						else if(option == 3){
							System.out.println("Goodbye!");
						}
						else {
							System.out.println("Invalid Option");
						}
						vendorMenu();
						
					} else if (vendorOption == 3) {
						// manage details
						int check = 0;
						main.setHeader("Edit Vendor Details");
						
						int vendorId = Helper.readInt("Enter Vendor ID > ");
						for(int i = 0; i < vendorList.size();i++) {
							if (vendorId == (vendorList.get(i).getId())){
								System.out.println(String.format("Vendor ID: %d \nVendor Name: %s \nVendor Contact Number: %s \nVendor Address: %s",vendorList.get(i).getId(),vendorList.get(i).getName(),vendorList.get(i).getContactNo(),vendorList.get(i).getAddress()));
								String newNum = Helper.readString("Enter Vendor's Updated Contact Number > ");
								String newAddress = Helper.readString("Enter Vendor's Updated Address > ");
								vendorList.get(i).setContactNo(newNum);
								vendorList.get(i).setAddress(newAddress);
								check++;
								System.out.println("Updated Successfully");
								break;
							}
						}
						if(check == 0) {
							System.out.println("Vendor Not Found");
						}
						vendorMenu();
					} else if (vendorOption == 4) {
						System.out.println("Goodbye!");
					} else {
						System.out.println("Invalid option!");
					}

				}
			} else if (option == 3) {
				adminMenu();

				int adminOption = 0;

				while (adminOption != 8) {
					adminOption = Helper.readInt("Enter option > ");
					if (adminOption == 1) {
						// add school

						int id = schoolList.size() + 1;
						String name = Helper.readString("Enter School Name > ");
						String add = Helper.readString("Enter School's Address > ");

						schoolList.add(new School(id, name, add));

					} else if (adminOption == 2) {
						// edit school
						editSchoolMenu();
						int check = 0;
			
						option = Helper.readInt("Enter an option > ");
						
					
						if (option == 1) {	
							int schoolId = Helper.readInt("Enter School ID > ");
							for(int i = 0; i < schoolList.size();i++) {
								if (schoolId == (schoolList.get(i).getSchool_id())){
									System.out.println(String.format("School ID: %d \nSchool Name: %s \nSchool Address: %s \nSchool No. of Orders: %d",schoolList.get(i).getSchool_id(),schoolList.get(i).getName(),schoolList.get(i).getAddress(),schoolList.get(i).getNoOfOrders()));
									String newAddress = Helper.readString("Enter School's Updated Address > ");
									schoolList.get(i).setAddress(newAddress);
									check++;
									System.out.println("Updated Successfully");
									break;
								}
							}
							
							if(check == 0) {
								System.out.println("School Not Found");
							}
						}
						
						else if(option == 2){
							int check2 = 0;
							
							Helper.line(50, "-");
							System.out.println("Delete School");
							Helper.line(50, "-");
							
							int delSchool = Helper.readInt("Enter School ID To Be Deleted > ");
							char delSchoolCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
							if (delSchoolCfm == 'Y') {
								for(int i = 0; i < schoolList.size();i++) {
									if (delSchool == (schoolList.get(i).getSchool_id())){
										schoolList.remove(i);
										System.out.println("School Deleted From System");
										check2++;
										break;
									}
								}
								if(check2 == 0) {
									System.out.println("School Not Found");
								}
							}
						}
						adminMenu();
						
					} else if (adminOption == 3) {
						// view all orders
						main.setHeader("View all orders");
						for (Order o : orderList) {
							
							System.out.println(String.format("%-10s %-15s %10s %15s", "Order ID", "No. of items",
									"Total cost", "Vendor Name"));

							System.out.println(o.toString());
						} adminMenu();
					} else if (adminOption == 4) {
						// View all order status
						main.setHeader("View All Order Statuses");
						for (OrderStatus os : orderStatusList) {
							
							System.out.println(String.format("%-10s %-15s", "Order ID", "Status"));

							System.out.println(os.toString());
						}adminMenu();
					} else if (adminOption == 5) {
						// view all users
						int userOption = 0;
						viewAllMenu();
						while (userOption != 4) {
							userOption = Helper.readInt("Enter option > ");
							if (userOption == 1) {
								// parent
								main.setHeader("View All Parents/Guardians");
								System.out.println(String.format("%-10s %-15s %10s %15s", "Name", "ID",
										"Contact No.", "Role"));
								for (User u : userList) {
									
									

									System.out.println(u.toString());
								}adminMenu();
							} else if (userOption == 2) {
								// school
								main.setHeader("View All Schools");
								for (School s : schoolList) {
									
									System.out.println(String.format("%-10s %-15s %10s %15s", "School ID", "Name",
											"Address", "No. of orders"));

									System.out.println(s.toString());
								}adminMenu();
							} else if (userOption == 3) {
								// vendor
								main.setHeader("View All Vendors");
								for (Vendor v : vendorList) {
									
									System.out.println(String.format("%-10s %-15s %10s %15s", "ID", "Name",
											"Contact No.", "Address"));
									
									System.out.println(v.toString());
								}adminMenu();
							} else if (userOption == 4) {
								System.out.println("Goodbye");
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
								int check = 0;
								int delID = Helper.readInt("Enter Parent/Guardian ID > ");
								
								char delUserCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
								if (delUserCfm == 'Y') {
									for(int i = 0; i < userList.size();i++) {
										if (delID == (userList.get(i).getId())){
											userList.remove(i);
											System.out.println("User Deleted From System");
											check++;
											break;
										}
									}
									if(check == 0) {
										System.out.println("User Not Found");
									}
								}
								
							} else if (deleteOption == 2) {
								// school
								int check = 0;
								int delID = Helper.readInt("Enter School ID > ");
								
								char delSchoolCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
								if (delSchoolCfm == 'Y') {
									for(int i = 0; i < schoolList.size();i++) {
										if (delID == (schoolList.get(i).getSchool_id())){
											schoolList.remove(i);
											System.out.println("School Deleted From System");
											check++;
											break;
										}
									}
									if(check == 0) {
										System.out.println("School Not Found");
									}
								}
							} else if (deleteOption == 3) {
								// vendor
								int check = 0;
								int delID = Helper.readInt("Enter Vendor ID > ");
								
								char delVendorCfm = Helper.readChar("Enter Deletion Confirmation (Y/N) > ");
								if (delVendorCfm == 'Y') {
									for(int i = 0; i < vendorList.size();i++) {
										if (delID == (vendorList.get(i).getId())){
											vendorList.remove(i);
											System.out.println("Vendor Deleted From System");
											check++;
											break;
										}
									}
									if(check == 0) {
										System.out.println("Vendor Not Found");
									}
								}
							} 
							else if (deleteOption == 4) {
								System.out.println("Goodbye");
							}
							adminMenu();
						}
					 else if (adminOption == 8) {
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
		System.out.println("6. Return to user selection");
	}

	private static void vendorMenu() {
		main.setHeader("Vendor Menu");
		System.out.println("1. Add menu");
		System.out.println("2. Edit menu");
		System.out.println("3. Manage Details");
		System.out.println("4. Return to user selection");
	}

	private static void adminMenu() {
		main.setHeader("Admin Menu");
		System.out.println("1. Add school");
		System.out.println("2. Edit school");
		System.out.println("3. View all Orders");
		System.out.println("4. View order status");
		System.out.println("5. View all users");
		System.out.println("6. Generate reports");
		System.out.println("7. Delete user accounts");
		System.out.println("8. Return to user selection");
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
		// TODO Auto-generated method stub
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

}
