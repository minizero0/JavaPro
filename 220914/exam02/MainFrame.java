package exam02;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		setLayout(null);
		JButton btnSearch = new JButton("부서별 검색");
		setBounds(200,200,100,100);
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
