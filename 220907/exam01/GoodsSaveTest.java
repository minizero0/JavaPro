package exam01;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class GoodsSaveTest extends JFrame{
	
	private JTextArea jta1,jta2,jta3;
	Vector<Vector<String>> rowData;
	JTable table;
	

	public GoodsSaveTest() {
		setLayout(new GridLayout(2,1));
		Vector<String> colNames = new Vector<String>();
		colNames.add("상품평");
		colNames.add("가격");
		colNames.add("수량");
		
		rowData = new Vector<Vector<String>>();
		Vector<String> v1 = new Vector<String>();
		v1.add("red");
		v1.add(1000+"");
		v1.add(10+"");
		Vector<String> v2 = new Vector<String>();
		v2.add("blue");
		v2.add(2000+"");
		v2.add(15+"");
		rowData.add(v1);
		rowData.add(v2);
		
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		add(jsp);
		
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
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
		
		btn.setBounds(150, 160, 100, 50);
		
		jp1.add(btn);
		add(jp1);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		new GoodsSaveTest();
	}

}
