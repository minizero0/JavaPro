package exam04;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GenderPanel extends JPanel{
	
	public GenderPanel() {
		setLayout(new FlowLayout());
		JRadioButton jrb01 = new JRadioButton("남자");
		JRadioButton jrb02 = new JRadioButton("여자");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb01);
		bg.add(jrb02);
		add(jrb01);
		add(jrb02);
		
	}
	
}
