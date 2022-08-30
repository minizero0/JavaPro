package exam07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
	private LinePanel lp;
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		JMenuItem file_exit = new JMenuItem("종료");
		
		file_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		file_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("my.pan"));
					lp.list = (ArrayList<GraphicInfo>)ois.readObject();
					lp.repaint();
					ois.close();
				}catch(Exception ex) {
					System.out.println("예외발생 : " + ex.getMessage());
				}
				
				
			}
		});
		file_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("my.pan"));
					oos.writeObject(lp.list);
					oos.close();
					JOptionPane.showMessageDialog(null, "파일로 작성함");
				}catch (Exception ex) {
					System.out.println("예외발생: " + ex.getMessage());
				}
				
			}
		});
		file_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		file.add(file_new);
		file.add(file_open);
		file.add(file_save);
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
