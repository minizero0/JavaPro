package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class BookTest extends JFrame{
	
	JTable table;
	JTextArea jta;
	Vector<Vector<String>> v1;
	
	
	public BookTest() {
		setLayout(new BorderLayout());
		v1 = new Vector<>();
		Vector<String> v2 = new Vector<>();
		v2.add("출판사");
		
		table = new JTable(v1,v2);
		add(table, BorderLayout.CENTER);
		jta = new JTextArea();
		add(jta, BorderLayout.SOUTH);
		String sql = "select distinct publisher from book";
		String produce = "hello";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			ResultSet re = stmt.executeQuery(sql);
			while(re.next()) {
				String name = re.getString(1);
				Vector<String> v = new Vector<>();
				v.add(name);
				v1.add(v);
				jta.append(name + "\n");
			}
			conn.close();
			stmt.close();
			
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BookTest();
	}

}
