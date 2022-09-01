package exam03;
	
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
	
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			InetAddress add = InetAddress.getByName(args[0]);
			String s = "Mr.cho";
			byte data[] = s.getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, add, 13001);
			
			socket.send(packet);
			socket.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
