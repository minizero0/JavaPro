package frameTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class signin extends JFrame{
	JTextField jtf_id, jtf_pwd;
	JButton btn_signIn;
	
	public void login() {
		String usrid = jtf_id.getText();
		String usrpwd = jtf_pwd.getText();
		
		String sql = "select userid, userpwd from users";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(usrid);
				System.out.println(usrpwd);
				if(rs.getString(1).equals(usrid) && rs.getString(2).equals(usrpwd)) {
					JOptionPane.showMessageDialog(null, "로그인에 성공했습니다"+usrid+"님");
					dispose();	// system.exit()는 모든 프레임 즉,프로그램을 종료시킨다 
								// 반면 dispose()는 현재 프레임만 종료시킨다.
				}
				else
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 옳바르지 않습니다.");
			}
			conn.close();
			stmt.close();
			rs.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	
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
		
		btn_signIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		setSize(300,400);
		setVisible(true);
				
	}

}
