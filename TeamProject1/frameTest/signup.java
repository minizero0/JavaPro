package frameTest;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class signup extends JFrame{
	JTextField jtf_usrid, jtf_usrpwd, jtf_name, jtf_phone, jtf_addr;
	JButton btn_singUp;
	
	public signup() {
		setLayout(new GridLayout(6,2));
		
		JLabel jlb1 = new JLabel("아이디:");
		JLabel jlb2 = new JLabel("비밀번호:");
		JLabel jlb3 = new JLabel("이름:");
		JLabel jlb4 = new JLabel("전화번호:");
		JLabel jlb5 = new JLabel("주소:");
		
		jtf_usrid = new JTextField(5);
		jtf_usrpwd = new JTextField(5);
		jtf_name = new JTextField(5);
		jtf_phone = new JTextField(5);
		jtf_addr = new JTextField(5);
		
		add(jlb1);
		add(jtf_usrid);
		add(jlb2);
		add(jtf_usrpwd);
		add(jlb3);
		add(jtf_name);
		add(jlb4);
		add(jtf_phone);
		add(jlb5);
		add(jtf_addr);
		
		btn_singUp = new JButton("회원가입");
		add(btn_singUp);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new signup();

	}

}
