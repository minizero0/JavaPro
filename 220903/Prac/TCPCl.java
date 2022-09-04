package Prac;

import java.io.InputStream;
import java.net.Socket;

public class TCPCl {

	public static void main(String[] args) {
		try {
			
			Socket socket = new Socket("172.30.1.3", 12000);
			
			InputStream is = socket.getInputStream();
			for(int i = 0 ; i < 10; i ++) {
				System.out.println(is.read() + " ");
			}
			System.out.println(socket.getPort());
			is.close();
			socket.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
