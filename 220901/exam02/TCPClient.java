package exam02;

import java.io.InputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.120", 12000);//서버 아이피 주소 , 포트번호 
			InputStream is = socket.getInputStream();
			for (int i = 0; i < 10; i++) {
				System.out.print(is.read() + " ");
			}
			System.out.println(socket.getPort());
			is.close();
			socket.close();
			
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}

}
