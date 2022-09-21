package exam;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;

public class exam01 extends JFrame{
	
	public void book_insert() {
		String sql = "insert into book values(?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			
			
		}catch(Exception e) {
			System.out.println("예외발생"+ e.getMessage());
		}
		
	}
	
	public exam01() {
		
	}
	
	public static void main(String[] args) {
		new exam01();
	}

}
