package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxTest02 extends JFrame{
	String arr[] = {"사과", "포도", "수박", "오렌지", "바나나"};
	JCheckBox jcb[] = new JCheckBox[5];
	JLabel jlb;
	
	public void pro() {
		boolean flag = false;
		String str = "";
		
		for (int i = 0; i < arr.length; i ++) {
			if (jcb[i].isSelected()) {
				str += jcb[i].getText() + ",";
				flag = true;
			}
		}
		
		if (flag) {
			str = str.substring(0, str.length()-1);
			str += "를(을)선택하였습니다.";
		}else {
			str = "아무것도 선택하지 않았습니다.";
		}
		jlb.setText(str);
	}
	
	public JCheckBoxTest02() {
		setLayout(new FlowLayout());
		for (int i = 0; i < arr.length; i++) {
			jcb[i] = new JCheckBox(arr[i]);
			add(jcb[i]);
			
			jcb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					pro();
					
				}
			});
		}
		jlb = new JLabel("Nothing choose");
		add(jlb);
		
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JCheckBoxTest02();
	}

}
