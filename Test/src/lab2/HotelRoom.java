package lab2;

public class HotelRoom {
// Variables
	private int roomNumber;
	private String roomType;
	private int vacant;
	private double rate;
//Constructers
	public HotelRoom() {
		setroomNumber(0);
		setroomType("");
	}
	
public HotelRoom(int roomNumber, String roomType) {
	setroomNumber (roomNumber);
	setroomType(roomType);
}



//Getters & Setters
	public int getroomNumber() {
		return roomNumber;
	}
	public void setroomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getroomType() {
		return roomType;
	}
	public void setroomType(String roomType) {
		this.roomType = roomType;
	}
	
	//toString
	public String toString() {
		return "HotelRoom [roomNumber=" + roomNumber + ", roomType=" + roomType + "]";
	}
	
	

	
	
	
	
	
}
