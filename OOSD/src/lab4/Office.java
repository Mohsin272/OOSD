package lab4;

public class Office extends Object {
	//variables
	private static int nextoffice=100;
	private int officenumber;
	private int noOfEmps=0;
	private Employee[] employees=new Employee[2];

	
	
	//constructor
	public Office() {
		setOfficenumber(nextoffice);
		nextoffice++;
	}

	//getters and setters

	public int getOfficenumber() {
		return officenumber;
	}

	public void setOfficenumber(int officenumber) {
		this.officenumber = officenumber;
	}

	public int getNoOfEmps() {
		return noOfEmps;
	}
	public void setNoOfEmps(int noOfEmps) {
		this.noOfEmps = noOfEmps;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	
	
	//toString
	public String toString() {
		return "Office [officenumber=" + officenumber + "]";
	}
	
	//Misc Methods
	public void addEmployee(Employee employee) {
		if(noOfEmps<=2) {
			employees[noOfEmps]=employee;
			noOfEmps++;
		}
		else {
			System.out.println("You have reached max employees");
		}
	}
	
	public String printEmployee() {
		String empDetails="";
		for(Employee emp:employees) {
			if(emp!=null) {
				empDetails+=emp.getEmployeeNumber()+","+emp.getFname()+","+emp.getLname()+"\n";
			}
		}
		return empDetails;
	}
	
	
	
	
	
	
	
	
}
