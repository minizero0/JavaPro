package exam01;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Team extends JFrame {
	
	JTable table;
	Vector<Vector<String>> vector;
	Vector<String> colName;
	JTextField jtf;
	
	public void list() {
		vector.clear();
		System.out.println("조회할 부서를 입력하세요.");
		String name = jtf.getText();
		String sql = "select ename, salary, addr, hiredate from emp e, dept d where e.dno = d.dno and dname = '"+name+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Vector<String> v = new Vector<>();
				String a = rs.getString(1);
				int b = rs.getInt(2);
				String c = rs.getString(3);
				Date d = rs.getDate(4);
				v.add(a);
				v.add(b+"");
				v.add(a);
				v.add(d+"");
				vector.add(v);
				System.out.println("이름: " +a+ ", 급여: " + b + ", 주소: " + c + ", 입사일: " + d);
			}
			
			conn.close();
			stmt.close();
			rs.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
	
	public Team() {
		setLayout(new BorderLayout());
		jtf = new JTextField(10);
		vector = new Vector<>();
		colName = new Vector<>();
		colName.add("이름");
		colName.add("급여");
		colName.add("주소");
		colName.add("입사일");
		
		table = new JTable(vector, colName);
		
		list();
		table.updateUI();
		add(table, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		
		
	}
	
	public static void main(String[] args) {
		new Team();
	}
}
