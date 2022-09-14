package exam04;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoPanel extends JPanel{
	
	public InfoPanel() {
		setLayout(new GridLayout(2,2));
		add(new JLabel("이름:"));
		add(new JTextField(10));
		add(new JLabel("나이:"));
		add(new JTextField(10));
		
		
	}

}
