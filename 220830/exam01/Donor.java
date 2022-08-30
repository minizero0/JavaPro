package exam01;

public class Donor extends Thread {
	private String name;
	private Account account;	
	public Donor(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}
	@Override
	public void run() {
		for(int i=1;i<1000;i++) {
			System.out.println(name+"의 "+ i + "번째 입금");
			account.deposit(1000);
			try {
				Thread.sleep(100);
			}catch (Exception e) {			
			}			
			if(account.getBalance() >= 500000) {
				break;
			}
		}
	}	
}