package frameTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Board_Write extends JFrame{
	
	String cate,title,content;
	int price;
	
	public void write() {

		String sql = "insert into product values(seq_proid.nextval,?,?,?,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.120:1521:XE", 
					"c##project1", "project1");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cate);
			pstmt.setString(2, title);
			pstmt.setInt(3, price);
			pstmt.setString(4, content);
			int re =pstmt.executeUpdate();
			if (re == 1) {
				JOptionPane.showMessageDialog(null, "삽입성공!");
				dispose();
			}
			conn.close();
			pstmt.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	
	public Board_Write() {
		Scanner sc = new Scanner(System.in);
		JButton btn_add = new JButton("올리기");
		add(btn_add);
		
		
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("정보입력");
				
				cate = sc.next();
				title = sc.next();
				price = sc.nextInt();
				content = sc.next();
				
				write();
			}
		});

		
		
		setSize(300,400);
		setVisible(true);
		
		
	}

}
