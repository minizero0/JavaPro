package exam05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcFrame extends JFrame {
	JTextField jtf01;
	JTextField jtf02;
	JTextField jtf03;
	
	public CalcFrame() {
		setLayout(new FlowLayout());
		JLabel label = new JLabel("+");
		
		jtf01 = new JTextField(5);
		jtf02 = new JTextField(5);
		jtf03 = new JTextField(5);
		
		JButton btn = new JButton("=");
		
		add(jtf01);
		add(label);
		add(jtf02);
		add(btn);
		add(jtf03);
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
	}

	public static void main(String[] args) {
		new CalcFrame();
	}

}
