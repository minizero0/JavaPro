package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SearchTest extends JFrame{
	
	private JTextArea jta;
	
	public SearchTest() {
		setLayout(new BorderLayout());
		jta = new JTextArea();
		JButton btn = new JButton("회원정보 출력");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "select name,phone,addr from member";
				
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
