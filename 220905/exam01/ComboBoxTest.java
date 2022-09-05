package exam01;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxTest extends JFrame{
	JComboBox<String> jcb;
	Vector<String> data;
	JLabel jlb;
	
	public ComboBoxTest() {
		data = new Vector<>();
		data.add("apple");
		data.add("grape");
		data.add("watermelon");
		data.add("banana");
		data.add("orange");
		
		jcb = new JComboBox<String>(data);
		jlb = new JLabel();
		
		setLayout(new FlowLayout());
		add(jcb);
		add(jlb);
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ComboBoxTest();
	}

}
