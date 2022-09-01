package exam02;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(13000);
			System.out.println("Server Started");
			Thread.sleep(3000);
			while(true) {
				Socket socket = server.accept();
				System.out.println("Client connect");
				OutputStream os = socket.getOutputStream();
				
				for (int i = 0; i < 10; i++) {
					int r = (int)(Math.random() * 100 + 1);
					os.write(r);
					Thread.sleep(100);
				}
				os.close();
				socket.close();
			}
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}

}
