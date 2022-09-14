package exam04;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MyFrame1 extends JFrame{
	
	GenderPanel p1;
	InfoPanel p2;
	
	public MyFrame1() {
		p1 = new GenderPanel();
		p2 = new InfoPanel();
		
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("성별", p1);
		tab.addTab("성별", p2);
		add(tab);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyFrame1();
	}

}
