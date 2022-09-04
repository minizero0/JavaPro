package exam01;

import java.net.InetAddress;

public class InetTest {

	public static void main(String[] args) {
		try {
			InetAddress arr[] = InetAddress.getAllByName("www.naver.com");
			for(InetAddress a : arr) {
				System.out.println(a);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
