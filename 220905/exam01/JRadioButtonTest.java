package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class JRadioButtonTest extends JFrame{

	JRadioButton jrb01;
	JRadioButton jrb02;
	JLabel jlb;
	ButtonGroup bg01;
	
	
	public JRadioButtonTest() {
		setLayout(new FlowLayout());
		bg01 = new ButtonGroup();
		jrb01 = new JRadioButton("Apple");
		jrb02 = new JRadioButton("Grape");
		
		jrb01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jlb.setText(jrb01.getText()+ " choose");
				
			}
		});
		jrb02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jlb.setText(jrb02.getText() + " choose");
				
			}
		});
		
		bg01.add(jrb01);
		bg01.add(jrb02);
		jlb = new JLabel();
		add(jrb01);
		add(jrb02);
		add(jlb);
		
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JRadioButtonTest();
		
	}

}
