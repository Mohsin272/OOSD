package lab2;

public class HotelDriver {

	public static void main(String[] args) {
		HotelRoom[] rooms=new HotelRoom[3];
		HotelRoom roomA=new HotelRoom();
		roomA.setroomNumber(200);
		roomA.setroomType("Single");
		
		HotelRoom roomB=new HotelRoom(201,"Double");
		roomA.setVacant(true);
		roomA.setRate(100);
		
		roomA.setVacant(false);
		roomA.setRate(80);
		
		HotelRoom roomC=new HotelRoom(202,"Single",false,90);
		
		rooms[0]=roomA;
		rooms[2]=roomB
		rooms[3]=roomC;
		
		for(HotelRoom h:rooms) {
			if(h!=null)
			System.out.println("Room: " +h.toString());
		}
		rooms[1].isOccupied();
		System.out.println("Room:"+rooms[1].toString());
	}//end main

}
