package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class BookTest03 extends JFrame{
	
	Vector<String> vector;
	JTextArea jta;
	JComboBox<String> jcb;
	JTable table;
	
	public void setTable() {
		jta.setText("");
		String name = jcb.getSelectedItem().toString();
		String sql = "select bookname from book where publisher = + '"+name+"'";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			ResultSet re = stmt.executeQuery(sql);
			while(re.next()) {
				String a = re.getString(1);
				jta.append(a+"\n");
			}
			conn.close();
			stmt.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
	}
	
	public BookTest03() {
		setLayout(new BorderLayout());
		vector = new Vector<>();
		jcb = new JComboBox<String>(vector);
		add(jcb, BorderLayout.NORTH);
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		add(jta,BorderLayout.CENTER);
		
		String sql = "select distinct publisher from book";
		
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
				vector.add(name);
			}
			conn.close();
			stmt.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setTable();
				
			}
		});
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BookTest03();
	}

}
