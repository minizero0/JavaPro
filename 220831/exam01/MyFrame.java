package exam01;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	private DrawPanel dp;
	
	public MyFrame() {
		dp = new DrawPanel();
		add(dp);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new MyFrame();
	}

}
