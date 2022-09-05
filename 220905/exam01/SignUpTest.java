package exam01;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SignUpTest extends JFrame{
	JTextField jtf01;
	JTextField jtf02;
	JRadioButton jrb01;
	JRadioButton jrb02;
	JCheckBox jcb01,jcb02,jcb03;
	ButtonGroup bg;
	
	
	public SignUpTest() {
		jtf01 = new JTextField(10);
		jtf02 = new JTextField(10);
		jrb01 = new JRadioButton("남");
		jrb02 = new JRadioButton("여");
		jcb01 = new JCheckBox("축구");
		jcb02 = new JCheckBox("농구");
		jcb03 = new JCheckBox("수영");
		bg = new ButtonGroup();
		JPanel a_center = new JPanel();
		JPanel c_center = new JPanel();
		JPanel p_center = new JPanel();
		JPanel b_center = new JPanel();
		
		setLayout(new GridLayout(5,2 ));
		bg.add(jrb01);
		bg.add(jrb02);
		a_center.setLayout(new FlowLayout());
		c_center.setLayout(new FlowLayout());
		a_center.add(jtf01);
		c_center.add(jtf02);
		
		
		p_center.setLayout(new FlowLayout());
		p_center.add(jrb01);
		p_center.add(jrb02);
		
		b_center.setLayout(new FlowLayout());
		b_center.add(jcb01);
		b_center.add(jcb02);
		b_center.add(jcb03);
		
		JLabel jlb1 = new JLabel("이름");
		JLabel jlb2 = new JLabel("성별");
		JLabel jlb3 = new JLabel("취미");
		JLabel jlb4 = new JLabel("주소");
		
		add(jlb1);
		add(a_center);
		add(jlb2);
		add(p_center);
		add(jlb3);
		add(b_center);
		add(jlb4);
		add(c_center);
		
		
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new SignUpTest();
	}

}
