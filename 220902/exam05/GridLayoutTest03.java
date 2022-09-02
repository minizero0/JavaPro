package exam05;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest03 extends JFrame {
	
	public GridLayoutTest03() {
		setLayout(new GridLayout(3,5));
		for(int i = 0; i < 13; i++) {
			add(new JButton("버튼" + (i+1)));
		}
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GridLayoutTest03();

	}

}
