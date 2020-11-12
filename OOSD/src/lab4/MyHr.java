package lab4;

import java.util.Scanner;

public class MyHr {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int choice=0;
		Employee[]emps =new Employee[5];
		Office [] offices=new Office[3];
		
		for(int y=0;y<=2;y++) {
			Office of =new Office();
			offices[y]=of;
		}
		while (choice!=4) {
			System.out.println("Please selct one of the following");
			System.out.println("1. List all offices");
			System.out.println("2. Create new employee record");
			System.out.println("3. List all employees");
			System.out.println("4. Exit");
			choice=in.nextInt();
			
			if(choice==1) {
				for(Office of:offices) {
					System.out.println(of+"\t"+"No.of employees:" +of.getNoOfEmps());
					if(of.getNoOfEmps()!=0) {
						System.out.println("Employees"+"\n"+ of.printEmployee());
					}
				}
			}
			else if(choice==2) {
			if(emps.length<=5) {
				String fname;
				String lname;
				String street;
				String city;
				String county;
				String empType;
				String comCarType=null;
				
				Scanner inemp =new Scanner(System.in);
				System.out.println("Please enter employee firstname");
				fname=inemp.nextLine();
				System.out.println("Please enter employee surname");
				lname=inemp.nextLine();
				System.out.println("Please enter the street");
				street=inemp.nextLine();
				System.out.println("Please enter city");
				city=inemp.nextLine();
				System.out.println("Please enter county");
				county=inemp.nextLine();
				System.out.println("Please enter Employee Type(Manager/Staff)");
				empType=inemp.nextLine();
				if(empType.equalsIgnoreCase("Manager")) {
					System.out.println("Please enter company car type");
					comCarType=inemp.nextLine();
				}
				Address add =new Address(street , city,county);
				Employee emp =new Employee(fname,lname,add,empType);
				emp.setComCarType(comCarType);
				emps[Employee.noOfEmployee()]=emp;
				for(Office of: offices) {
					if(of.getNoOfEmps()<=2) {
						of.addEmployee(emp);
						break;
					}
				}
			}
			else {
				System.out.println("You have created the max num of employees");
			}
			
			}
			else if(choice==3) {
				for(Employee emp:emps) {
					if(emp!=null)System.out.println(emp);
				}
			}
			else if(choice==4) {
				System.out.println("GoodBye");
				System.exit(0);
			}
		}

	}//end main

}
