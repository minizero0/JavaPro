package exam01;

public class Account {
	private int balance;
	
	public synchronized void deposit(int amount) {
		balance += amount;
	}

	public int getBalance() {
		return balance;
	}
	
	
}
