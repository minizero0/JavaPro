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
		jlb1.setBounds(10, 10, 100, 40);
		
		jta1 = new JTextArea("상품명");
		jta2 = new JTextArea("단가");
		jta3 = new JTextArea("수량");
		
		add(jta1);
		add(jta2);
		add(jta3);
		
		JButton btn = new JButton("입력");
		
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
		
		add(btn);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		new GoodsSaveTest();
	}

}
