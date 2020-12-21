package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ie.lyit.hotel.Room;

public class RoomTest {
	private Room r1;
	
	@Before
	public void setUp() throws Exception {
		r1 = new Room(2,0,85.0,1);
	}

	@Test
	public void testRoomIntIntDoubleInt() {
		r1=new Room(1,0,85,1);
		
		//check r1 adult below max
		assertEquals(1, r1.getMaxAdults() );
		//check r1's kids is below max
		assertEquals("Kids should be 0",0,r1.getMaxKids() );
	}

	@Test
	public void testToString() {
		//check if r1 to string output is the same
		assertEquals("Room should be ROOM 1 [2 adult(s),0 kid(s) @ €85.0 p/n,NOT allocated]","ROOM 1 [2 adult(s),0 kid(s) @ €85.0 p/n,NOT allocated]",r1.toString());
	}

	@Test
	public void textSetMaxAdults() {
		r1.setMaxAdults(2);
		//check that r1 adults is bellow the max
		assertEquals("Expected Adults should be 2",2, r1.getMaxAdults() );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetMaxAdultForException() {
		r1.setMaxAdults(3);
		//test exception handlers for when adults exceeds its max
		assertEquals("Expected Adults should not be more than 2", 3, r1.getMaxAdults() );
	}

	@Test
	public void testSetMaxKids() {
		r1.setMaxKids(0);
		//check if r1 is bellow max
		assertEquals("Expected Adults should be 0",0, r1.getMaxKids() );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetMaxKidsForException() {
		r1.setMaxKids(4);
		//test exception handlers for when adults exceeds its max
		assertEquals("Expected Kids should not be more than 3", 4, r1.getMaxAdults() );
	}
	
	

	@Test
	public void testSetPricePerNight() {
		r1.setPricePerNight(85.0);
		assertTrue("Expected Price per night should be 85",85.0 == r1.getPricePerNight() );
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetPricePerNightForException() {
		r1.setPricePerNight(59.0);
		//test if the price is less than 60
		assertTrue("Expected Price per night should be less than 60",59.0 == r1.getPricePerNight() );
	}

	@Test
	public void testSetAllocated() {
		assertTrue("Expected room is NOT allocted",false==r1.getAllocated() );
	}

}
