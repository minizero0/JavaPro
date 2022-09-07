package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ListMember extends JFrame{

	public static void main(String[] args) {
		String sql = "select name,phone,addr from member";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##sist0307";
			String pwd = "sist0307";
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			
			Statement stmt = conn.createStatement();
			
			int re = stmt.executeUpdate(sql);
			
			if (re == 1) {
				JOptionPane.showMessageDialog(null, "조회완료");
			}
			
			
		}catch(Exception e) {
			System.out.println("예외발생:"+ e.getMessage());
		}
	}

}
