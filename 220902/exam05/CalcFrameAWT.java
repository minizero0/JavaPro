package exam05;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrameAWT extends Frame {
	TextField jtf01;
	TextField jtf02;
	TextField jtf03;
	
	public CalcFrameAWT() {
		setLayout(new FlowLayout());
		Label label = new Label("+");
		
		jtf01 = new TextField(5);
		jtf02 = new TextField(5);
		jtf03 = new TextField(5);
		
		Button btn = new Button("=");
		
		add(jtf01);
		add(label);
		add(jtf02);
		add(btn);
		add(jtf03);
		
		setSize(500,300);
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(jtf01.getText());
				int b = Integer.parseInt(jtf02.getText());
				int result = a + b;
				jtf03.setText(result+"");
			}
		});
		
	}

	public static void main(String[] args) {
		new CalcFrame();
	}

}
