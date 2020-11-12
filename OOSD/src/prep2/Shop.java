package prep2;

import java.util.Scanner;

public class Shop {

	public static void main(String[] args) {
		
		Item[]items=new Item[3];
		
		for(int x=0;x<=2;x++) {
			Scanner in =new Scanner(System.in);
			
			System.out.println("Enter Name: ");
			String name=in.nextLine();
			
			System.out.println("Enter Type: ");
			String type=in.nextLine();
			
			System.out.println("Enter Date: ");
			String date=in.nextLine();
			
			System.out.println("Enter Price: ");
			double price=in.nextDouble();
			
			System.out.println("Enter Status(A/S): ");
			char status=in.next().charAt(0);
			
			Item i=new Item(name,type,date,price,status);
			if(x==1)i.statusUpdate();
			items[x]=i;
			System.out.println("No.Of Items created: "+Item.getnOfsalesItems());
			
		}
		
		for(Item i:items)System.out.println(i);
		//for each item in items
			
		
		

	}//end main

}
