package exam04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPEchoServer {

	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			
			byte data[] = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			while(true) {
				socket.receive(packet);
				String msg = new String(data);
				System.out.println("수신된 데이터 : " +msg);
				socket.send(packet);
				Arrays.fill(data, (byte)0);
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}

}
