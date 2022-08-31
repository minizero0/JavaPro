package exam01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JMenu draw_Color = new JMenu("그리기 색상");
		JMenuItem draw_line = new JMenuItem("선");
		JMenuItem draw_rect = new JMenuItem("사각형");
		JMenuItem draw_oval = new JMenuItem("원");
		JMenuItem draw_red = new JMenuItem("빨강");
		JMenuItem draw_green = new JMenuItem("초록");
		JMenuItem draw_blue = new JMenuItem("파랑");
		JMenuItem draw_black = new JMenuItem("검정");
		
		draw_line.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dp.drawType = 0;
				
			}
		});
		draw_rect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dp.drawType = 1;
				
			}
		});
		draw_oval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dp.drawType = 2;
				
			}
		});
		draw_red.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dp.drawColor = Color.red;
				
			}
		});
		draw_green.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dp.drawColor = Color.green;
				
			}
		});
		draw_blue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dp.drawColor = Color.blue;
				
			}
		});
		draw_black.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dp.drawColor = Color.black;
				
			}
		});
		
		
		draw.add(draw_line);
		draw.add(draw_rect);
		draw.add(draw_oval);
		
		jmb.add(draw);
		
		draw_Color.add(draw_red);
		draw_Color.add(draw_green);
		draw_Color.add(draw_blue);
		draw_Color.add(draw_black);
		
		jmb.add(draw_Color);
		
		setJMenuBar(jmb);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new MyFrame();
	}

}
