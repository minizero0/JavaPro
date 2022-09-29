package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class exam01 extends JFrame{
	
	int bookid, price;
	String bookname, publisher;
	
	public void book_insert() {
		String sql = "insert into book values(?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookid);
			pstmt.setString(2,bookname);
			pstmt.setString(3,publisher);
			pstmt.setInt(4, price);
			
			int re =pstmt.executeUpdate();
			if (re == 1) {
				JOptionPane.showMessageDialog(null, "삽입성공!");
			}
			conn.close();
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println("예외발생"+ e.getMessage());
		}
		
	}
	
	public exam01() {
		Scanner sc = new Scanner(System.in);
		bookid = sc.nextInt();
		bookname = sc.next();
		publisher = sc.next();
		price = sc.nextInt();
		book_insert();
	}
	
	public static void main(String[] args) {
		new exam01();
	}

}
