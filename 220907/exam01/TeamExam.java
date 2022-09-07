package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Scrollable;

public class TeamExam extends JFrame{
	
	JTable table;
	Vector<Vector<String>> rateData;
	Vector<String> colNames;
	JTextField jtf1,jtf2,jtf3,jtf4;
	
	
	public void insertLib() {
		String sql = "insert into lib values()";
	}
	
	public void list() {
		String sql = "select * from lib";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##sist0307";
			String pwd = "sist0307";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			ResultSet re = stmt.executeQuery(sql);
			
			while(re.next()) {
				int a = re.getInt(1);
				String b = re.getString(2);
				int c = re.getInt(3);
				String d = re.getString(4);
				Vector<String> v = new Vector<String>();
				v.add(a+"");
				v.add(b);
				v.add(c+"");
				v.add(d);
				rateData.add(v);
			}
			conn.close();
			re.close();
			stmt.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
	}
	
	public TeamExam() {
		
		
		rateData = new Vector<Vector<String>>();
		setLayout(new GridLayout(2,1));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new BorderLayout());
		jp2.setLayout(new GridLayout(4,2));
		jp3.setLayout(new FlowLayout());
		
		JLabel jlb1 = new JLabel("도서번호");
		JLabel jlb2 = new JLabel("도서명");
		JLabel jlb3 = new JLabel("가격");
		JLabel jlb4 = new JLabel("출판사");
		
		colNames = new Vector<String>();
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("가격");
		colNames.add("출판사");
		
		list();
		
		table = new JTable(rateData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		add(jsp);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new TeamExam();

	}

}
