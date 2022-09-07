package exam01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GoodsTest extends JFrame{
	
	private JTextArea jta;
	
	public GoodsTest() {
		jta = new JTextArea();
		setLayout(new BorderLayout());
		
		JButton btn = new JButton("상품 조회");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
