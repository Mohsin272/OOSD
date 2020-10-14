package lab2;

public class HotelDriver {

	public static void main(String[] args) {
		HotelRoom roomA=new HotelRoom();
		
		roomA.setroomNumber(200);
		roomA.setroomType("Single");
		
		HotelRoom roomB=new HotelRoom(201,"Double");
		System.out.println("Room" +roomA.toString());
		System.out.println("Room" +roomB.toString());
	}

}
