package exam01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	private DrawPanel dp;
	private JFrame f;
	private JFileChooser jfc;
	
	public MyFrame() {
		jfc = new JFileChooser("/Users/mini0/Desktop");
		f = this;
		dp = new DrawPanel();
		add(dp);
		
		JMenuBar jmb = new JMenuBar();
		JMenu draw = new JMenu("그리기 도구");
		
		JMenuItem draw_line = new JMenuItem("선");
		JMenuItem draw_rect = new JMenuItem("사각형");
		JMenuItem draw_oval = new JMenuItem("원");
		
		JMenu draw_Color = new JMenu("그리기 색상");
		JMenuItem draw_red = new JMenuItem("빨강");
		JMenuItem draw_green = new JMenuItem("초록");
		JMenuItem draw_blue = new JMenuItem("파랑");
		JMenuItem draw_black = new JMenuItem("검정");
		
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
					int re = jfc.showOpenDialog(f);
					if(re == JFileChooser.APPROVE_OPTION){
						
					
					File file = jfc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					
					dp.list = (ArrayList<GraphicInfo>)ois.readObject();
					dp.repaint();
					}
				}catch (Exception ex) {
					System.out.println("예외발생:" + ex.getMessage());
				}
				
			}
		});
		file_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int re = jfc.showSaveDialog(f);
					
					if(re == JFileChooser.APPROVE_OPTION) {
						
					File file = jfc.getSelectedFile();
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(dp.list);
					oos.close();
					JOptionPane.showMessageDialog(null, "파일 저장 완료");
					}
				}catch (Exception ex) {
					System.out.println("예외발생 :" + ex.getMessage());
				}
				
			}
		});
		file_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		
		file.add(file_new);
		file.add(file_open);
		file.add(file_save);
		file.add(file_exit);
		jmb.add(file);
	
		
		setJMenuBar(jmb);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new MyFrame();
	}

}
