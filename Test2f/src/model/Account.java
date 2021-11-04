package model;



public class Account {
	private String status="";
	private String name="";
	private int balance=0;
	private boolean vip=false;
	private int vipFee=0;

	public Account(String name, int balance) {
		this.name=name;
		this.balance=balance;
		this.status="A regular account owned by "+this.name+" with balance $"+this.balance;
	}
	
	public Account(Account a1) {
		this.name=a1.name;
		this.balance=a1.balance;
		this.status=a1.status;
		this.vip=a1.vip;
		this.vipFee=a1.vipFee;
	}

	public String toString() {
		return this.status;
		
		
	}

	public void switchToVIP(int vipFee) throws InvalidStatusToSwitchException, InsufficientBalanceException {
		
		
		if(vip) {
			throw new InvalidStatusToSwitchException("");
			
		}
		
		else if(vipFee>this.balance) {
			throw new InsufficientBalanceException("");
		}
		
		else {
			this.vipFee=vipFee;
		vip=true;
		this.balance-=vipFee;
		this.status ="A VIP account owned by "+this.name+" with balance $"+this.balance+" ($"+vipFee+" deposited for maintaining the VIP stauts)";
		}
	}

	public void switchToRegular() throws InvalidStatusToSwitchException  {
		if(!vip) {
			throw new InvalidStatusToSwitchException("");
		}
		else {
			vip=false;
			this.balance+=this.vipFee;
			this.status="A regular account owned by "+this.name+" with balance $"+this.balance;
		}
		
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		Account other = (Account) obj;
		boolean equal = true;
		
		if((this.vip==other.vip)&&(this.name.equals(other.name))&&(this.balance==other.balance)) {
			return true;
			
		}else {
			equal=false;
		}
		
		
		return equal;
	}


}
