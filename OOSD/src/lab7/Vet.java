package lab7;

public class Vet {
	private String name;
	
	public Vet(String name) {
		setName (name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void vaccinate(Animal a) {
		System.out.println(this.name+"is vaccinating!");
		if(a instanceof Dog) {
			System.out.println("The Dog");
			System.out.println("The Dog has been vaccinateda"+a.toString());
		}
		else if(a instanceof Cat) {
			System.out.println("The Cat");
			System.out.println("The Cat has been vaccinateda"+a.toString());
		}
		else if(a instanceof Cow) {
			System.out.println("The Cow");
			System.out.println("The Cow has been vaccinateda"+a.toString());
		}
		
		
		
	}
	public void vaccinateMe(Animal[] animal) {
		for(Animal a:animal) {
			System.out.println(this.name+" is vaccinating the");
			System.out.println(a.getClass().getName());
			System.out.println("The"+a.getClass().getName()+"has been vaccinated");
		}
	}
	
}
