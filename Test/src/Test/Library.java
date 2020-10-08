package Test;

import java.util.Scanner;

public class Library {
	public static void main(String[]args) {
		Book[]books=new Book[3];
		Scanner in=new Scanner(System.in);
		
		for(int i=0;i<=2;i++) {
			System.out.println("Enter Title");
			String title =in.nextLine();
			
			System.out.println("Enter Book Author");
			String author=in.nextLine();
			
			System.out.println("Enter number of pages");
			int noOfpages=in.nextInt();
			
			Book b=new Book(title,author,noOfpages);
			
			books[i]=b;
			
		}
		
		for(Book b:books) {
			if(b !=null)System.out.println(b.toString());
		}
	}

}
