package exam05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FactorialTest extends JFrame{
	
	public FactorialTest() {
		setLayout(new FlowLayout());
		
		JTextField jta01 = new JTextField(5);
		JTextField jta02 = new JTextField(5);
		
		JButton btn = new JButton("Factorial");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(jta01.getText());
				int result = 1;
				while (n > 0) 
					result *= n--;
				jta02.setText(result+"");
				
			}
		});
		
		add(jta01);
		add(btn);
		add(jta02);
		
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new FactorialTest();
	}

}
