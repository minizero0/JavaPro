package exam01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboBoxTest02 extends JFrame{
	
	JComboBox<String> jcb;
	Vector<String> data;
	
	public ComboBoxTest02() {
		setLayout(new BorderLayout());
		data = new Vector<>();
		JPanel jp = new JPanel();
		data.add("red");
		data.add("blue");
		data.add("green");
		data.add("black");
		jcb = new JComboBox<String>(data);
		
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String)jcb.getSelectedItem();
				
				switch(item) {
					case "blue": jp.setBackground(Color.blue); break;
					case "red": jp.setBackground(Color.red); break;
					case "green": jp.setBackground(Color.green); break;
					case "black": jp.setBackground(Color.black); break;
				}
				
			}
		});
		
		
		add(jcb, BorderLayout.NORTH);
		add(jp, BorderLayout.CENTER);
		
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ComboBoxTest02();
	}

}
