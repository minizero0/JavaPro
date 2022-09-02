package exam02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TCPEchoClient extends JFrame{
	JTextArea jta;
	JTextField jtf;
	Socket socket;
	InputStream is;
	OutputStream os;
	
	public TCPEchoClient() {
	
	
	jta = new JTextArea();
	jtf = new JTextField();
	JScrollPane jsp = new JScrollPane(jta);
	
	JPanel p = new JPanel(new BorderLayout());
	JButton btn_send = new JButton("send");
	p.add(jtf, BorderLayout.CENTER); 
	p.add(btn_send, BorderLayout.EAST);
	
	add(jsp, BorderLayout.CENTER);
	add(p, BorderLayout.SOUTH);
	
	setSize(600,400);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	try {
		socket = new Socket("172.30.1.3", 9010);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}catch (Exception e) {
		System.out.println("예외발생:"+e.getMessage());
	}
	
	class ThreadTest extends Thread {
		byte data[] = new byte[100];
		public void run() {
			while(true) {
				try {
				is.read(data);
				jta.append(new String(data) + "\n");
				Arrays.fill(data, (byte)0);
				}catch(Exception e) {
					System.out.println("예외발생:" + e.getMessage());
				}
			}
			
		}
	}
	
	ThreadTest tt = new ThreadTest();
	tt.start();
	
	btn_send.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String msg = jtf.getText();
			try {
				os.write(msg.getBytes());
			}catch(Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
		}
	});
	
}
	public static void main(String[] args) {
		new TCPEchoClient();
	}

}
