package exam05;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SubContainerTest extends JFrame{
	
	public SubContainerTest() {
		setLayout(new BorderLayout());
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		JTextField jtf = new JTextField();
		JButton btn = new JButton("send");
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(jtf, BorderLayout.CENTER);
		jp.add(btn, BorderLayout.EAST);
		
		add(jp, BorderLayout.SOUTH);
		add(jsp, BorderLayout.CENTER);
		
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SubContainerTest();
	}

}
