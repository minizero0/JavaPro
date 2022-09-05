package TeamExam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.Text;

public class HomeWork01 extends JFrame{
	
	JTextField jtf;
	JLabel jlb1,jlb2;
	JButton btn1,btn2;
	int r = (int)(Math.random() *100 +1);
	
	public void RanNum(int n) {
		if (r == n)
			jlb2.setText("정답");
		else if (n < r)
			jlb2.setText("너무 낮습니다.");
		else 
			jlb2.setText("너무 높습니다.");
	}
	
	public HomeWork01() {
		
		setTitle("숫자게임");
		setLayout(new BorderLayout());
		JPanel jp = new JPanel(new FlowLayout());
		JPanel jp2 = new JPanel(new FlowLayout());
		jtf = new JTextField(5);
		jlb1 = new JLabel("숫자를 추측하시오 : ");
		jlb2 = new JLabel();
		
		jlb2.setHorizontalAlignment(JLabel.CENTER); 		//Label 가운데정렬 !
		
		btn1 = new JButton("다시 한번");
		btn2 = new JButton("종료");
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RanNum(Integer.parseInt(jtf.getText()));
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "정말로 종료할거야?");
				if (r == 0)
					System.exit(0);
			}
		});
		jp.add(jlb1);
		jp.add(jtf);
		jp2.add(btn1);
		jp2.add(btn2);
		add(jlb2, BorderLayout.CENTER);
		add(jp, BorderLayout.NORTH);
		add(jp2, BorderLayout.SOUTH);
		
		
		
		
		
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HomeWork01();
	}

}
