package Programs;

import java.util.Scanner;

public class Garage {

	public static void main(String[] args) {
		
		int choice=0;
		int carTotal=0;
		Car[] cars=new Car[10];
		
		while(choice!=4) {
		
		Scanner in =new Scanner(System.in);
		
		System.out.println("Please enter a choice");
		System.out.println("1. List all Cars");
		System.out.println("2. Enter a Car");
		System.out.println("3. List all cars sold");
		System.out.println("4. Exit");
		
		choice=in.nextInt();
		
		if(choice ==1) {
			for(Car c:cars) {
				if(c !=null)System.out.println(c.toString());
			}
				
			
		}
		else if(choice==2) {
			if(carTotal<9) {
			Scanner incar =new Scanner(System.in);
			String make;
			String model;
			double engineSize;
			double price;
			System.out.println("Please Enter Car Make");
			make=incar.nextLine();
			
			System.out.println("Please Enter Car Model");
			model=incar.nextLine();
			
			System.out.println("Please Enter Engine Size");
			engineSize=incar.nextDouble();
			
			System.out.println("Please Enter price");
			price=incar.nextDouble();
			
			Car c=new Car(make, model, engineSize, price);
			
			cars[carTotal]=c;
			carTotal++;
			}
			else {
				System.out.println("You have too many cars!!!");
				
			}
			
		}
		else if(choice==3) {
			System.out.println("Choice 3");
		}
		else if(choice==4) {
			System.out.println("GoodBye!!");
			System.exit(0);
			
		}
			
		}//end while
	}//end main

}
