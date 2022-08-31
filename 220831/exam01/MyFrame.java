package exam01;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame{
	
	private DrawPanel dp;
	
	public MyFrame() {
		dp = new DrawPanel();
		add(dp);
		
		JMenuBar jmb = new JMenuBar();
		JMenu draw = new JMenu("그리기 도구");
		JMenuItem draw_line = new JMenuItem("선");
		JMenuItem draw_rect = new JMenuItem("사각형");
		JMenuItem draw_oval = new JMenuItem("원");
		
		draw.add(draw_line);
		draw.add(draw_rect);
		draw.add(draw_oval);
		
		jmb.add(draw);
		
		setJMenuBar(jmb);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new MyFrame();
	}

}
