package frameTest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FrameTest extends JFrame{
	
	JButton btn_search, btn_write, btn_bag, btn_signUp, btn_signIn;
	JComboBox<String> jcb;
	JTextField jtf;
	
	
	public FrameTest() {
		setLayout(new BorderLayout(30,30));
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,3,30,30));
		
		JPanel center_1 = new JPanel();
		center_1.setLayout(new BorderLayout());
		
		ImageIcon jacket = new ImageIcon("jacket.jpeg");
		JLabel jlb1 = new JLabel("<html><body>자켓<br/>가격 : 50000</body></html>");
		JButton btn1 = new JButton(jacket);
		center_1.add(btn1, BorderLayout.CENTER);
		center_1.add(jlb1, BorderLayout.SOUTH);
		center.add(center_1);
		
		JPanel center_2 = new JPanel();
		center_2.setLayout(new BorderLayout());
		JLabel jlb2 = new JLabel("<html><body>자켓<br/>가격 : 50000</body></html>");
		JButton btn2 = new JButton(jacket);
		center_2.add(btn2, BorderLayout.CENTER);
		center_2.add(jlb2, BorderLayout.SOUTH);
		center.add(center_2);
		
		JPanel center_3 = new JPanel();
		center_3.setLayout(new BorderLayout());
		JLabel jlb3 = new JLabel("<html><body>자켓<br/>가격 : 50000</body></html>");
		JButton btn3 = new JButton(jacket);
		center_3.add(btn3, BorderLayout.CENTER);
		center_3.add(jlb3, BorderLayout.SOUTH);
		center.add(center_3);
		
		JPanel center_4 = new JPanel();
		center_4.setLayout(new BorderLayout());
		JLabel jlb4 = new JLabel("<html><body>자켓<br/>가격 : 50000</body></html>");
		JButton btn4 = new JButton(jacket);
		center_4.add(btn4, BorderLayout.CENTER);
		center_4.add(jlb4, BorderLayout.SOUTH);
		center.add(center_4);
		
		JPanel center_5 = new JPanel();
		center_5.setLayout(new BorderLayout());
		JLabel jlb5 = new JLabel("<html><body>자켓<br/>가격 : 50000</body></html>");
		JButton btn5 = new JButton(jacket);
		center_5.add(btn5, BorderLayout.CENTER);
		center_5.add(jlb5, BorderLayout.SOUTH);
		center.add(center_5);
		
		JPanel center_6 = new JPanel();
		center_6.setLayout(new BorderLayout());
		JLabel jlb6 = new JLabel("<html><body>자켓<br/>가격 : 50000</body></html>");
		JButton btn6 = new JButton(jacket);
		center_6.add(btn6, BorderLayout.CENTER);
		center_6.add(jlb6, BorderLayout.SOUTH);
		center.add(center_6);
		
		JScrollPane jsp = new JScrollPane(center);
		add(center, BorderLayout.CENTER);
		
		
		btn_search = new JButton("검색");
		btn_write = new JButton("글쓰기");
		btn_bag = new JButton("장바구니");
		btn_signUp = new JButton("회원가입");
		btn_signIn = new JButton("로그인");
		
		String data[] = {"의류", "가전제품", "도서"};
		jcb = new JComboBox<String>(data);
		jtf = new JTextField(10);
		
		jp.add(jcb);
		jp.add(jtf);
		jp.add(btn_search);
		jp.add(btn_write);
		jp.add(btn_bag);
		add(jp, BorderLayout.NORTH);
		
		south.add(btn_signUp);
		south.add(btn_signIn);
		add(south, BorderLayout.SOUTH);
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new FrameTest();
	}
}
