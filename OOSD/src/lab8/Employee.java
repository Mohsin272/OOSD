package lab8;

public class Employee extends Person {

	int salary;
	
	public Employee(String name ,int salary) {
		super (name);
		setSalary(salary);
	}

	@Override
	public String getDescription() {
		return "An employee with a salary of: "+salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	
	

}
