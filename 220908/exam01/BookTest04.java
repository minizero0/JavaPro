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

public class BookTest04 extends JFrame{
	
	Vector<String> vector;
	JComboBox<String> jcb;
	JTable table;
	Vector<Vector<String>> rateDate;
	
	public void setTable() {
		rateDate.clear();
		String name = jcb.getSelectedItem().toString();
		String sql = "select bookname, price from book where publisher = + '"+name+"'";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			ResultSet re = stmt.executeQuery(sql);
			while(re.next()) {
				Vector<String> v = new Vector<>();
				String a = re.getString(1);
				int b = re.getInt(2);
				v.add(a);
				v.add(b+"");
				rateDate.add(v);
			}
			conn.close();
			stmt.close();
			
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
	}
	
	public BookTest04() {
		setLayout(new BorderLayout());
		rateDate = new Vector<>();
		vector = new Vector<>();
		Vector<String> colName = new Vector<>();
	
		colName.add("도서명");
		colName.add("가격");
		
		table = new JTable(rateDate, colName);
		
		JScrollPane jsp = new JScrollPane(table);		
		jcb = new JComboBox<String>(vector);
		add(jcb, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);

		
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
				table.updateUI();
				
			}
		});
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BookTest04();
	}

}
