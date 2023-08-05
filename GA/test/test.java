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
	private OrderStatus orderStatus1;
	private OrderStatus orderStatus2;
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
	ArrayList<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
	ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
	ArrayList<Payment> paymentList = new ArrayList<Payment>();
	ArrayList<Item> itemList = new ArrayList<Item>();

	@Before
	public void setUp() throws Exception {
		// TO DELETE ORDERSTATUS
		OrderStatus orderstatus1 = new OrderStatus(001, "Pending");
		OrderStatus orderstatus2 = new OrderStatus(002, "Completed");

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

		parent1 = new User("John Doe", 001, "1234 5678", "Parent");
		guardian1 = new User("Josh Tan", 002, "8765 4321", "Guardian");

	}

	// ---------------------add-----------------
	@Test
	public void testAddNewUser() {
		// User List is not null, able to add new item
		assertNotNull("Check if there is valid User arraylist to add to", userList);

		// Add new user to the user list
		userList.add(parent1);

		// Test that the list of the size will increase by 1 after it has been added
		assertEquals("Check that the list size is 1 after it has been added", 1, userList.size());
		// Test that the new user has been successfully added into the list
		assertSame("Check that User is added", parent1, userList.get(0));

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
		testOutput = String.format("%-10s %-15d %-15s %-15s", "John Doe", 001, "1234 5678", "Parent");
		testOutput += String.format("%-10s %-15d %-15s %-15s", "Josh Tan", 002, "8765 4321", "Guardian");

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
		testOutput = String.format("%-10d %-15s %-15s %-15d", 001, "MATTHIS Primary School", "10 Matthis Avenue", 10);
		testOutput += String.format("%-10d %-15s %-15s %-15d", 002, "JIAN Sparkletots", "6 Glenda Avenue", 5);

		assertEquals("Test that ViewAllSchools displays correctly", testOutput, allSchools);
	}
