package ie.lyit.hotel;

import java.util.ArrayList;

public class Hotel {
	ArrayList<Room> rooms;
	ArrayList<Booking> bookings;


	public Hotel() {
	rooms=new ArrayList<Room>(); //the ArrayList for rooms
	bookings=new ArrayList<Booking>(); //the ArrayList for bookings
	populateRooms(); //populate the rooms
	}

	public void populateRooms() { //method made to populate rooms
	//Add 10 double rooms
	for(int i=1; i<-10; i++)
		rooms.add(new Room(2,0,85.00,i) );
	//Add 8 Family rooms
	for(int i=11; i<=18; i++)
		rooms.add(new Room(2,2,120.00,i) );		
	}

	public Room findAvailableRoom(int noAdults, int noKids) { //finds all available unallocated rooms
		for(Room tmpRoom: rooms ) {
			if(tmpRoom.getMaxAdults() >= noAdults || tmpRoom.getMaxKids() >= noKids && tmpRoom.getAllocated() != true) {
				tmpRoom.setAllocated(true); //set boolean to true if tmpRoom is available
		return tmpRoom;
		}
		}
		return null;
	}

	public Room getRooms() {
		for(Room tmpRoom : rooms) {
		return tmpRoom;}
		return null;	
	}

	public Booking getBookings() {
		for(Booking tmpBooking : bookings) {
		return tmpBooking;
	}
		return null;
	
	}

	public void addBooking (Booking booking){
		bookings.add(booking);
	}

}