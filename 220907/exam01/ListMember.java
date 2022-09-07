package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {	//next()는 Cursor를 다음행으로 옮겨주는 메소드. 다음 레코드가 없으면 false를 반환.
				String name = rs.getString(1);
				String phone = rs.getString(2);
				String addr = rs.getString(3);
				System.out.println(name+", "+phone+", "+addr);
				
			}
			
			stmt.close();
			conn.close();
			rs.close();
			
			
		}catch(Exception e) {
			System.out.println("예외발생:"+ e.getMessage());
		}
	}

}
