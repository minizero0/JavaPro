package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioTest extends JFrame{
	
	JRadioButton btn[] = new JRadioButton[5];
	String arr[] = {"apple", "banana", "grape", "peach", "persimmon"};
	ImageIcon icon_apple;
	ImageIcon icon_banana;
	ImageIcon icon_grape;
	ImageIcon icon_peach;
	ImageIcon icon_persimmon;
	ButtonGroup bg;
	JLabel jlb;
	
	public RadioTest() {
		bg = new ButtonGroup();
		setLayout(new BorderLayout());
		JPanel jp1 = new JPanel(new GridLayout(5,1));
		
		icon_apple = new ImageIcon("apple.png");
		icon_banana = new ImageIcon("banana.jpg");
		icon_grape = new ImageIcon("grape.png");
		icon_peach = new ImageIcon("peach.png");
		icon_persimmon = new ImageIcon("persimmon.jpeg");
		
		JLabel jlb1 = new JLabel(icon_apple);
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JRadioButton(arr[i]);
			jp1.add(btn[i]);
			bg.add(btn[i]);
			
			btn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String item = e.getActionCommand();
					switch(item) {
						case "apple": jlb1.setIcon(icon_apple);break;
						case "grape": jlb1.setIcon(icon_grape);break;
						case "banana": jlb1.setIcon(icon_banana);break;
						case "peach": jlb1.setIcon(icon_peach);break;
						case "persimmon": jlb1.setIcon(icon_persimmon);break;
					}
				}
			});
		}
		add(jlb1, BorderLayout.CENTER);
		
		add(jp1, BorderLayout.WEST);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new RadioTest();
	}

}
