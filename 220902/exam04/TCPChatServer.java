package exam04;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

class ServerThread extends Thread{
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	public ServerThread(Socket socket) {
		this.socket = socket;
		
		try {
				
			is = socket.getInputStream();
			os = socket.getOutputStream();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
	}
	
	public void run() {
		byte data[] = new byte[100];
		while(true) {
			try {
			is.read(data);
			sendAll(data);
			String msg = new String(data);
			System.out.println("getMessage from Client :" + msg);
			Arrays.fill(data, (byte)0);
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
	}
	public void sendAll(byte data[]) {
		for (ServerThread c : TCPChatServer.list) {
			try {
				c.os.write(data);
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
	}
}



public class TCPChatServer {

	public static ArrayList<ServerThread> list;
	
	public static void main(String[] args) {
		ServerThread st;
		
		try {
			list = new ArrayList<ServerThread>();
			ServerSocket server = new ServerSocket(9011);
			System.out.println("Server Start");
			byte data[] = new byte[100];
			while(true) {
				Socket socket = server.accept();			//연결된 의미를 소켓으로 반환
				System.out.println("Client Connect");
				st = new ServerThread(socket);
				list.add(st);
				st.start();
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}

}