//	@Test
//
//	public void testRetrieveAllMenus() {
//
//		// UserList is null or zero
//		assertNotNull("Check if there is valid User arraylist to view from", menuList);
//
//		// test if the list of users retrieved from the userList is empty - boundary
//		String allMenu = main.retrieveAllMenus(menuList);
//		String testOutput = "";
//		assertEquals("Check that viewAllMenus is empty", testOutput, allMenu);
//
//		// Given an empty list, after adding 2 items, test if the size of the list is 2
//		// - normal
//		main.addMenu(menuList, menu1);
//		main.addMenu(menuList, menu2);
//		assertEquals("Test that Menu arraylist size is 2", 2, menuList.size());
//
//		// test if the expected output string same as the list of users retrieved
//		allMenu = main.retrieveAllMenus(menuList);
//		testOutput = String.format("%-10d %-15s %-15s %-15s\n", 001, "MACDONALDS", "Ongoing", "JOSH Pte Ltd");
//		testOutput += String.format("%-10d %-15s %-15s %-15s\n", 002, "KFC", "Paused", "MATT Pte Ltd");
//
//		assertEquals("Test that ViewAllMenus displays correctly", testOutput, allMenu);
//	}
//	
//	@Test
//
//	public void testRetrieveAllOrders() {
//
//		// UserList is null or zero
//		assertNotNull("Check if there is valid Order arraylist to view from", orderList);
//
//		// test if the list of users retrieved from the userList is empty - boundary
//		String allOrders = main.retrieveAllOrders(orderList);
//		String testOutput = "";
//		assertEquals("Check that viewAllOrders is empty", testOutput, allOrders);
//
//		// Given an empty list, after adding 2 items, test if the size of the list is 2
//		// - normal
//		main.addOrder(orderList, order1);
//		main.addOrder(orderList, order2);
//		assertEquals("Test that Menu arraylist size is 2", 2, menuList.size());
//
//		// test if the expected output string same as the list of users retrieved
//		allOrders = main.retrieveAllMenus(menuList);
//		testOutput = String.format("%-10d %-15d %-15.2f %-15s\n",001, 10, 50.0, "JOSH Pte Ltd");
//		testOutput += String.format("%-10d %-15d %-15.2f %-15s\n",002, 5, 10.0, "JOSH Pte Ltd");
//
//		assertEquals("Test that ViewAllOrders displays correctly", testOutput, allOrders);
//	}
	
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
	
	

	// ------------------------delete-----------------------------

	@Test
	public void testDeleteUser() {
		// UserList is null or zero
		assertNotNull("Check if there is valid User arraylist to delete from", userList);

		// delete user to the user list
		userList.remove(parent1);

		// Test that the list of the size will decrease by 1 after it has been added
		assertEquals("Check that the list size is 0 after it has been deleted", 0, userList.size());

		// Test that the new user has been deleted list
		assertSame("Check that User is deleted", userList.size(), 0);

	}

	@Test
	public void testDeleteMenu() {
		// menuList is null or zero
		assertNotNull("Check if there is valid Menu arraylist to delete from", menuList);

		// delete menu from the menu list
		menuList.remove(menu1);

		// Test that the list of the size will decrease by 1 after it has been added
		assertEquals("Check that the list size is 0 after it has been deleted", 0, menuList.size());

		// Test that the new menu has been deleted from list
		assertSame("Check that Menu is deleted", menuList.size(), 0);

	}

	@Test
	public void testDeleteOrder() {
		// orderList is null or zero
		assertNotNull("Check if there is valid Order arraylist to delete from", orderList);

		// delete user from the order list
		orderList.remove(order1);
		orderStatusList.remove(orderStatus1);

		// Test that the list of the size will decrease by 1 after it has been added
		assertEquals("Check that the list size is 0 after it has been deleted", 0, orderList.size());
		assertEquals("Check that the list size is 0 after it has been deleted", 0, orderStatusList.size());

		// Test that the new order has been deleted from list
		assertSame("Check that Order is deleted", orderList.size(), 0);
		assertSame("Check that Order is deleted", orderStatusList.size(), 0);

	}

	@Test
	public void testDeleteSchool() {
		// schoolList is null or zero
		assertNotNull("Check if there is valid School arraylist to delete from", schoolList);

		// delete school from the school list
		schoolList.remove(school1);

		// Test that the list of the size will decrease by 1 after it has been added
		assertEquals("Check that the list size is 0 after it has been deleted", 0, schoolList.size());

		// Test that the new school has been deleted from list
		assertSame("Check that School is deleted", schoolList.size(), 0);

	}

	@Test
	public void testDeleteVendor() {
		// vendorList is null or zero
		assertNotNull("Check if there is valid Vendor arraylist to delete from", vendorList);

		// delete vendor from the vendor list
		vendorList.remove(vendor1);

		// Test that the list of the size will decrease by 1 after it has been added
		assertEquals("Check that the list size is 0 after it has been deleted", 0, vendorList.size());

		// Test that the new vendor has been deleted from list
		assertSame("Check that Vendor is deleted", vendorList.size(), 0);

	}

	@Test
	public void testDeletePayment() {
		// paymentList is null or zero
		assertNotNull("Check if there is valid Payment arraylist to delete from", paymentList);

		// delete payment from the payment list
		paymentList.remove(payment1);

		// Test that the list of the size will decrease by 1 after it has been added
		assertEquals("Check that the list size is 0 after it has been deleted", 0, paymentList.size());

		// Test that the new payment has been deleted from list
		assertSame("Check that Payment is deleted", paymentList.size(), 0);

	}

	@Test
	public void testDeleteItem() {
		// itemList is null or zero
		assertNotNull("Check if there is valid Item arraylist to delete from", itemList);

		// delete item from the item list
		itemList.remove(item1);

		// Test that the list of the size will decrease by 1 after it has been added
		assertEquals("Check that the list size is 0 after it has been deleted", 0, itemList.size());

		// Test that the new item has been deleted from list
		assertSame("Check that Item is deleted", itemList.size(), 0);

	}

}
