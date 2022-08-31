package exam02;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JList;

public class DirTest extends JFrame{
	
	private JList<String> list;
	
	public DirTest() {
		File dir = new File("/Users/mini0/eclipse-workspace/JavaProgramming/src/SsangYong220810"); 
		String data[] = dir.list();
		list = new JList<String>(data);
		add(list);
		setSize(300,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DirTest();
	}

}
