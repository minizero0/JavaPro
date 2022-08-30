package TeamExam03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame {
	private LinePanel lp;
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("도형");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_line = new JMenuItem("선");
		JMenuItem file_circle = new JMenuItem("원");
		JMenuItem file_reck = new JMenuItem("사각형");
		JMenuItem file_exit = new JMenuItem("종료");
		
		file_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		file_line.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lp.setA(0);
				
			}
		});
		file_circle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lp.setA(1);
				
			}
		});
		file_reck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lp.setA(2);
			}
		});
		file_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		file.add(file_new);
		file.add(file_line);
		file.add(file_reck);
		file.add(file_circle);
		file.add(file_exit);
		
		jmb.add(file);
		
		setJMenuBar(jmb);
		setSize(400,300);
		setVisible(true);
	}

	
	
	public static void main(String[] args) {
		new MyFrame();
	}
	
}
