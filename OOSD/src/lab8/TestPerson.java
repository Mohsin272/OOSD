package lab8;

public class TestPerson {

	public static void main(String[] args) {
		
		Employee emp =new Employee("Tom",60000);
		Student stu=new Student("Mary","Programming");
		
		Person[] people=new Person [2];//Create array of 2 people
		
		people[0]=emp;//add employee to array
		people[1]=stu;//add student to array
		
		for(Person p:people)System.out.println("Name"+p.getName()+"\t"+"Description"+p.getDescription());//for each people in person array
		

	}

}
