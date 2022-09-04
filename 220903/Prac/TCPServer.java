package Prac;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(12000);
			System.out.println("Server Start");
			Thread.sleep(3000);
			
			while (true) {
				Socket socket = server.accept();
				System.out.println("Client Connect");
				OutputStream os = socket.getOutputStream();
				
				for (int i = 0 ; i < 10; i++) {
					int r = (int)(Math.random() * 100 + 1);
					os.write(r);
				}
				os.close();
				socket.close();
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
