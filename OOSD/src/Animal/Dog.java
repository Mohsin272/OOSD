package Animal;

public class Dog extends Animal {

	public Dog(String type, int age, char gender) {
		super(type, age, gender);
		
	}

	@Override
	public void eat() {
		System.out.println("Dog is eating");
	}

	@Override
	public void sleep() {
		System.out.println("Dog is sleeping");
	}

	@Override
	public void makeSound() {
		System.out.println("WOOF");
	}

	@Override
	public String toString() {
		return "Dog: " + super.toString();
	}
	
	
	
	

}
