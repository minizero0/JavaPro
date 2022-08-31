package Prac;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JList;

public class Dir_Prac extends JFrame{
	
	private JList<String> list;

	public Dir_Prac() {
		File dir = new File("/Users/mini0/Desktop/SsangYong220810");
//		String data[] = {"jo", "koo", "park", "bae", "choi" };
		String data[] = dir.list();
		list = new JList<String>(data);
		add(list);
		setSize(300,400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Dir_Prac();
	}

}
