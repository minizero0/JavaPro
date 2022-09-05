package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarEngineTest extends JFrame{
	String arr[] = {"엔진 오일 교환", "자동 변속기 오일 교환", "에어콘 필터 교환", "타이어 교환"};
	int price[] = {45000, 80000, 30000, 100000};
	JCheckBox jcb[] = new JCheckBox[5];
	JLabel jlb;
	
	
	public void pro() {
		boolean flag = false;
		String str = "";
		int sum = 0;
		for (int i = 0 ; i < arr.length; i++) {
			if(jcb[i].isSelected()) {
				sum += price[i];
				flag = true;
			}
		}
		
		if (flag) {
			str = "총가격: " + sum + "원 입니다.";
		}
		else
			str = "아무것도 선택하지 않았습니다.";
		jlb.setText(str);
	}
	
	public CarEngineTest() {
		setLayout(new BorderLayout());
		JPanel p_center = new JPanel();
		JPanel p_down = new JPanel();
		p_center.setLayout(new GridLayout(5,2));
		
		p_center.add(new JLabel("수리"));
		p_center.add(new JLabel("가격(원)"));
		
		
		for (int i = 0; i < arr.length; i++) {
			jcb[i] = new JCheckBox(arr[i]);
			p_center.add(jcb[i]);
			p_center.add(new JLabel(price[i]+"원"));
			
			jcb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					pro();
					
				}
			});
		}
		
		jlb = new JLabel("아무것도 선택하지 않았습니다.");
		p_down.add(jlb);
		
		add(p_center, BorderLayout.CENTER);
		add(p_down, BorderLayout.SOUTH);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CarEngineTest();
	}

}
