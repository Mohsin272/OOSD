package dice;

public class PairOFDice {

	//variables
	private Dice dice1;
	private Dice dice2;
	
	public PairOFDice() {
		dice1=new Dice();
		dice2=new Dice();
	}
	
	public void roll() {
		dice1.roll();
		dice2.roll();
	}
	
	public String getFaceValues() {
		return"(" +dice1.getFaceValue()+","+dice2.getFaceValue()+")";
	}
	
	

}
