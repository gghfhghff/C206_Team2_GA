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
		OrderStatus orderstatus1 = new OrderStatus(001, "Pending");
		OrderStatus orderstatus2 = new OrderStatus(002, "Completed");
		
		Payment payment1 = new Payment("Bob", "1234 5678 1234 5678", 321, "12/11/2030");
		Payment payment2 = new Payment("Bobby", "1234 5678 1239 9239", 123, "10/01/2031");
		

		Vendor vendor1 = new Vendor(1, "JOSH Pte Ltd", "1233 4566", "21 Jerry Street");
		Vendor vendor2 = new Vendor(1, "MATT Pte Ltd", "1212 3434", "11 Adriel Circle");
		

		Menu menu1 = new Menu(001, "MACDONALDS", "Ongoing", "JOSH Pte Ltd");
		Menu menu2 = new Menu(002, "KFC", "Paused", "MATT Pte Ltd");
		

		Item item1 = new Item(001, 001, "Chicken Rice", "Matthias Favourite", 4.0);
		Item item2 = new Item(001, 002, "Nasi Lemak", "Matthis Second Favourite", 5.0);
		

		School school1 = new School(001, "MATTHIS Primary School", "10 Matthis Avenue", 10);
		School school2 = new School(002, "JIAN Sparkletots", "6 Glenda Avenue", 5);
		

		Order order1 = new Order(001, 10, 50.0, "JOSH Pte Ltd");
		Order order2 = new Order(002, 5, 10.0, "JOSH Pte Ltd");
		

		User parent1 = new User("John Doe", 001, "1234 5678", "Parent");
		User guardian1 = new User("Josh Tan", 002, "8765 4321", "Guardian");
		
	}
		@Test
		public void testAddNewUser() {
			//User List is not null, able to add new item
			assertNotNull("Check if there is valid User arraylist to add to", userList);

			//Add new user to the user list
			userList.add(parent1);
			
			//Test that the list of the size will increase by 1 after it has been added
			assertEquals("Check that the list size is 1 after it has been added",1,userList.size());
			//Test that the new user has been successfully added into the list
			assertSame("Check that User is added", parent1, userList.get(0));

		}
		
		@Test
		public void testDeleteUser() {
			//UserList is null or zero
			assertNotNull("Check if there is valid User arraylist to delete from", userList);
			
			//delete user to the user list
			userList.remove(parent1);
			
			//Test that the list of the size will decrease by 1 after it has been added
			assertEquals("Check that the list size is 0 after it has been deleted",0,userList.size());
			
			//Test that the new user has been deleted list
			assertSame("Check that User is deleted", userList.size(), 0);
			
		}
		
		
		@Test
		public void testRetrieveAllUsers() {
			
			//UserList is null or zero
			assertNotNull("Check if there is valid User arraylist to view from", userList);
			
			//test if the list of users retrieved from the userList is empty - boundary
			String allUsers= main.retrieveAllUsers(userList);
			String testOutput = "";
			assertEquals("Check that viewAllUsers is empty", testOutput, allUsers);
			
			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
			main.addUser(userList, parent1);
			main.addUser(userList, guardian1);
			assertEquals("Test that User arraylist size is 2", 2, userList.size());
			
			//test if the expected output string same as the list of users retrieved 	
			allUsers= main.retrieveAllUsers(userList);
			testOutput = String.format("%-10s %-30d %-10s %-10s\n","John Doe", 001, "1234 5678", "Parent");
			testOutput += String.format("%-10s %-30d %-10s %-10s\n","Josh Tan", 002, "8765 4321", "Guardian");
		
			assertEquals("Test that ViewAllUsers displays correctly", testOutput, allUsers);
		}
//		
//		@Test
//		public void testAddExistingUser() {
//			//User List is not null, able to add existing item
//			assertNotNull("Check if there is valid User arraylist to add to", userList);
//
//			 main.add(parent1);
//
//			//
//			for (int i = 0; i < userList.size(); i++) {
//				
//				String a = parent1.getContactNum();
//				
//				assertFalse("Check that there is a duplicate in the list",userList.get(i).getContactNum() == a);
//				break;
//				
//			}
//			//Test that the new user has been successfully added into the list
//			assertSame("Check that User is added", parent1, userList.get(1));
//
//		}
		
		
		
//		@Test
//		public void testRetrieveAllCamcorder() {
//			// Test if Item list is not null but empty -boundary
//			assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", camcorderList);
//			
//			//test if the list of camcorders retrieved from the SourceCentre is empty - boundary
//			String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
//			String testOutput = "";
//			assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
//			
//			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
//			ResourceCentre.addCamcorder(camcorderList, cc1);
//			ResourceCentre.addCamcorder(camcorderList, cc2);
//			assertEquals("Test that Camcorder arraylist size is 2", 2, camcorderList.size());
//			
//			//test if the expected output string same as the list of camcorders retrieved from the SourceCentre	
//			allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
//			testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CC0011", "Nikon HDSLR", "Yes", "", "40");
//			testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CC0012", "Sony DSC-RX100M7", "Yes", "", "20" );
//		
//			assertEquals("Test that ViewAllCamcorderlist", testOutput, allCamcorder);
//			
//		}
//		
//		@Test
//		public void testDoReturnChromebook() {
//			//boundary
//			assertNotNull("Check if there is valid chromebook arraylist to add to", chromebookList);
//			ResourceCentre.addChromebook(chromebookList, cb1);
//
//			//error
//			Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
//			assertFalse("Check that available chromebook CB0011 is returned - false?", isReturned);		
//			//normal
//			ResourceCentre.addChromebook(chromebookList, cb2);
//			cb2.setIsAvailable(false);
//			isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0012");
//			assertTrue("Check that loanded out chromebook CB0012 is returned - true", isReturned);
//			//error
//			isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0013");
//			assertFalse("Check that non-existing chromebook CB0013  is returned - false?", isReturned);
//		}
		
	}

