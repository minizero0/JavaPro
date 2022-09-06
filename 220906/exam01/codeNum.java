package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
		jtf1 = new JTextField(7);
		jtf2 = new JTextField(7);
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		
		JPanel jp1 = new JPanel(new FlowLayout());
		JPanel jp2 = new JPanel(new GridLayout(2, 2));
		JPanel jp3 = new JPanel(new GridLayout(2, 1));
		
		jlb1 = new JLabel("이름 : ");
		jlb2 = new JLabel("전화번호 : ");
		jlb3 = new JLabel("주소");
		
		btn1 = new JButton("저장");
		btn2 = new JButton("검색");
		btn3 = new JButton("종료");
		
		jp1.add(btn1);
		jp1.add(btn2);
		jp1.add(btn3);
		
		jp2.add(jlb1);
		jp2.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jlb3);
		jp3.add(jsp);
		
		add(jp1, BorderLayout.SOUTH);
		add(jp2, BorderLayout.NORTH);
		add(jp3, BorderLayout.CENTER);
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new codeNum();
	}

}
