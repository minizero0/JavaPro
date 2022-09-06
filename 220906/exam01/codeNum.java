package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class codeNum extends JFrame{
	
	JTextField jtf1,jtf2;
	JTextArea jta;
	ArrayList<String> list;
	JLabel jlb1,jlb2,jlb3;
	JButton btn1,btn2,btn3;
	
	public codeNum() {
		setLayout(new BorderLayout());
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		
		JPanel jp1 = new JPanel(new FlowLayout());
		
		jlb1 = new JLabel();
		jlb2 = new JLabel();
		jlb3 = new JLabel();
		
		btn1 = new JButton("저장");
		btn1 = new JButton("검색");
		btn1 = new JButton("종료");
		
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
