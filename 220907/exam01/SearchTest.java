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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SearchTest extends JFrame{
	
	private JTextArea jta;
	
	public SearchTest() {
		setLayout(new BorderLayout());
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		JButton btn = new JButton("회원정보 출력");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "select name,phone,addr from member";
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
					String usr = "c##sist0307";
					String pwd = "sist0307";
					Connection conn = DriverManager.getConnection(url, usr, pwd);
					
					Statement stmt = conn.createStatement();
					
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						String name = rs.getString(1);
						String phone = rs.getString(2);
						String addr = rs.getString(3);
						jta.setText("이름:" + name + ", 전화:" + phone + ", 주소:" + addr+ "\n");
						System.out.println(name+", "+phone+", "+addr);
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
		new SearchTest();
	}

}
