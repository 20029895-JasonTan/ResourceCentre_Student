import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void testAddChromebook() {
		// write your code here
		// Done by Xing He 
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList); // Item list is not null, so that can add new item
		ResourceCentre.addChromebook(chromebookList, cb1); // Given an empty list, after adding 1 item, the size of the list is 1
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
		assertSame("Test that chromebook is added same as 1st item of the list?", cc2, chromebookList.get(0)); //The item just added is as same as the first item of the list
		ResourceCentre.addCamcorder(camcorderList, cc2); // Add another item. test the size of the list is 2?
		assertEquals("Test that chromebook arraylist size is 2?", 2, chromebookList.size());
		// Done by XingHe
	}

	
	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void testRetrieveAllChromebook() {
		// Done by Marcus
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
		// Done by Marcus
		//test if the list of Chromebook retrieved from the SourceCentre is empty
		String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllChromebookList is not empty", testOutput, allChromebook);
						
		// Done by Marcus
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
				
		// Done by Marcus
		//test if the expected output string same as the list of Chromebook retrieved from the SourceCentre
		allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);

		// Done by Marcus
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
		
		// Done by Marcus
		assertEquals("Check that ViewAllChromebookList display the same list as retrieved.", testOutput, allChromebook);
		//fail("Not yet implemented");
		// write your code here
		
	}

	@Test
	public void testDoLoanCamcorder() {
		//fail("Not yet implemented");
		// write your code here
	}
	
	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// Done by jerald
		assertEquals("Test that a Chromebook item is available for loan", true, cb1.getIsAvailable());
		
		Chromebook cb3 = new Chromebook("CB0013", "Lenovo Chromebook", "Win 11");
		assertTrue("Check if the availability of a new Chromebook is availability of loan", cb3.getIsAvailable());
		
		assertFalse("Test if the availability changes to false when a Chromebook is loaned out", ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "22 July 2021"));
		
		assertNotNull("Test that a loaned Chromebook object has a due date", cb3.getDueDate());
	}
	
	@Test
	public void testDoReturnCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		//Done by Sanjeev
		//Test that loan of camcorder should be unavailable if the camcorder arraylist in empty.
		assertNotNull("Test that if the Camcorder arrayList is empty loan for camcorder should be unavailable", camcorderList);
		
		//Test that only the correct tag allows the user to return the item
		assertEquals("Test that only chromebook is returned", true, cb1.getIsAvailable());
		
		// After returning 2 items, test if the availability is true
		ResourceCentre.doReturnCamcorder(camcorderList, cc1.getAssetTag());
		ResourceCentre.doReturnCamcorder(camcorderList, cc2.getAssetTag());
		assertEquals("Test that camcorder availability is true?", true, cc1.getIsAvailable());
		assertEquals("Test that camcorder availability is true?", true, cc2.getIsAvailable());
		
	}
	@Test
	public void testDoReturnChromebook() {
		//fail("Not yet implemented");
		// write your code here
		//Done by Sanjeev 4
		//Test that loan of camcorder should be unavailable if the camcorder arraylist in empty.
		assertNotNull("Test that if the Chromebook arrayList is empty loan for chromebook should be unavailable", chromebookList);
		
		//Test that only the correct tag allows the user to return the item
		assertEquals("Test that only chromebook is returned", true, cb1.getIsAvailable());
		
		//After returning 2 items, test if the availability is true
		ResourceCentre.doReturnChromebook(chromebookList, cc1.getAssetTag());
		ResourceCentre.doReturnChromebook(chromebookList, cc2.getAssetTag());
		assertEquals("Test that camcorder availability is true?", true, cb1.getIsAvailable());
		assertEquals("Test that camcorder availability is true?", true, cb2.getIsAvailable());
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
