package TeamExam03;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

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
		JMenu file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("도형");
		JMenuItem file_open = new JMenuItem("선");
		JMenuItem file_save = new JMenuItem("원");
		JMenuItem file_exit = new JMenuItem("사각형");
		
		file_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		file_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		file_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("my.pan"));
					
				}catch(Exception ex) {
					System.out.println("예외발생 : " + ex.getMessage());
				}
				
			}
		});
		file_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setSize(400,300);
		setVisible(true);
	}

	
	
	public static void main(String[] args) {
		new MyFrame();
	}
	
}
