package model;

public class Bank {
	
	private Account [] account= new Account[0];
	private Account [] accountCopy= new Account[0];
	
	public Bank() {
		
	}
	
	public Bank(Bank b1) {
		this.account=b1.account;
	
		
	}
	

	


	public void addAccount(Account a1) {
		
		if(account.length<=5) {
	if(account.length==0) {
		account = new Account[1];
		account[0]=a1;
	
	}
	else
	{
		Account[] temp = account;
account = new Account[account.length+1];

for(int i =0;i <temp.length;i++) {
	account[i]=temp[i];
}
account[account.length-1]=a1;
	}
		
	}
	}

	public int getNumberOfAccounts() {
		// TODO Auto-generated method stub
		return account.length;
	}

	public Account[] getReferencesOfAccounts() {
		// TODO Auto-generated method stub
		return account;
	}

	public Account [] getCopiesOfAccounts() {
		accountCopy = new Account[0];
		
		
		for(int i =0; i <account.length;i++) {
			Account a1 = new Account(getReferencesOfAccounts()[i]);
			if(accountCopy.length==0) {
				accountCopy = new Account[1];
				accountCopy[0]=a1;
			
			}
			else
			{
				Account[] temp = accountCopy;
		accountCopy = new Account[accountCopy.length+1];

		for(int j =0;j <temp.length;j++) {
			accountCopy[j]=temp[j];
		}
		accountCopy[accountCopy.length-1]=a1;
			}
				
			
		}
		
		return accountCopy;
	}

	public void addAccounts(Account[] accountsAdd) {
		for(int i =0; i <accountsAdd.length;i++) {
			addAccount(accountsAdd[i]);
		}
		
	}
	public boolean equals (Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; }
		Bank other = (Bank) obj;
		boolean equal = true;
		
		if(this.getNumberOfAccounts()!=other.getNumberOfAccounts()) {
			return false;
		}
		for(int i =0; i <this.account.length;i++) {
			if(this.account[i]!=(other.account[i])) {
				equal=false;
			}
		}
		
		
		return equal;
	}


}
