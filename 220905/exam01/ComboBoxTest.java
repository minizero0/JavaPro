package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String)jcb.getSelectedItem(); 			//콤보박스에서 선택된 아이템;
				jlb.setText(item);										//라벨에 선택된 콤보박스 설정
				
			}
		});
		
		setLayout(new BorderLayout());
		add(jcb, BorderLayout.NORTH);
		add(jlb, BorderLayout.CENTER);
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ComboBoxTest();
	}

}
