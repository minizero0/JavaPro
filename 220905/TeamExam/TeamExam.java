package TeamExam;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TeamExam extends JFrame{
	
	JRadioButton btn[] = new JRadioButton[3];
	String arr[] = {"Small", "Medium", "Large"};
	int price[] = {3000,4000,5000};
	JLabel jlb,jlb1,jlb2;
	ButtonGroup bg;
	JTextField jtf;
	
	public TeamExam() {
		jtf = new JTextField();
		JPanel jp = new JPanel(new GridLayout(4,2));
		setLayout(new BorderLayout());
		bg = new ButtonGroup();
		
		jlb1 = new JLabel("커피 크기");
		jlb2 = new JLabel("가격(원)");
		jp.add(jlb1);
		jp.add(jlb2);
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JRadioButton(arr[i]);
			jp.add(btn[i]);
			bg.add(btn[i]);
			jlb = new JLabel(price[i]+"");
			jp.add(jlb);
			
			btn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = (String)e.getActionCommand();
					switch(cmd) {
						case "Small":jtf.setText(3000+"원");break;
						case "Medium":jtf.setText(4000+"원");break;
						case "Large":jtf.setText(5000+"원");break;
					}
					
				}
			});
			
		}
		add(jp, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		
		
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	
	public static void main(String[] args) {
		new TeamExam();
	}
}
