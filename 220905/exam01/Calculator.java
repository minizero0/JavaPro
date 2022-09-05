package exam01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	int op1,op2;
	String op;
	JTextField jta;
	JButton btn[] = new JButton[16];
	String s = "";
	int cnt = 0;
	
	public Calculator() {	
		String arr[] = {"7","8","9","*",		//버튼에 넣을 내용을 배열로 생성
						"4","5","6","-",
						"1","2","3","+",
						"C","0","=","/"
						};
		
		setLayout(new BorderLayout(1, 70));				
		JPanel jp = new JPanel(new GridLayout(4,4));		//4X4 GridLayout을 설정해 버튼 넣어주기 위한 패널 설정
		
		jta = new JTextField();
		for (int i = 0; i <arr.length; i++) {
			btn[i] = new JButton(arr[i]);
			jp.add(btn[i]);
			
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if (cmd == "+" || cmd == "-" || cmd == "/" || cmd == "*") {
//						if(cmd.equals("+") || cmd.equals("-") || ~~~ 이렇게 사용햐도됨.
						op1 = Integer.parseInt(s);
						op = cmd;
						jta.setText("");
						System.out.println(op1);
						System.out.println(op);
						s = "";
					}
					else if (cmd == "=") {
						op2 = Integer.parseInt(s);
						switch (op) {
							case "+": jta.setText((op1+op2)+"");break;
							case "-": jta.setText((op1-op2)+"");break;
							case "*": jta.setText((op1*op2)+"");break;
							case "/": jta.setText((op1/op2)+"");break;
						}
					}
					else if (cmd == "C") {
						jta.setText("");
						s = "";
					}
					else {
						s += cmd;
						jta.setText(s);
					}
				
				}
			});
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
