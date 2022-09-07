package exam01;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextArea;

public class GoodsTestGUI2_Update extends JFrame{
	
	private JTextArea jta1,jta2,jta3;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	JTable table;
	
	public void insertGoods() {
		String name = jta1.getText();
		int price = Integer.parseInt(jta2.getText()); 
		int num = Integer.parseInt(jta3.getText());
		
		String sql = "insert into goods values('"+name+"', "+price+", "+num+")";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##sist0307";
			String pwd = "sist0307";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			
			Statement stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if (re == 1) {
				JOptionPane.showMessageDialog(null, "입력완료");
			}
			
			conn.close();
			stmt.close();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void updateGoods() {
		String name = jta1.getText();
		int price = Integer.parseInt(jta2.getText());
		int num = Integer.parseInt(jta3.getText());
		
		
		String sql = "update goods set price = " + price + ", qty = " + num + "WHERE item = '"+name+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##sist0307";
			String pwd = "sist0307";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if(re > 0) {
				JOptionPane.showMessageDialog(null, "수정완료");
			}
			
			conn.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
	}
	
	public void deleteGoods() {
		String name = jta1.getText();
		String sql = "delete goods where item = '" + name + "'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##sist0307";
			String pwd = "sist0307";
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			int re = stmt.executeUpdate(sql);
			if(re > 0) {					//삭제한 레코드가 즉, 이름이 같은 데이터가 2개가 삭제되면 re는 2가된다.
				JOptionPane.showMessageDialog(null, "삭제 완료");
			}
			conn.close();
			stmt.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:" +e.getMessage());
		}
	}
	
	public void listGoods() {
		rowData.clear();
		
		try {
			String sql = "select * from goods";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##sist0307";
			String pwd = "sist0307";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				int price = rs.getInt(2);
				int num = rs.getInt(3);
				Vector<String> v1 = new Vector<String>();
				v1.add(name);
				v1.add(price+"");
				v1.add(num+"");
				rowData.add(v1);
				
			}
			
			conn.close();
			stmt.close();
			rs.close();
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

	public GoodsTestGUI2_Update() {
		setLayout(new GridLayout(2,1));
		
		rowData = new Vector<Vector<String>>();
		colNames = new Vector<String>();
		colNames.add("상품평");
		colNames.add("가격");
		colNames.add("수량");
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		
		add(jsp);
		listGoods();
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel jlb1 = new JLabel("상품명");
		jlb1.setBounds(10, 20, 100, 40);
		
		jp1.add(jlb1);
		
		JLabel jlb2 = new JLabel("단가");
		jlb2.setBounds(10, 60, 100, 40);
		jp1.add(jlb2);
		
		JLabel jlb3 = new JLabel("수량");
		jlb3.setBounds(10, 100, 100, 40);
		jp1.add(jlb3);
		
		jta1 = new JTextArea();
		jta2 = new JTextArea();
		jta3 = new JTextArea();
		
		jta1.setBounds(120, 20, 200, 30);
		jta2.setBounds(120, 60, 200, 30);
		jta3.setBounds(120, 100, 200, 30);
		
		jp1.add(jta1);
		jp1.add(jta2);
		jp1.add(jta3);
		
		JButton btn = new JButton("등록");
		JButton btn1 = new JButton("수정");
		JButton btn2 = new JButton("삭제");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insertGoods();
				listGoods();
				table.updateUI();
				//vector의 변경된 내용을 가지고 테이블에 적용
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateGoods();
				listGoods();
				table.updateUI();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteGoods();
				listGoods();
				table.updateUI();
			}
		});
		
		btn.setBounds(80, 160, 50, 30);
		btn1.setBounds(140, 160, 50, 30);
		btn2.setBounds(200, 160, 50, 30);
		
		jp1.add(btn);
		jp1.add(btn1);
		jp1.add(btn2);
		add(jp1);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = table.getSelectedRow();
				Vector<String> v = rowData.get(row);
				String name = v.get(0);
				int price = Integer.parseInt(v.get(1)); 
				int num = Integer.parseInt(v.get(2));
				
				jta1.setText(name);
				jta2.setText(price+"");
				jta3.setText(num+"");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		new GoodsTestGUI2_Update();
	}

}
