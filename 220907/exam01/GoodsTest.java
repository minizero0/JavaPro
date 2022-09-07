package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GoodsTest extends JFrame{
	
	private JTextArea jta;
	
	public GoodsTest() {
		jta = new JTextArea();
		setLayout(new BorderLayout());
		
		JButton btn = new JButton("상품 조회");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from goods";
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
					String usr = "c##sist0307";
					String pwd = "sist0307";
					
					Connection conn = DriverManager.getConnection(url, usr, pwd);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					
					while (rs.next()) {
						String a = rs.getString(1);
						int b = rs.getInt(2);
						int c = rs.getInt(3);
						
						jta.append(a + "\t" + b + "\t" + c + "\n" );
					}
					
					conn.close();
					stmt.close();
					rs.close();
					
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
			}
		});
		
		add(jta, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new GoodsTest();
	}

}
