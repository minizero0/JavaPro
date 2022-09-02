package exam02;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9003);
			while(true) {
				Socket socket = server.accept();
				System.out.println("Client connect");
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}

}
