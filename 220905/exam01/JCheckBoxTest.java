package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxTest extends JFrame{
	JCheckBox jcb01;
	JCheckBox jcb02;
	JLabel jlb01;
	
	public JCheckBoxTest() {
		jcb01 = new JCheckBox("Apple");
		jcb02 = new JCheckBox("Grape");
		jlb01 = new JLabel("				");
		
		setLayout(new FlowLayout());
		add(jcb01);
		add(jcb02);
		add(jlb01);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jcb01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jcb02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	public static void main(String[] args) {
		new JCheckBoxTest();
	}

}
