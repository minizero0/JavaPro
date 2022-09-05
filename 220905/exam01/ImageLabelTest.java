package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageLabelTest extends JFrame{
	
	ImageIcon icon_apple;
	ImageIcon icon_banana;
	JLabel jlb;
	
	public ImageLabelTest() {
		icon_apple = new ImageIcon("apple.png");
		icon_banana = new ImageIcon("banana.jpg");
		
		setLayout(new FlowLayout());
		
		JLabel jlb1 = new JLabel(icon_apple);
		JLabel jlb2 = new JLabel(icon_banana);
		
		add(jlb1);
		
		JButton btn1 = new JButton("apple");
		JButton btn2 = new JButton("banana");
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jlb1.setIcon(icon_apple);
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jlb1.setIcon(icon_banana);
			}
		});
		add(btn1);
		add(btn2);
		
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args) {
		new ImageLabelTest();
	}

}
