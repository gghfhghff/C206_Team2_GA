
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test {
	private User guardian1;
	private User parent1;
	private Menu menu1;
	private Menu menu2;
	private Order order1;
	private Order order2;
	private School school1;
	private School school2;

	private Vendor vendor1;
	private Vendor vendor2;
	private Payment payment1;
	private Payment payment2;
	private Item item1;
	private Item item2;

	ArrayList<User> userList = new ArrayList<User>();
	ArrayList<School> schoolList = new ArrayList<School>();
	ArrayList<Menu> menuList = new ArrayList<Menu>();
	ArrayList<Order> orderList = new ArrayList<Order>();
	
	ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
	ArrayList<Payment> paymentList = new ArrayList<Payment>();
	ArrayList<Item> itemList = new ArrayList<Item>();

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		payment1 = new Payment("Bob", "1234 5678 1234 5678", 321, "12/11/2030");
		payment2 = new Payment("Bobby", "1234 5678 1239 9239", 123, "10/01/2031");

		vendor1 = new Vendor(1, "JOSH Pte Ltd", "1233 4566", "21 Jerry Street");
		vendor2 = new Vendor(1, "MATT Pte Ltd", "1212 3434", "11 Adriel Circle");

		menu1 = new Menu(1, "MACDONALDS", "Ongoing", "JOSH Pte Ltd");
		menu2 = new Menu(2, "KFC", "Paused", "MATT Pte Ltd");

		item1 = new Item(001, 001, "Chicken Rice", "Matthias Favourite", 4.0);
		item2 = new Item(001, 002, "Nasi Lemak", "Matthis Second Favourite", 5.0);

		school1 = new School(001, "MATTHIS Primary School", "10 Matthis Avenue", 10);
		school2 = new School(002, "JIAN Sparkletots", "6 Glenda Avenue", 5);

		order1 = new Order(001, 10, 50.0, "JOSH Pte Ltd");
		order2 = new Order(002, 5, 10.0, "JOSH Pte Ltd");

		parent1 = new User("John Doe", 001, "1234 5678", "Parent","MATTHIS Primary School");
		guardian1 = new User("Josh Tan", 002, "8765 4321", "Guardian", "JIAN Sparkletots");
		
		
	}

	// ---------------------add-----------------
	@Test
	public void testAddNewUser() {
		// User List is not null, able to add new item - normal
		assertNotNull("Check if there is valid User arraylist to add to", userList);

		// Add new user to the user list
		userList.add(parent1);
		
		// test duplicate
		User parent2 = new User("John Doe", 001, "1234 5678", "Parent","MATTHIS Primary School");
	
		assertFalse("ChECK DUPLCIATE", userList.contains(parent2));
		assertFalse("dont add",main.addUser(userList, parent2) );
		
		// Test that the list of the size will increase by 1 after it has been added - boundary
		assertEquals("Check that the list size is 1 after it has been added", 1, userList.size());
		assertSame("Check that User is added", parent1, userList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		main.addUser(userList, guardian1);
		assertEquals("Check that User arraylist size is 2", 2, userList.size());
		assertSame("Check that User is added", guardian1, userList.get(1));

	}
	
	@Test
	public void testAddNewSchool() {
		// School List is not null, able to add new item
		assertNotNull("Check if there is valid School arraylist to add to", schoolList);

		// Add new School to the school list
		schoolList.add(school1);
		
		// test duplicate
		School school3 = new School(001, "MATTHIS Primary School", "10 Matthis Avenue", 10);
	
		assertFalse("ChECK DUPLCIATE", schoolList.contains(school3));
		assertFalse("dont add",main.addSchool(schoolList, school3) );

		// Test that the list of the size will increase by 1 after it has been added
		assertEquals("Check that the list size is 1 after it has been added", 1, schoolList.size());
		assertSame("Check that School is added", school1, schoolList.get(0));
		
	
		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		main.addSchool(schoolList, school2);
		assertEquals("Check that School arraylist size is 2", 2, schoolList.size());
		assertSame("Check that School is added", school2, schoolList.get(1));

	}
	
	@Test
	public void testAddMenu() {
		// Menu List is not null, able to add new item
		assertNotNull("Check if there is valid Menu arraylist to add to", menuList);

		// Add new user to the menu list
		menuList.add(menu1);
		
		// test duplicate
		Menu menu3 = new Menu(1, "MACDONALDS", "Ongoing", "JOSH Pte Ltd");
	
		assertFalse("ChECK DUPLCIATE", menuList.contains(menu3));
		assertFalse("dont add",main.addMenu(menuList, menu3));

		// Test that the list of the size will increase by 1 after it has been added
		assertEquals("Check that the list size is 1 after it has been added", 1, menuList.size());
		assertSame("Check that Menu is added", menu1, menuList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		main.addMenu(menuList, menu2);
		assertEquals("Check that Menu arraylist size is 2", 2, menuList.size());
		assertSame("Check that Menu is added", menu2, menuList.get(1));
	}
	
	@Test
	public void testAddNewOrder() {
		// Order List is not null, able to add new item
		assertNotNull("Check if there is valid Order arraylist to add to", orderList);

		// Add new user to the order list
		orderList.add(order1);
		
		// Test that the list of the size will increase by 1 after it has been added
		assertEquals("Check that the list size is 1 after it has been added", 1, orderList.size());
		assertSame("Check that Order is added", order1, orderList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		orderList.add(order2);
		assertEquals("Check that Order arraylist size is 2", 2, orderList.size());
		assertSame("Check that Order is added",order2, orderList.get(1));

	}
	
	@Test
	public void testAddNewPayment() {
		// Payment List is not null, able to add new item
		assertNotNull("Check if there is valid Payment arraylist to add to", paymentList);

		// Add new payment to the payment list
		paymentList.add(payment1);
		
		// test duplicate
		Payment payment3 =  new Payment("Bob", "1234 5678 1234 5678", 321, "12/11/2030");
	
		assertFalse("ChECK DUPLCIATE", paymentList.contains(payment3));
		assertFalse("dont add",main.addPayment(paymentList, payment3));
		
		// Test that the list of the size will increase by 1 after it has been added
		assertEquals("Check that the list size is 1 after it has been added", 1, paymentList.size());
		assertSame("Check that Payment is added", payment1, paymentList.get(0));
	
		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		main.addPayment(paymentList, payment2);
		assertEquals("Check that Payment arraylist size is 2", 2, paymentList.size());
		assertSame("Check that Payment is added", payment2, paymentList.get(1));

	}
	
	@Test
	public void testAddNewVendor() {
		// User List is not null, able to add new item
		assertNotNull("Check if there is valid User arraylist to add to", vendorList);

		// Add new user to the user list
		vendorList.add(vendor1);
		
		// test duplicate
		Vendor vendor3 = new Vendor(1, "JOSH Pte Ltd", "1233 4566", "21 Jerry Street");
	
		assertFalse("ChECK DUPLCIATE", vendorList.contains(vendor3));
		assertFalse("dont add",main.addVendor(vendorList, vendor3));

		// Test that the list of the size will increase by 1 after it has been added
		assertEquals("Check that the list size is 1 after it has been added", 1, vendorList.size());
		assertSame("Check that Vendor is added", vendor1, vendorList.get(0));
		
		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		main.addVendor(vendorList, vendor2);
		assertEquals("Check that Vendor arraylist size is 2", 2, vendorList.size());
		assertSame("Check that Vendor is added", vendor2, vendorList.get(1));

	}
//-------------------------view-----------------------

	@Test
	public void testRetrieveAllUsers() {

		// UserList is null or zero
		assertNotNull("Check if there is valid User arraylist to view from", userList);

		// test if the list of users retrieved from the userList is empty - boundary
		String allUsers = main.retrieveAllUsers(userList);
		String testOutput = "";
		assertEquals("Check that viewAllUsers is empty", testOutput, allUsers);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		main.addUser(userList, parent1);
		main.addUser(userList, guardian1);
		assertEquals("Test that User arraylist size is 2", 2, userList.size());

		// test if the expected output string same as the list of users retrieved
		allUsers = main.retrieveAllUsers(userList);
		testOutput = String.format("%-10s %-15d %-15s %-15s %-15s\n", "John Doe", 001, "1234 5678", "Parent", "MATTHIS Primary School");
		testOutput += String.format("%-10s %-15d %-15s %-15s %-15s\n", "Josh Tan", 002, "8765 4321", "Guardian", "JIAN Sparkletots");

		assertEquals("Test that ViewAllUsers displays correctly", testOutput, allUsers);

	}

	@Test
	public void testRetrieveAllSchools() {

		// UserList is null or zero
		assertNotNull("Check if there is valid School arraylist to view from", schoolList);

		// test if the list of users retrieved from the userList is empty - boundary
		String allSchools = main.retrieveAllSchools(schoolList);
		String testOutput = "";
		assertEquals("Check that viewAllSchools is empty", testOutput, allSchools);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		main.addSchool(schoolList, school1);
		main.addSchool(schoolList, school2);
		assertEquals("Test that School arraylist size is 2", 2, schoolList.size());

		// test if the expected output string same as the list of users retrieved
		allSchools = main.retrieveAllSchools(schoolList);
		testOutput = String.format("%-10d %-15s %-15s %-15d\n", 001, "MATTHIS Primary School", "10 Matthis Avenue", 10);
		testOutput += String.format("%-10d %-15s %-15s %-15d\n", 002, "JIAN Sparkletots", "6 Glenda Avenue", 5);

		assertEquals("Test that ViewAllSchools displays correctly", testOutput, allSchools);
	}
	
	
	@Test
	public void testRetrieveAllPayments() {

		// paymentList is null or zero
		assertNotNull("Check if there is valid Payment arraylist to view from", paymentList);

		// test if the list of payments retrieved from the paymentList is empty - boundary
		String allPayments = main.retrieveAllPayments(paymentList);
		String testOutput = "";
		assertEquals("Check that viewAllPayments is empty", testOutput, allPayments);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		main.addPayment(paymentList, payment1);
		main.addPayment(paymentList, payment2);
		assertEquals("Test that payment Arraylist size is 2", 2, paymentList.size());

		// test if the expected output string same as the list of payments retrieved
		allPayments = main.retrieveAllPayments(paymentList);
		testOutput = String.format("%-10s %-25s %-15d %-15s\n","Bob", "1234 5678 1234 5678", 321, "12/11/2030");
		testOutput += String.format("%-10s %-25s %-15d %-15s\n","Bobby", "1234 5678 1239 9239", 123, "10/01/2031");

		assertEquals("Test that ViewAllPayments displays correctly", testOutput, allPayments);
	}
	
	@Test
	public void testRetrieveAllVendors() {

		// paymentList is null or zero
		assertNotNull("Check if there is valid Vendor arraylist to view from", vendorList);

		// test if the list of payments retrieved from the paymentList is empty - boundary
		String allVendors = main.retrieveAllVendors(vendorList);
		String testOutput = "";
		assertEquals("Check that viewAllVendors is empty", testOutput, allVendors);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		main.addVendor(vendorList, vendor1);
		main.addVendor(vendorList, vendor2);
		assertEquals("Test that Vendor Arraylist size is 2", 2, vendorList.size());

		// test if the expected output string same as the list of payments retrieved
		allVendors = main.retrieveAllVendors(vendorList);
		testOutput = String.format("%-10s %-15s %-15s %-15s\n",1, "JOSH Pte Ltd", "1233 4566", "21 Jerry Street");
		testOutput += String.format("%-10s %-15s %-15s %-15s\n",1, "MATT Pte Ltd", "1212 3434", "11 Adriel Circle");

		assertEquals("Test that ViewAllVendors displays correctly", testOutput, allVendors);
	}
	@Test
	public void testRetrieveAllMenus() {

		// menuList is null or zero
		assertNotNull("Check if there is valid Menu arraylist to view from", menuList);

		// test if the list of payments retrieved from the paymentList is empty - boundary
		String allMenus = main.retrieveAllMenus(menuList);
		String testOutput = "";
		assertEquals("Check that viewAllMenus is empty", testOutput, allMenus);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		main.addMenu(menuList, menu1);
		main.addMenu(menuList, menu2);
		assertEquals("Test that Menu Arraylist size is 2", 2, menuList.size());

		// test if the expected output string same as the list of payments retrieved
		allMenus= main.retrieveAllMenus(menuList);
		testOutput = String.format("%-10d %-10s %-15s %-10s\n",1, "MACDONALDS", "Ongoing", "JOSH Pte Ltd");
		testOutput += String.format("%-10d %-10s %-15s %-10s\n",2, "KFC", "Paused", "MATT Pte Ltd");

		assertEquals("Test that ViewAllVendors displays correctly", testOutput, allMenus);
	}
	@Test
	public void testRetrieveAllOrders() {

		// orderList is null or zero
		assertNotNull("Check if there is valid Order arraylist to view from", orderList);

		// test if the list of orders retrieved from the orderList is empty - boundary
		String allOrders = main.retrieveAllOrders(orderList);
		String testOutput = "";
		assertEquals("Check that viewAllOrders is empty", testOutput, allOrders);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
//		main.addOrder(orderList,menuList,itemList,paymentList);
//		main.addOrder(orderList,menuList,itemList,paymentList);
//		assertEquals("Test that order Arraylist size is 2", 2, orderList.size());

		// test if the expected output string same as the list of payments retrieved
		allOrders= main.retrieveAllOrders(orderList);
		testOutput = String.format("%-10d %-15d %-15.2f %-15s %s\n",001, 10, 50.0, "JOSH Pte Ltd", "Pending");
		testOutput += String.format("%-10d %-15d %-15.2f %-15s %s\n",002, 5, 10.0, "JOSH Pte Ltd", "Pending");

//		assertEquals("Test that ViewAllOrders displays correctly", testOutput, allOrders);
	}

	// ------------------------delete-----------------------------

	@Test
	public void testDeleteUser() {
		// UserList is null or zero
		assertNotNull("Check if there is valid User arraylist to delete from", userList);

	
		userList.add(parent1);
		boolean test = main.doDeleteUser(userList, 1);
		
		
		// test delete non existing 
		User user3 = new User("John bob", 003, "8721 9130", "Guardian", "Home Address");
	
		assertFalse("ChECK presence", userList.contains(user3));
		assertFalse("dont delete",main.doDeleteUser(userList, user3.getId()));

		// Test that the list of the size will decrease by 1 after it has been added
		assertTrue("Test that User ID 1 has been successfully deleted", test);
		assertSame("Test that the size of the list will be 0 after deleting the user",userList.size(), 0);
		
		//	Test delete an invalid user ID
		
		test = main.doDeleteUser(userList, 3);
		assertFalse("Test that the deletion fails", test);
		

	}

	@Test
	public void testDeleteMenu() {
		// menuList is null or zero
		assertNotNull("Check if there is valid Menu arraylist to delete from", menuList);

		menuList.add(menu1);
		boolean test = main.doDeleteMenu(menuList, 1);
		
		// test delete non existing 
		Menu menu3 = new Menu(3, "ABCDEF", "Ongoing", "LLL Pte Ltd");
	
		assertFalse("ChECK presence", menuList.contains(menu3));
		assertFalse("dont delete",main.doDeleteMenu(menuList, menu3.getMenu_id()));
		
		// Test that the list of the size will decrease by 1 after it has been deleted
		assertTrue("Test that Menu ID 1 has been successfully deleted", test);
		assertEquals("Check that the list size is 0 after it has been deleted", 0, menuList.size());

		//	Test delete an invalid menu ID
		
		test = main.doDeleteMenu(menuList, 3);
		assertFalse("Test that the deletion fails", test);

	}

	@Test
	public void testDeleteOrder() {
		// orderList is null or zero
		assertNotNull("Check if there is valid Order arraylist to delete from", orderList);

		// delete user from the order list
		orderList.add(order1);
		boolean test = main.doDeleteOrder(orderList, 1);

		// test delete non existing 
		Order order3 = new Order(005, 11, 58.0, "JOSH Pte Ltd");
	
		assertFalse("ChECK presence", orderList.contains(order3));
		assertFalse("dont delete",main.doDeleteOrder(orderList,order3.getOrder_id()));

		// Test that the list of the size will decrease by 1 after it has been deleted
		assertTrue("Test that Order ID 1 has been successfully deleted", test);
		assertEquals("Check that the list size is 0 after it has been deleted", 0, orderList.size());


		//	Test delete an invalid order ID
		test = main.doDeleteOrder(orderList, 3);
		assertFalse("Test that the deletion fails", test);
		

	}

	@Test
	public void testDeleteSchool() {
		// schoolList is null or zero
		assertNotNull("Check if there is valid School arraylist to delete from", schoolList);

		// delete school from the school list
		schoolList.add(school1);
		boolean test = main.doDeleteSchool(schoolList, 1);
		
		// test delete non existing 
		School school3 = new School(002, "WAHSGD ASDGSAY Primary School", "10  sdha sad a Avenue", 19);
	
		assertFalse("ChECK presence", schoolList.contains(school3));
		assertFalse("dont delete",main.doDeleteSchool(schoolList,school3.getSchool_id()));

		
		// Test that the list of the size will decrease by 1 after it has been deleted
		assertTrue("Test that School ID 1 has been successfully deleted", test);
		assertEquals("Check that the list size is 0 after it has been deleted", 0, schoolList.size());

		// Test that the new school has been deleted from list
		test = main.doDeleteSchool(schoolList, 3);
		assertFalse("Test that the deletion fails", test);
	}

	@Test
	public void testDeleteVendor() {
		// vendorList is null or zero
		assertNotNull("Check if there is valid Vendor arraylist to delete from", vendorList);

		vendorList.add(vendor1);
		boolean test = main.doDeleteVendor(vendorList, 1);
		
		// test delete non existing 
		Vendor vendor3 = new Vendor(7, "HAHAHAHA Pte Ltd", "9812 4566", "21 Ben Street");
	
		assertFalse("ChECK presence", vendorList.contains(vendor3));
		assertFalse("dont delete",main.doDeleteVendor(vendorList,vendor3.getId()));
		
		// Test that the list of the size will decrease by 1 after it has been deleted
		assertTrue("Test that Vendor ID 1 has been successfully deleted", test);
		assertEquals("Check that the list size is 0 after it has been deleted", 0, vendorList.size());

		// Test that the new vendor has been deleted from list
		test = main.doDeleteVendor(vendorList, 3);
		assertFalse("Test that the deletion fails", test);
	
	}

	@Test
	public void testDeletePayment() {
		// paymentList is null or zero
		assertNotNull("Check if there is valid Payment arraylist to delete from", paymentList);
		
		paymentList.add(payment1);
		boolean test = main.doDeletePayment(paymentList, "Bob");
		
		// test delete non existing 
		Payment payment3 = new Payment("jimmy", "9128 1283 2389 9999", 321, "12/11/2030");
	
		assertFalse("ChECK presence", paymentList.contains(payment3));
		assertFalse("dont delete",main.doDeletePayment(paymentList,payment3.getName()));

		// Test that the list of the size will decrease by 1 after it has been added
		assertTrue("Test that User Payment has been successfully deleted", test);
		assertEquals("Check that the list size is 0 after it has been deleted", 0, paymentList.size());

		// Test that the new payment has been deleted from list
		test = main.doDeletePayment(paymentList, "LUCIUS NEO TZE HEAN");
		assertFalse("Test that the deletion fails", test);

	}

}

