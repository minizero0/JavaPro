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
	
	
	public void pro() {
		String str = "";
		if(jcb01.isSelected() && jcb02.isSelected()) {
			str = "apple, grape all choose";
		}else if(jcb01.isSelected() && !jcb02.isSelected()) {
			str = "choose Apple";
		}else if(!jcb01.isSelected() && jcb02.isSelected()) {
			str = "choose Grape";
		}else {
			str = "choose Nothing";
		}
		jlb01.setText(str);
		
	}
	
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
				
				pro();
			}
		});
		jcb02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pro();
			}
		});
		
		
	}

	public static void main(String[] args) {
		new JCheckBoxTest();
	}

}
