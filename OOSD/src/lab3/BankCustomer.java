package lab3;

import java.util.Arrays;

public class BankCustomer {
	//Variables
	private String name;
	private String address;
	private SavingsAccount[] savaccs=new SavingsAccount[3];
	private int noOfAccs=0;

	//Constructors
	public String getName() {
		return name;
	}
	public BankCustomer(String name, String address) {
		setName (name);
		setAddress ( address);
	}
	
	//Getters and Setters

	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public SavingsAccount[] getSavaccs() {
		return savaccs;
	}
	public void setSavaccs(SavingsAccount[] savaccs) {
		this.savaccs = savaccs;
	}

	//Misc Methods
	public int getNoOfAccs() {
		return noOfAccs;
	}
	public void setNoOfAccs(int noOfAccs) {
		this.noOfAccs = noOfAccs;
	}
	public void addAccount(SavingsAccount sav ){
		if(getNoOfAccs()<2) {
			savaccs[getNoOfAccs()]=sav;
			setNoOfAccs(getNoOfAccs()+1);
		}
		else {
			System.out.println("Tou have reached your Account limit");
		}
	}
	
	public double balance(SavingsAccount[]savaccs) {
		double balance=0;
		for(SavingsAccount sav:savaccs) {
			if(sav!=null) balance += sav.getSavingsBalance();
		}
		return balance;
	}
	
	
	
	//toString
	public String toString() {
		return "BankCustomer [name=" + name + ", address=" + address + ", savaccs=" + Arrays.toString(savaccs) + "]";
	}
	
	
	
	

}//end main
