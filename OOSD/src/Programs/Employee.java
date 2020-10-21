package Programs;

public class Employee {
	//Variables
		private String fname;
		private String lname;
		private static int count; //no. of objects instantiated
		private static int staffNumber=1;
		private int employeeNumber;
		
		//Constructors
		public Employee() {
			setFName("");
			setLName("");
			++count;
			setEmployeeNumber(staffNumber);
			staffNumber++;
			++count;
		}

		public Employee(String fname, String lname) {
			setFName(fname);
			setLName(lname);
			++count;
			setEmployeeNumber(staffNumber);
			staffNumber++;
			++count;
		}

		//Getters & Setters
		public String getFName() {
			return fname;
		}

		public void setFName(String fname) {
			this.fname = fname;
		}

		public String getLName() {
			return lname;
		}

		public void setLName(String lname) {
			this.lname = lname;
		}

		public static int getCount() {
			return count;
		}

		public static int getStaffNumber() {
			return staffNumber;
		}

		public static void setStaffNumber(int staffNumber) {
			Employee.staffNumber = staffNumber;
		}

		public int getEmployeeNumber() {
			return employeeNumber;
		}

		public void setEmployeeNumber(int employeeNumber) {
			this.employeeNumber = employeeNumber;
		}

		//toString
		@Override
		public String toString() {
			return "Employee [fname=" + fname + ", lname=" + lname + "]";
		}
		
		//Finalize
		public void finalize(){
			--count;
		}
}
