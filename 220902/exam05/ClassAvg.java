package exam05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClassAvg extends JFrame{
	private JTextField jta01;
	private JTextField jta02;
	private JTextField jta03;
	private JTextField jta04;
	private JTextField jta05;
	
	public ClassAvg() {
		setLayout(new FlowLayout());
		
		jta01 = new JTextField(5);
		jta02 = new JTextField(5);
		jta03 = new JTextField(5);
		jta04 = new JTextField(5);
		jta05 = new JTextField(5);
		
		JLabel label1 = new JLabel("이름");
		JLabel label2 = new JLabel("국어");
		JLabel label3 = new JLabel("영어");
		JLabel label4 = new JLabel("수학");
		JLabel label5 = new JLabel("평균= ");
		
		JButton btn = new JButton("평균 구하기");
		
		add(label1);
		add(jta01);
		add(label2);
		add(jta02);
		add(label3);
		add(jta03);
		add(label4);
		add(jta04);
		add(btn);
		add(label5);
		add(jta05);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(jta02.getText());
				int num2 = Integer.parseInt(jta03.getText());
				int num3 = Integer.parseInt(jta04.getText());
				
				double avg = (num1 + num2 +num3)/3.0;
				jta05.setText(String.format("%.2f", avg));
			}
		});
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ClassAvg();

	}

}
