package exam03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SistNote02 extends JFrame {
	private JTextArea jta;
	private JFileChooser jfc;
	public JFrame f;
	
	public SistNote02() {
		jfc = new JFileChooser();
		f = this;
		setTitle("메모장");
		jta = new JTextArea(10,80);
		JScrollPane sj = new JScrollPane(jta);
		add(sj);
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		JMenuItem file_exit = new JMenuItem("종료");
		
		file.add(file_new);
		file.add(file_open);
		file.add(file_save);
		file.add(file_exit);
		
		file_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("");
				
				
			}
		});
		file_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int re = jfc.showOpenDialog(f);  //긍정 : 0, 부정 : 1
					File file = jfc.getSelectedFile();
					
					if (re == JFileChooser.APPROVE_OPTION)
					{
						String data = "";
						int ch;
						
						FileReader fr = new FileReader(file);
						while ((ch = fr.read()) != -1) {
							ch = fr.read();
							data += (char)ch;
						}
						fr.close();
						jta.setText(data);
						JOptionPane.showMessageDialog(null, "파일을 읽어왔음.");
					}
				}catch (Exception e1) {
					System.out.println("오류발생 : " + e1.getMessage());
				}
			}
		});
		file_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = jta.getText();
				//memo.txt
				try {
				int re = jfc.showSaveDialog(f);  //긍정 : 0, 부정 : 1
				if (re == JFileChooser.APPROVE_OPTION) {
					File file = jfc.getSelectedFile();
					FileWriter fw = new FileWriter(file);
					fw.write(data);
					fw.close();
					JOptionPane.showMessageDialog(null, "파일 저장완료");
					System.out.println("파일을 저장");
				}
				
			
				}catch (Exception e1) {
					System.out.println("에러 발생 :  " + e1.getMessage());
				}				
			}
		});
		file_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		
		
		jmb.add(file);
		
		setJMenuBar(jmb);		//frame 메뉴바 설정
		
		add(jta);
		setSize(400, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new SistNote02();
		
	}
}

