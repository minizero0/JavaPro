package exam01;

public class TVArs {
	public static void main(String[] args) {
		Account account = new Account();
		Donor d1 = new Donor("김유신", account);
		Donor d2 = new Donor("이순신", account);
		Donor d3 = new Donor("유관순", account);
		Donor d4 = new Donor("홍길동", account);
		Donor d5 = new Donor("강감찬", account);
		
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("총 모금액 : "+ account.getBalance());
		
	}
}