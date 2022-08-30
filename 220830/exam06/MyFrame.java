package exam06;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private LinePanel lp;
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
