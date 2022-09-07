package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GoodsSaveTest extends JFrame{
	
	private JTextArea jta1,jta2,jta3;

	public GoodsSaveTest() {
		setLayout(null);
		
		JLabel jlb1 = new JLabel("상품명");
		jlb1.setBounds(10, 20, 100, 40);
		add(jlb1);
		
		JLabel jlb2 = new JLabel("단가");
		jlb2.setBounds(10, 60, 100, 40);
		add(jlb2);
		
		JLabel jlb3 = new JLabel("수량");
		jlb3.setBounds(10, 100, 100, 40);
		add(jlb3);
		
		jta1 = new JTextArea();
		jta2 = new JTextArea();
		jta3 = new JTextArea();
		
		jta1.setBounds(120, 20, 200, 30);
		jta2.setBounds(120, 60, 200, 30);
		jta3.setBounds(120, 100, 200, 30);
		
		add(jta1);
		add(jta2);
		add(jta3);
		
		JButton btn = new JButton("등록");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jta1.getText();
				String price = jta2.getText();
				String num = jta3.getText();
				
				String sql = "insert into goods values('"+name+"', '"+price+"', '"+num+"')";
				
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
		
		add(btn);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		new GoodsSaveTest();
	}

}
