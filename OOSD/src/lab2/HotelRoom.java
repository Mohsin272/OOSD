package lab2;

public class HotelRoom {
// Variables
	private int roomNumber;
	private String roomType;
	private boolean vacant;
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
		if(roomNumber >0 && roomNumber <=100) {
			this.roomNumber = roomNumber;
		}
		else {
			System.out.println("RoomNumber is not range!!!!");
		}
		
	}
	public String getroomType() {
		return roomType;
	}
	public void setroomType(String roomType) {
		this.roomType = roomType;
	}
	public boolean getVacant() {
		return vacant;
	}
	public void setVacant(boolean vacant) {
		this.vacant=vacant;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate=rate;
	}
	//toString
	public String toString() {
		return "HotelRoom [roomNumber=" + roomNumber + ", roomType=" + roomType + "]";
	}
	
	

	
	
	
	
	
}
