package exam01;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	String s1,s2;
	JTextField jta;
	JButton btn[] = new JButton[16];
	
	
	public Calculator() {
		String arr[] = {"7","8","9","X",
						"4","5","6","-",
						"1","2","3","+",
						"C","0","=","/"
						};
		setLayout(new BorderLayout(1, 70));
		JPanel jp = new JPanel(new GridLayout(4,4));
		
		jta = new JTextField();
		for (int i = 0; i <arr.length; i++) {
			btn[i] = new JButton(arr[i]);
			jp.add(btn[i]);
		}
		
		
		add(jta, BorderLayout.NORTH);
		add(jp, BorderLayout.CENTER);
		
		setSize(500, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Calculator();

	}

}
