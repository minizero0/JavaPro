package frameTest;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class signin extends JFrame{
	JTextField jtf_id, jtf_pwd;
	JButton btn_signIn;
	
	public signin() {
		setLayout(new GridLayout(3,2));
		btn_signIn = new JButton("로그인");
		
		jtf_id = new JTextField(5);
		jtf_pwd = new JTextField(5);
		
		JLabel jlb1 = new JLabel("아이디:");
		JLabel jlb2 = new JLabel("비밀번호:");
		
		add(jlb1);
		add(jtf_id);
		add(jlb2);
		add(jtf_pwd);
		add(btn_signIn);
		
		
		
		setSize(300,400);
		setVisible(true);
				
	}

}
