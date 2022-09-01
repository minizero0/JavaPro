package exam04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPEchoClient extends JFrame {
	private JTextArea jta;  		//멤버변수
	private JTextField jtf;
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress addr;
	int port = 9002;
	
	
	public UDPEchoClient() {
		jta = new JTextArea();
		jtf = new JTextField();
		try {
			socket = new DatagramSocket();
			addr = InetAddress.getByName("192.168.0.120");
		}catch(Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
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
		
		btn_send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String s = jtf.getText();
				byte data[] = s.getBytes();
				packet = new DatagramPacket(data, data.length, addr, port);
				try {
					socket.send(packet);
					socket.receive(packet);
					String msg = new String(data);
					jta.setText(msg);
				}catch(Exception ex) {
					System.out.println("예외발생:" + ex.getMessage());
				}
				
			}
		});
		
		
	}

	public static void main(String[] args) {
		new UDPEchoClient();
	}

}
