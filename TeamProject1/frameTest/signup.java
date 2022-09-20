package frameTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class signup extends JFrame{
	JTextField jtf_usrid, jtf_usrpwd, jtf_name, jtf_phone, jtf_addr;
	JButton btn_signUp, btn_confirm;
	
	public void confirm() {
		String usrid = jtf_usrid.getText();
		String sql = "select userid from users";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString(1).equals(usrid))
					JOptionPane.showMessageDialog(null, "이미사용중인 아이디입니다. 다른 아이디를 입력해주세요");
				else
					JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public void info() {
		String usrid = jtf_usrid.getText();
		String usrpwd = jtf_usrpwd.getText();
		String name = jtf_name.getText();
		String phone = jtf_phone.getText();
		String addr = jtf_addr.getText();
		String regex = "^[a-z0-9]*$";			//비밀번호 적합성 판단 소문자 숫자 만 사용가능.
		System.out.println(Pattern.matches(regex, usrpwd));
		
		String sql = "insert into users values('"+usrid+"', '"+usrpwd+"', '"+name+"', '"+phone+"', '"+addr+"')";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			int re = stmt.executeUpdate(sql);
			if(re > 0) {
				JOptionPane.showMessageDialog(null, "가입을 환영합니다"+name+"님!");
			}
			stmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		
	}
	
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
		
		btn_signUp = new JButton("회원가입");
		add(btn_signUp);
		
		btn_confirm = new JButton("아이디 중복확인");
		add(btn_confirm);
		
		btn_signUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				info();
			}
		});
		
		btn_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				confirm();
				
			}
		});
		
		
		setSize(300,400);
		setVisible(true);
	}

}
