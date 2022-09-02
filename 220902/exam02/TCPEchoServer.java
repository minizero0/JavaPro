package exam02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPEchoServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9010);
			System.out.println("Server Start");
			byte data[] = new byte[100];
			while(true) {
				Socket socket = server.accept();			//연결된 의미를 소켓으로 반환
				System.out.println("Client Connect");
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				while(true) {
					is.read(data);
					os.write(data);						//클라이언트가 보내온 데이터를 그대로 클라이언트에게 보낸다.
					String msg = new String(data);
					System.out.println("getMessage from client :" + msg);
					Arrays.fill(data, (byte)0);
				}
				
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}

}
