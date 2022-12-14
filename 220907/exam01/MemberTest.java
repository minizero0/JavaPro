package exam01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;

public class MemberTest extends JFrame{
	
	private JTextField jtf_name, jtf_phone;
	private JTextArea jta_addr;
	
	public MemberTest() {
		setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.setLayout(null);
		jp2.setLayout(new GridLayout(1,3,10,0));
		
		JLabel jlb_name = new JLabel("이름:");
		jlb_name.setBounds(20, 20, 100, 40);
		jp1.add(jlb_name);
		
		JLabel jlb_phone = new JLabel("전화:");
		jlb_phone.setBounds(20, 60, 100, 40);
		jp1.add(jlb_phone);
		
		JLabel jlb_addr = new JLabel("주소:");
		jlb_addr.setBounds(20, 110, 100, 40);
		jp1.add(jlb_addr);
		
		
		jtf_name = new JTextField();
		jtf_phone = new JTextField();
		jta_addr = new JTextArea();
		
		jtf_name.setBounds(120, 20, 200, 30);
		jp1.add(jtf_name);
		
		jtf_phone.setBounds(120, 60, 200, 30);
		jp1.add(jtf_phone);
		
		
		jta_addr.setBounds(20, 150, 350, 70);
		jp1.add(jta_addr);
		
		add(jp1, BorderLayout.CENTER);
		
		JButton btn_save = new JButton("저장");
		JButton btn_search = new JButton("검색");
		JButton btn_exit = new JButton("종료");
		
		jp2.add(btn_save);
		jp2.add(btn_search);
		jp2.add(btn_exit);
		
		btn_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jtf_name.getText();
				String phone = jtf_phone.getText();
				String addr = jta_addr.getText();
				
				String sql = "insert into member values('"+name+"','"+phone+"','"+addr+"')";
				
				try {
					//1.jdbc드라이버를 메모리로 로드한다.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					
					//2.DB서버에 연결
					String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
					String user = "c##sist0307";
					String pwd = "sist0307";
					Connection conn = DriverManager.getConnection(url,user,pwd);
					
					//3.sql명령 실행하기위한 Statement객체 생성.
					Statement stmt = conn.createStatement();
					
					//4.sql명령 실행.
					int re = stmt.executeUpdate(sql);			//re 1이면 성공
					
					if (re == 1) {
						JOptionPane.showMessageDialog(null, "회원의 정보를 추가하였습니다.");
					}
					
					//5.사용했던 자원들을 닫아 줍니다.
					stmt.close();
					conn.close();
					
					
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
			}
		});
		
		add(jp2, BorderLayout.SOUTH);
		
		setSize(400,350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new MemberTest();
	}

}
