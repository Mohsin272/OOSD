package dice;

public class DiceTest {

	public static void main(String[] args) {
		
		PairOFDice myDie=new PairOFDice();
		
		for(int i=0;i<10;i++) {
			myDie.roll();
			System.out.println(myDie.getFaceValues());
		}
			

	}

}
