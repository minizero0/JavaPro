package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Hoemwork01 extends JFrame{
	
	JTextField jtf;
	JTable table;
	Vector<Vector<String>> vector;
	Vector<String> colName;
	
	public void list() {
		vector.clear();
		String sql = "select * from orders";
		
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String user = "c##homework";
			String pwd = "homework";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> v1 = new Vector<String>();
				v1.add(rs.getInt(1)+"");
				v1.add(rs.getInt(2)+"");
				v1.add(rs.getInt(3)+"");
				v1.add(rs.getInt(4)+"");
				vector.add(v1);
			}
			conn.close();
			stmt.close();
			rs.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
	}
	
	
	public void search() {
		vector.clear();
		int id = Integer.parseInt(jtf.getText()); 
		String sql = "select * from orders where memberid = "+id+"";
		
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String user = "c##homework";
			String pwd = "homework";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> v1 = new Vector<String>();
				v1.add(rs.getInt(1)+"");
				v1.add(rs.getInt(2)+"");
				v1.add(rs.getInt(3)+"");
				v1.add(rs.getInt(4)+"");
				vector.add(v1);
			}
			conn.close();
			stmt.close();
			rs.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
	}
	
	public Hoemwork01() {
		jtf = new JTextField(5);
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		vector = new Vector<Vector<String>>();
		setLayout(new BorderLayout());
		colName = new Vector<>();
		colName.add("주문번호");
		colName.add("고객번호");
		colName.add("도서번호");
		colName.add("구매금액");
		table = new JTable(vector, colName);
		JScrollPane jsp = new JScrollPane(table);
		list();
		
		JButton btn = new JButton("검색");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
				table.updateUI();
			}
		});
		
		jp.add(jtf);
		jp.add(btn);
		
		add(jsp, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
		
	
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new Hoemwork01();
	}

}
