package TeamExam;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RandomGUI extends JFrame{
	private int cnt = 0;
	
	public RandomGUI() {
		int r = (int)(Math.random() * 100 + 1);
		setLayout(new BorderLayout());
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		JTextField jtf = new JTextField();
		JButton btn = new JButton("입력");
		JPanel jp = new JPanel(new BorderLayout());
		
		
		jp.add(jtf, BorderLayout.CENTER);
		jp.add(btn, BorderLayout.EAST);
		
		add(jsp, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int n = Integer.parseInt(jtf.getText());
					
					cnt++;
					if (r > n) 
						jta.append("입력한 수" + (n+"") + "보다 높은 수를 입력하세요.\n");
					else if(n == r) 
						jta.append("정답\n입력 횟수:" + cnt + "");
					else
						jta.append("입력한 수" + (n+"") + "보다 낮은 수를 입력하세요.\n");
					
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			
		});
		
		
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new RandomGUI();
	}

}
