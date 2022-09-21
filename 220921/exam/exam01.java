package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

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
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			System.out.println("예외발생"+ e.getMessage());
		}
		
	}
	
	public exam01() {
		Scanner sc = new Scanner(System.in);
		int bookid = sc.nextInt();
		String bookname = sc.next();
		String publisher = sc.next();
		int price = sc.nextInt();
	}
	
	public static void main(String[] args) {
		new exam01();
	}

}
