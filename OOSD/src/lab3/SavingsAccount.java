package lab3;

public class SavingsAccount {
	//Variables
	private int accNo;//one per object instance
	private static int nextAccNo=0;//shared by all object instances
	private static float annualInterestRate=0.0f;
	private double savingsBalance;
	
	//Constructors
	public SavingsAccount() {
		++nextAccNo;//increments account number then assigns back
		setAccNo(nextAccNo);
	}
	
	public SavingsAccount(double savingsBalance) {
		++nextAccNo;//increments account number then assigns back
		setAccNo(nextAccNo);
		setSavingsBalance(savingsBalance);

	}





	//Getters & Setters
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public static float getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void modifyInterestRate(float annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	//Misc Methods
	public void calculateMonthlyInterest() {
		savingsBalance+=((getSavingsBalance()* getAnnualInterestRate())/12);
	}
	//grab current balance multiply by interest rate and divide by 12
	//then add it back on

	//toString
	public String toString() {
		return "SavingsAccount [accNo=" + accNo + ", savingsBalance=" + savingsBalance + "]";
	}
	
	
	

}
