package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.border.Border;

public class TeamExam extends JFrame{
	
	JTable table;
	Vector<Vector<String>> rateData;
	Vector<String> colNames;
	JTextField jtf1,jtf2,jtf3,jtf4;
	
	
	public void insertLib() {
		int num = Integer.parseInt(jtf1.getText());
		String name = jtf2.getText();
		int price = Integer.parseInt(jtf3.getText());
		String produce = jtf4.getText();
		
		String sql = "insert into lib values("+ num +", '"+name+"', "+price+", '"+produce+"')";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##sist0307";
			String pwd = "sist0307";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if (re == 1) {
				JOptionPane.showMessageDialog(null, "성공적으로 저장");
			}
			conn.close();
			stmt.close();
			
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
	}
	
	public void updateLib() {
		int num= Integer.parseInt(jtf1.getText());
		String name = jtf2.getText();
		int price = Integer.parseInt(jtf3.getText());
		String produce = jtf4.getText();
		
		String sql = "update lib set name = '"+name+"', price = "+price+", produce ='"+produce+"' where num = "+num+"";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##sist0307";
			String pwd = "sist0307";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public void list() {
		String sql = "select * from lib";
		rateData.clear();
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
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		
		jp2.add(jlb1);
		jp2.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		jp2.add(jlb3);
		jp2.add(jtf3);
		jp2.add(jlb4);
		jp2.add(jtf4);
		
		jp1.add(jp2, BorderLayout.CENTER);
		
		JButton btn1 = new JButton("저장");
		JButton btn2 = new JButton("수정");
		JButton btn3 = new JButton("삭제");
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertLib();
				list();
				table.updateUI();
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		jp3.add(btn1);
		jp3.add(btn2);
		jp3.add(btn3);
		
		jp1.add(jp3, BorderLayout.SOUTH);
		
		
		
		colNames = new Vector<String>();
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("가격");
		colNames.add("출판사");
		
		list();
		
		table = new JTable(rateData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		add(jsp);
		add(jp1);
		
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new TeamExam();

	}

}
