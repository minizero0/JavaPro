package exam01;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberTest extends JFrame{
	
	private JTextField jtf_name, jtf_phone;
	private JTextArea jta_addr;
	
	public MemberTest() {
		setLayout(null);
		JLabel jlb_name = new JLabel("이름:");
		jlb_name.setBounds(20, 20, 100, 40);
		add(jlb_name);
		
		JLabel jlb_phone = new JLabel("전화:");
		jlb_phone.setBounds(20, 60, 100, 40);
		add(jlb_phone);
		
		JLabel jlb_addr = new JLabel("주소:");
		jlb_addr.setBounds(20, 110, 100, 40);
		add(jlb_addr);
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtf_name = new JTextField();
		jtf_phone = new JTextField();
		jta_addr = new JTextArea();
		
		jtf_name.setBounds(120, 20, 150, 30);
		add(jtf_name);
		
		jtf_phone.setBounds(120, 60, 150, 30);
		add(jtf_phone);
		
		
		jta_addr.setBounds(0, 150, 300, 300);
		add(jta_addr);
		
	}

	public static void main(String[] args) {
		new MemberTest();
	}

}
