package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonTest extends JFrame{
	
	public ButtonTest() {
		setLayout(new FlowLayout());
		JButton btn1 = new JButton("man");
		JButton btn2 = new JButton("women");
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = btn1.getText();
				System.out.println(s + "입니다.");
				
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				System.out.println(cmd + "입니다 .");
			}
		});
		
		add(btn1);
		add(btn2);
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ButtonTest();
	}

}
