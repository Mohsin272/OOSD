package lab3;

public class BankDriver {

	public static void main(String[] args) {
		SavingsAccount saver1=new SavingsAccount();
		
		saver1.setSavingsBalance(2000.0);
		
		SavingsAccount saver2=new SavingsAccount(3000);
		
		SavingsAccount.modifyInterestRate(0.05f);
		
		saver1.calculateMonthlyInterest();
		
		saver2.calculateMonthlyInterest();
		
		BankCustomer bc =new BankCustomer("John","Cork"); 
		bc.addAccount(saver1);
		bc.addAccount(saver2);
		
		System.out.println(bc);
		System.out.println("Savings Total: "+ bc.balance(bc.getSavaccs()));
		
		
		
		
		
		
		

	}

}
