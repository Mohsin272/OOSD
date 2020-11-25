package lab7;

public class PetVet {

	public static void main(String[] args) {
		Animal dog = new Dog("Poodle", 4, 'M');

		Animal cat = new Cat("Tom", 2, 'F');
		
		Animal cow = new Cow("Heffer", 3, 'F');

		Animal[]animals =new Animal[3];
		
		animals[0]=dog;
		animals[1]=cat;
		animals[2]=cow;
		
		for(Animal ani:animals) {// go through array and pick it out
			System.out.println(ani);
			ani.eat();
			ani.sleep();
			ani.makeSound();
			
		}

		
		Vet v = new Vet("John");
		v.vaccinate(dog);
		v.vaccinate(cat);
		
		v.vaccinateMe(animals);
	}
	
	
	
	
	

}
