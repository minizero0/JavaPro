package exam01;

import java.net.InetAddress;

public class InetAddressTest02 {
	public static void main(String[] args) {
		try {
			InetAddress addr[] = InetAddress.getAllByName("www.naver.com");
			for (int i = 0; i < addr.length; i++)
				System.out.println(addr[i]);
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
}
