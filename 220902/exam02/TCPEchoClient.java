package exam02;

import java.awt.BorderLayout;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

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
		socket = new Socket("172.30.1.3", 9003);
	}catch (Exception e) {
		System.out.println("예외발생:"+e.getMessage());
	}
	}
	public static void main(String[] args) {
		new TCPEchoClient();
	}

}
