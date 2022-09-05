package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PapagoTest extends JFrame{
	JTextArea jta1;
	JTextArea jta2;
	JButton btn1;
	JButton btn2;
	
	
	public PapagoTest() {
		setLayout(new BorderLayout(50,50));
		JPanel jp1 = new JPanel();
		
		JPanel jp2 = new JPanel();
		
		
		
		jp1.setLayout(new GridLayout(1,1,10,10));
		jp2.setLayout(new FlowLayout());
		
		jta1 = new JTextArea("텍스트가 입력됩니다.\n몇개의 단어를 영어로\n 변환합니다.");
		JScrollPane jsp1 = new JScrollPane(jta1);
		jta2 = new JTextArea("Text가 입력됩니다.\n몇개의 단어를 English로\n변환합니다.");
		JScrollPane jsp2 = new JScrollPane(jta2);
		btn1 = new JButton("변환");
		btn2 = new JButton("취소");
		
		jp1.add(jsp1);
		jp1.add(jsp2);
		jp2.add(btn1);
		jp2.add(btn2);
		
		add(jp1, BorderLayout.CENTER);
		add(jp2, BorderLayout.SOUTH);
		
		
		setSize(500,400);
		setTitle("텍스트 변환");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new PapagoTest();
	}

}
