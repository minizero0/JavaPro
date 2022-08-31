package exam02;

import javax.swing.JFrame;
import javax.swing.JList;

public class JListTest extends JFrame{
	
	public JListTest() {
		String data[] = {"조영민", "구승현", "구승원", "배재일", "권대현"};
		JList<String> list = new JList<String>(data);
		add(list);
		setSize(400,300);
		setVisible(true);	
	}

	public static void main(String[] args) {
		new JListTest();
	}

}
