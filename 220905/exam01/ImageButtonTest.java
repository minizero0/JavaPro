package exam01;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageButtonTest extends JFrame{
	
	public ImageButtonTest() {
		setLayout(new FlowLayout());
		ImageIcon icon = new ImageIcon("apple.png");
		JButton btn = new JButton(icon);
		add(btn);
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ImageButtonTest();
	}

}
